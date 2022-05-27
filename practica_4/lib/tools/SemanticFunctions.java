//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    SemanticFunctions.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************

package lib.tools;

import java.util.*;

import org.w3c.dom.Attr;

import traductor.Token;
import lib.attributes.*;
import lib.symbolTable.*;
import lib.symbolTable.Symbol.Types;
import lib.symbolTable.exceptions.*;
import lib.errores.*;

public class SemanticFunctions {
	private ErrorSemantico errSem; //clase común de errores semánticos

	public SemanticFunctions() {
		errSem = new ErrorSemantico();
	}
	
	/**
	 * Comprueba que el atributo sea de tipo INT. Si no lo es, devuelve un 
	 * error.
	 */
	public void checkInt(Attributes at){
		if(at.type != Symbol.Types.INT){
			errSem.deteccion("Tipo esperado: INT", at.token);
		}
	}

	/**
	 * Comprueba que el atributo sea de tipo BOOL. Si no lo es, devuelve un 
	 * error.
	 */
	public void checkBool(Attributes at) {
		if(at.type != Symbol.Types.BOOL){
			errSem.deteccion("Tipo esperado: boolean",at.token);
		}
	}

	/**
	 * Comprueba que el atributo sea de tipo CHAR. Si no lo es, devuelve un 
	 * error.
	 */
	public void checkChar(Attributes at) {
		if(at.type != Symbol.Types.CHAR){
			errSem.deteccion("Tipo esperado: char",at.token);
		}
	}
	
	/**
	 * Comprueba que los atributos at1 y at2 puedan ser comparados con un
	 * operador relacional.
	 */
	public void check2typesWithRelationalOperator(Attributes at1, Attributes at2, Attributes at3, Attributes at){
		if(at2.type == null) {
			at.type = at1.type;
			at.token = at1.token;
			at.dimension = at1.dimension;
			at.constante = at1.constante;
			at.code.addBlock(at1.code);
		} else if(at1.type.equals(at2.type) && at1.type != Symbol.Types.ARRAY){
			at.type = Symbol.Types.BOOL;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			at.constante = true;
			at.code.addBlock(at1.code);
			at.code.addBlock(at2.code);
			at.code.addBlock(at3.code);
		} else {
			at.type = Symbol.Types.UNDEFINED;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			at.constante = true;
			errSem.deteccion("Tipos incorrectos",at.token);
		}
	}

	/**
	 * Comprueba que los atributos at1 y at2 puedan ser comparados con un
	 * operador aritmético o con un operador booleano.
	 */
	public void check2typesWithOperator(Attributes at1, Attributes at2, Attributes at3, Attributes at) {
		if(at3.type != null && at2.type != null && (at1.type != at3.type|| at2.type != at3.type)){
			at.type = Symbol.Types.UNDEFINED;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			at.constante = true;
			errSem.deteccion("Tipos incorrectos", at.token);
		} else if(at3.type != null && at2.type != null){
			at.type = at1.type;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			at.constante = true;
			at.code.addBlock(at1.code);
			at.code.addBlock(at2.code);
			at.code.addBlock(at3.code);
		} else { 
			at.type = at1.type;
			at.token = at1.token;
			at.constante = at1.constante;
			at.dimension = at1.dimension;
			at.code.addBlock(at1.code);
		}
	}

	/**
	 * Comprueba que el token t sea tipo ARRAY. Si no lo es, devuelve un 
	 * error.
	 */
	public void checkArray(SymbolTable ts, Token t, Attributes at){
		Symbol s;
		try {
			s = ts.getSymbol(t.image);
			if(s.type != Symbol.Types.ARRAY) { 
				errSem.deteccion("Identificador usado no es un array", t);
			}
			else { 
				SymbolArray sa = (SymbolArray) s; 
				at.type = sa.baseType; 
			}
			Token k = at.token;
			at.token.image = t.image + "[" + k.image + "]";
			at.token.kind = t.kind;

		} catch(SymbolNotFoundException e){
			errSem.deteccion(e,t);
		}
	}

	/**
	 * Comprueba que el token t puede ser asignado a una variable.
	 */
	public void checkVariable(SymbolTable ts, Token t, Attributes at){
		Symbol s;
		try {
			s = ts.getSymbol(t.image);
			if(s.type == Symbol.Types.PROCEDURE || s.type == Symbol.Types.FUNCTION) errSem.deteccion("Se esperaban ()", t);
			else if(s.type == Symbol.Types.ARRAY) {
				SymbolArray sa = (SymbolArray)s;
				at.dimension = sa.maxInd + 1;
			}
			at.type = s.type;
			
		} catch(SymbolNotFoundException e) {
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	
	/**
	 * Inserta en la tabla de símbolos ts un SymbolArray con nombre t1, índice 
	 * mínimo 0, índice máximo t2-1 y tipo ARRAY. 
	 */
	public void insertArraySymbolTab(SymbolTable ts, Token t1, Attributes at, Token t2){
		try{
			int n = Integer.parseInt(t2.image);
			Symbol s = new SymbolArray(t1.image,0,n-1,at.type);
			s.dir = at.dir;
			int fin_dir = (int)at.dir + n-1;
			at.code.addComment(" Array variable \""+ t1.image+ "\", type "+at.type+", size " + n + ", level " +s.nivel+ ", address ["+ at.dir + ":" + fin_dir + "]!");
			ts.insertSymbol(s);
		} catch (AlreadyDefinedSymbolException e) {
			errSem.deteccion(e, t1);
		}
	}

	
	/**
	 * Inserta en la tabla de símbolos ts un Symbol del tipo correspondiente al 
	 * tipo de at.
	 */
	public void insertVariableSymbolTab(SymbolTable ts, Token t1, Attributes at){
		try{
			if(at.type == Symbol.Types.INT){
				Symbol s = new SymbolInt(t1.image);
				s.dir = at.dir;
				ts.insertSymbol(s);
				at.code.addComment(" Simple variable \"" + t1.image + "\", type " + at.type + ", level " + s.nivel + ", address [" + at.dir + "]");
			} else if (at.type == Symbol.Types.CHAR){
				Symbol s = new SymbolChar(t1.image);
				s.dir = at.dir;
				ts.insertSymbol(s);
				at.code.addComment(" Simple variable \"" + t1.image + "\", type " + at.type + ", level " + s.nivel + ", address [" + at.dir + "]");
			} else if (at.type == Symbol.Types.BOOL){
				Symbol s = new SymbolBool(t1.image);
				s.dir = at.dir;
				ts.insertSymbol(s);
				at.code.addComment(" Simple variable \"" + t1.image + "\", type " + at.type + ", level " + s.nivel + ", address [" + at.dir + "]");
			}
		} catch (AlreadyDefinedSymbolException e) {
			errSem.deteccion(e, t1);
		}
	}


	/**
	 * Inserta en la tabla de símbolos ts un SymbolProcedure de nombre t con la 
	 * lista de parámetros vacía. Además inserta en la tabla de símbolos el 
	 * bloque de secuencias.
	 */
	public SymbolProcedure insertProcedureSymbolTab(SymbolTable ts, Token t){
		SymbolProcedure p = new SymbolProcedure(t.image,new ArrayList<Symbol>());
		try{
			ts.insertSymbol(p);
		} catch(AlreadyDefinedSymbolException e){
			errSem.deteccion(e, t);
		}
		ts.insertBlock();
		return p;
	}

	/**
	 * Inserta en la tabla de símbolos ts un SymbolProcedure de nombre t con la 
	 * lista de parámetros vacía. Además inserta en la tabla de símbolos el 
	 * bloque de secuencias.
	 */
	public SymbolProcedure insertProcedureSymbolTabFirst(SymbolTable ts, Token t){
		SymbolProcedure p = new SymbolProcedure(t.image,new ArrayList<Symbol>());
		try{
			ts.insertSymbol(p);
		} catch(AlreadyDefinedSymbolException e){
			errSem.deteccion(e, t);
		}
		return p;
	}

	/**
	 * Inserta en la tabla de símbolos ts un SymbolFunction de nombre t con la 
	 * lista de parámetros vacía. Además inserta en la tabla de símbolos el 
	 * bloque de secuencias.
	 */
	public void insertFunctionSymbolTab(SymbolTable ts, Token t, Attributes at){
		try{
			ts.insertSymbol(new SymbolFunction(t.image,new ArrayList<Symbol>(),at.type));
		} catch(AlreadyDefinedSymbolException e){
			errSem.deteccion(e, t);
		}
		ts.insertBlock();
	}

	/**
	 * Comprueba que el token t se encuentre en la tabla de símbolos y sea una 
	 * función. 
	 * Asigna el at el tipo de return de la función.
	 */
	public void checkFunction(SymbolTable ts, Token t, Attributes at){
		SymbolFunction sf;
		Symbol s;
		try {
			s = ts.getSymbol(t.image);
			if(s instanceof SymbolFunction){
				sf = (SymbolFunction) s;
				at.type = sf.returnType;
			} else {
				errSem.deteccion("Se esperaba una invocación a función", t);
				at.type = s.type;
			}
			
		} catch(SymbolNotFoundException e) {
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	/**
	 * Comprueba que el tipo se pueda asignar. Debe ser de tipo int, char o 
	 * bool.
	 * Asigna a at el tipo del asignable.
	 */
	public void checkAsignable(SymbolTable ts, Token t, Attributes at){
		Symbol s;
		at.token = t;
		try{
			s = ts.getSymbol(t.image);
			if(s.type == Symbol.Types.ARRAY){
				at.type = Symbol.Types.UNDEFINED;
				errSem.deteccion("Falta el índice del array", t);
			} else if(s.type != Symbol.Types.INT && s.type != Symbol.Types.CHAR && s.type != Symbol.Types.BOOL){
				at.type = Symbol.Types.UNDEFINED;
				errSem.deteccion("Simbolo no asignable", t);
			} else {
				at.type = s.type;
			}
		} catch (SymbolNotFoundException e){
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	/**
	 * Comprueba que el tipo pueda ser asignado por la instrucción get (tipos 
	 * int y char)
	 */
	public void checkAsignableGet(Attributes at1){
		if(at1.type == null || (at1.type != Symbol.Types.INT && at1.type != Symbol.Types.CHAR)){
			errSem.deteccion("Tipo no asignable para la funcion get()", at1.token);
		}
		// } else if (at2.type != null && (at2.type != Symbol.Types.INT && at2.type != Symbol.Types.CHAR)){
		// 	errSem.deteccion("Tipo no asignable para la funcion get()", at2.token);
		// } 
	}

	/**
	 * Comprueba que el token t (identificador de un vector), se encuentra 
	 * dentro de la tabla de símbolos y que pertenece a un tipo base asignable.
	 * Comprueba que el tipo de la expresión del índice a la que se accede sea 
	 * un entero.
	 * Asigna a at el tipo de variable que es.
	 */
	public void checkAsignable(SymbolTable ts, Token t, Attributes at1, Attributes at){
		Symbol s;
		SymbolArray sa;
		at.token = t;
		try{	
			s = ts.getSymbol(t.image);
			if(s.type != Symbol.Types.ARRAY){
				at.type = Symbol.Types.UNDEFINED;
				errSem.deteccion("Simbolo no asignable", t);
			} else if(at1.type != Symbol.Types.INT){
				at.type = Symbol.Types.UNDEFINED;
				errSem.deteccion("Index debe ser de tipo: INT", t);
			}else {
				sa = (SymbolArray)s;
				at.type = sa.baseType;
			}
		} catch (SymbolNotFoundException e){
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	/**
	 * at1 y at2 contienen información dle tipo de un asignable y una expresión.
	 * Comprueba que ninguno de los tipos sean nulos y que sean del mismo tipo.
	 */
	public void checkAsignacion(Attributes at1, Attributes at2){
		if(at1.type == null  || at2.type == null){
			errSem.deteccion("Error de asignacion", at1.token);
		} else if(at1.type != at2.type){
				errSem.deteccion("Tipo esperado: "+at1.type, at2.token);
		}
	}

	/**
	 * Comprueba si el bloque actual (que se abrió más recientemente) 
	 * corresponde con una función. 
	 * at corresponde información del tipo de dato del que se está realizando 
	 * return.
	 * En caso de que no se encuentre dentro de una función, indica que no se 
	 * espera la instrucción return. 
	 * Si el tipo de return de la función no corresponde con el tipo del 
	 * return, muestra un error.
	 */
	public void checkFunction(Stack<Symbol> stack, Attributes at){
		if(stack.size()== 0) errSem.deteccion("No se esperaba instrucción return", at.token);
		else {
			Symbol s = stack.peek();
			if(s instanceof SymbolFunction){
				SymbolFunction sf;
				sf = (SymbolFunction)s;
				if(at.type == null || sf.returnType == null || sf.returnType != at.type) errSem.deteccion("El valor de retorno no es del tipo correcto. Se esperaba: " + sf.returnType, at.token);
			} else errSem.deteccion("Instrucción return fuera de función", at.token);
		}
	}

	/**
	 * Inserta un parámetro en la tabla de símbolos. El parámetro corresponde 
	 * con un  parámetro de un procedimiento o una función.
	 * t contiene el identificador del parámetro
	 * at contiene información sobre el procedimiento o la función donde se 
	 * está insertando el vector.
	 * at1 contiene información sobre el tipo base del parámetro
	 * Después de la ejecución inserta el parámetro en el bloque 
	 * correspondiente.
	 */
	public void insertParametro(SymbolTable ts, Attributes at, Attributes at1, Token t){
		Symbol s;
		if(at1.type != null && at1.parClass != null && at.token != null){
			s = ts.getSymbol(at.token.image);
			if(s instanceof SymbolProcedure){
				SymbolProcedure sf = (SymbolProcedure)s;
				if(t.image != null){
					if(at1.type == Symbol.Types.INT){
						sf.parList.add(new SymbolInt(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else if(at1.type == Symbol.Types.CHAR){
						sf.parList.add(new SymbolChar(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else if(at1.type == Symbol.Types.BOOL){
						sf.parList.add(new SymbolBool(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else {
						errSem.deteccion("Tipo no permitido", t);
					}
				}
			} else if(s instanceof SymbolFunction){
				SymbolFunction sf = (SymbolFunction)s;
				if(t.image != null){
					if(at1.type == Symbol.Types.INT){
						sf.parList.add(new SymbolInt(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else if(at1.type == Symbol.Types.CHAR){
						sf.parList.add(new SymbolChar(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else if(at1.type == Symbol.Types.BOOL){
						sf.parList.add(new SymbolBool(t.image,at1.parClass));
						insertVariableSymbolTab(ts, t, at1);
					} else {
						errSem.deteccion("Tipo no permitido", t);
					}
				}
			} else {
				errSem.deteccion("Tipo incorrecto", at.token);
			}
		} else {
			errSem.deteccion("No se encuentra el tipo del parámetro", t);
		}
	}

	/**
	 * Guarda en el atributo at el tipo de parámetro que se pasa en 
	 * parameterclass.
	 */
	public void insertParameterType(Attributes at, Symbol.ParameterClass parameterclass){
		at.parClass = parameterclass;
	}

	/**
	 * Guarda información sobre un parámetro a una función. 
	 * En la declaracción de un procedimiento o función, guarda información 
	 * acerca de cada uno de sus parámetros.
	 * Contiene en at1 el primer parámetro que debe ser comprobado en su 
	 * invocación y en at2 el resto de parámetros.
	 * Guarda en el procedimiento o en la función una lista de la clase
	 *  parámetro con la información necesaria para cada tipo de parámetro.
	 */ 
	public void saveInfoParameter(Attributes at, Attributes at1, Attributes at2){
		at.par.add(at1);
		at.code.addBlock(at1.code);
		if(at2.par.size()>0){
			at.code.addBlock(at2.code);
			for(Attributes e : at2.par) at.par.add(e);
		} 
		if(at2.token != null){
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + ", " + at2.token.image;
		} else {
			at.token = at1.token;
		}
		
	}

	/**
	 * Comprueba los parámetros de una invocación a procedimiento o función.
	 * Primero comprueba que la cantidad de parámetros que se pasan es igual a 
	 * la cantidad de parámetros que debe tener ese procedimiento o función.
	 * A continuación, se comprueba para cada parámetro que sean del mismo tipo.
	 * En caso de que un parámetro sea de tipo vector, debe comprobar que 
	 * tengan el mismo tipo base y la misma dimensión.
	 */
	public void comprobacionParametros(Attributes at, Token t, SymbolTable ts){
		try{
			Symbol s = ts.getSymbol(t.image);
			if(s instanceof SymbolProcedure){
				SymbolProcedure sf = (SymbolProcedure)s;
				if(sf.parList.size() == at.par.size()){
					int i = 0;
					for(Symbol s1 : sf.parList) {
						Attributes p = at.par.get(i);
						if(s1.type != p.type){
							errSem.deteccion("Se esperaba un parámetro del tipo " + s1.type,p.token );
						}
						if(s1.type == Symbol.Types.ARRAY){
							SymbolArray sa = (SymbolArray)s1;
							int l = p.dimension - 1;
							if(sa.maxInd != l){
								errSem.deteccion("Los vectores deben ser de la misma dimensión", t);
							}
						}
						if(s1.parClass == Symbol.ParameterClass.REF && p.constante){
							errSem.deteccion("Se esperaba un paso por referencia", p.token);
						}
						i++;	
					}
				} else {
					errSem.deteccion("Se esperaban " + sf.parList.size() + " parametros", at.token);
				}
			} else if(s instanceof SymbolFunction){
				SymbolFunction sf = (SymbolFunction)s;
				if(sf.parList.size() == at.par.size()){
					int i = 0;
					for(Symbol s1 : sf.parList) {
						Attributes p = at.par.get(i);
						if(s1.type != p.type){
							errSem.deteccion("Se esperaba un parámetro del tipo " + s1.type,p.token );
						}
						if(s1.type == Symbol.Types.ARRAY){
							SymbolArray sa = (SymbolArray)s1;
							int l = p.dimension - 1;
							if(sa.maxInd != l){
								errSem.deteccion("Los vectores deben ser de la misma dimensión", t);
							}
						}
						if(s1.parClass == Symbol.ParameterClass.REF && p.constante){
							errSem.deteccion("Se esperaba un paso por referencia", p.token);
						}
						i++;
					}
				} else {
					errSem.deteccion("Se esperaban " + sf.parList.size() + " parametros", t);
				}
			} else {
				errSem.deteccion("Se esperaba un procedimiento o función", t);
			}
		} catch(SymbolNotFoundException e){
			errSem.deteccion(e, t);
		}
	}

	/**
	 * La función comprueba que una invocación a un procedimiento no 
	 * corresponda con la invocación al prodimiento pasado como parámetro 
	 * (principal). El aargumento principal debe corresponder con el 
	 * procedimiento principal del programa.
	 */
	public void comprobarNoPrincipal(SymbolProcedure principal, Token t){
		if(principal.name.equals(t.image)){
			errSem.deteccion("No se puede invocar al método principal", t);
		}
	}

	/**
	 * Inserta un vector en la tabla de símbolos. El vector corresponde con un 
	 * parámetro de un procedimiento o una función.
	 * t1 contiene el identificador del vector
	 * t2 contiene la dimensión del vector
	 * at contiene información sobre el procedimiento o la función donde se 
	 * está insertando el vector.
	 * at1 contiene información sobre el tipo base del vector
	 * Después de la ejecución inserta el vector en el bloque correspondiente.
	 */
	public void insertVector(SymbolTable ts, Token t1, Token t2, Attributes at, Attributes at1){
		Symbol s;
		if(at1.type != null && at1.parClass != null && at.token != null){
			s = ts.getSymbol(at.token.image);
			if(s instanceof SymbolProcedure){
				SymbolProcedure sf = (SymbolProcedure)s;
				if(t1.image != null && t2.image != null){
					if(at1.type == Symbol.Types.INT || at1.type == Types.CHAR || at1.type == Symbol.Types.BOOL){
						sf.parList.add(new SymbolArray(t1.image,0,Integer.valueOf(t2.image)-1,at1.type));
						at1.dimension = Integer.valueOf(t2.image);
						insertArraySymbolTab(ts, t1, at1, t2);
					} 
				} else {
					errSem.deteccion("No se puede deter identificador o dimensión nulos", t1);
				}
			} else if(s instanceof SymbolFunction){
				SymbolFunction sf = (SymbolFunction)s;
				if(t1.image != null && t2.image != null){
					
					if(at1.type == Symbol.Types.INT || at1.type == Types.CHAR || at1.type == Symbol.Types.BOOL){
						sf.parList.add(new SymbolArray(t1.image,0,Integer.valueOf(t2.image)-1,at1.type));
						at1.dimension = Integer.valueOf(t2.image);
						insertArraySymbolTab(ts, t1, at1, t2);
					} 
				} else {
						errSem.deteccion("No se puede deter identificador o dimensión nulos", t1);
				}
			} else {
				errSem.deteccion("Tipo incorrecto", at.token);
			}
		} else {
			errSem.deteccion("No se encuentra el tipo del parámetro", t1);
		}
	}
	
}
