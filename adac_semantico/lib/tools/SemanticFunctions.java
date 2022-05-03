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

	public void checkInt(Attributes at){
	//	System.err.println("CheckInt");
		if(at.type != Symbol.Types.INT){
			errSem.deteccion("Tipo esperado: INT", at.token);
		}
	}

	public void checkBool(Attributes at) {
	//	System.err.println("CheckBool");
		if(at.type != Symbol.Types.BOOL){
			errSem.deteccion("Tipo esperado: boolean",at.token);
		}
	}

	public void checkChar(Attributes at) {
	//	System.err.println("CheckChar");
		if(at.type != Symbol.Types.CHAR){
			errSem.deteccion("Tipo esperado: char",at.token);
		}
	}

	public void check2typesWithRelationalOperator(Attributes at1, Attributes at2, Attributes at3, Attributes at){
	//	System.err.println(at1.type +" " +  at2.type);
	//	System.err.println("check2types");
		if(at2.type == null) {
		//	System.err.println("	1 componente");
			at.type = at1.type;
			at.token = at1.token;
		} else if(at1.type.equals(at2.type)){
			at.type = Symbol.Types.BOOL;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
		} else {
		//	System.err.println("	" + at2.type);
			at.type = Symbol.Types.UNDEFINED;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			errSem.deteccion("Tipos incorrectos",at.token);
		}
	}

	public void check2typesWithOperator(Attributes at1, Attributes at2, Attributes at3, Attributes at) {
		// System.err.println(at1.type +" " +  at2.type);
		// System.err.println("check2typesWithOperator");
		// System.err.println(at1.type == null);
		if(at3.type != null && at2.type != null && (at1.type != at3.type|| at2.type != at3.type)){
		//	System.err.println("	" + at2.type + " " + at3.type);
			at.type = Symbol.Types.UNDEFINED;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
			errSem.deteccion("Tipos incorrectos", at.token);
		} else if(at3.type != null && at2.type != null){
		//	System.err.println("	" + at2.type + " " + at3.type);
			at.type = at1.type;
			at.token = new Token(at1.token.kind);
			at.token.beginLine = at1.token.beginLine;
			at.token.beginColumn = at1.token.beginColumn;
			at.token.endLine = at2.token.endLine;
			at.token.endColumn = at2.token.endColumn;
			at.token.image = at1.token.image + " " + at3.token.image + " " + at2.token.image;
		} else { 
		//	System.err.println("	" + at1.type);
			at.type = at1.type;
			at.token = at1.token;
		}
	}

	public void checkArray(SymbolTable ts, Token t, Attributes at){
	//	System.err.println("checkArray");
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

		} catch(SymbolNotFoundException e){
			errSem.deteccion(e,t);
		}
	}

	public void checkVariable(SymbolTable ts, Token t, Attributes at){
	//	System.err.println("checkVariable");
		Symbol s;
		try {
			s = ts.getSymbol(t.image);
			if(s.type == Symbol.Types.PROCEDURE || s.type == Symbol.Types.FUNCTION) errSem.deteccion("Se esperaban ()", t);
			else if(s.type == Symbol.Types.ARRAY) errSem.deteccion("Se esperaban []", t);
			at.type = s.type;
		} catch(SymbolNotFoundException e) {
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	public void insertArraySymbolTab(SymbolTable ts, Token t1, Attributes at, Token t2){
		try{
			ts.insertSymbol(new SymbolArray(t1.image,0,Integer.parseInt(t2.image)-1,at.type));
		} catch (AlreadyDefinedSymbolException e) {
			errSem.deteccion(e, t1);
		}
	}

	public void insertVariableSymbolTab(SymbolTable ts, Token t1, Attributes at){
		try{
			if(at.type == Symbol.Types.INT){
				ts.insertSymbol(new SymbolInt(t1.image));
			} else if (at.type == Symbol.Types.CHAR){
				ts.insertSymbol(new SymbolChar(t1.image));
			} else if (at.type == Symbol.Types.BOOL){
				ts.insertSymbol(new SymbolBool(t1.image));
			}
		} catch (AlreadyDefinedSymbolException e) {
			errSem.deteccion(e, t1);
		}
	}


	public void insertProcedureSymbolTab(SymbolTable ts, Token t){
		try{
			ts.insertSymbol(new SymbolProcedure(t.image,null));
		} catch(AlreadyDefinedSymbolException e){
			errSem.deteccion(e, t);
		}
		ts.insertBlock();
	}

	public void insertFunctionSymbolTab(SymbolTable ts, Token t, Attributes at){
		try{
			ts.insertSymbol(new SymbolFunction(t.image,null,at.type));
		} catch(AlreadyDefinedSymbolException e){
			errSem.deteccion(e, t);
		}
		ts.insertBlock();
	}

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

	public void checkAsignable(SymbolTable ts, Token t, Attributes at){
		Symbol s;
		at.token = t;
//		System.out.println("Check asignable");
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
	//		System.out.println(at);
		} catch (SymbolNotFoundException e){
			at.type = Types.UNDEFINED;
			errSem.deteccion(e, t);
		}
	}

	public void checkAsignableGet(Attributes at1, Attributes at2){
//		System.out.println("Check get");

		if(at1.type == null || (at1.type != Symbol.Types.INT && at1.type != Symbol.Types.CHAR)){
			errSem.deteccion("Tipo no asignable para la funcion get()", at1.token);
		} else if (at2.type != null && (at2.type != Symbol.Types.INT && at2.type != Symbol.Types.CHAR)){
			errSem.deteccion("Tipo no asignable para la funcion get()", at2.token);
		}
	}

	public void checkAsignable(SymbolTable ts, Token t, Attributes at1, Attributes at){
	//	System.err.println("checkAsignable");
		Symbol s;
		SymbolArray sa;
		at.token = t;
		try{
			
			s = ts.getSymbol(t.image);
		//	System.err.println("	" + s.type);
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

	public void checkAsignacion(Attributes at1, Attributes at2){
		// System.err.println(at1.type +" " +  at2.type);
		if(at1.type == null  || at2.type == null){
			errSem.deteccion("Error de asignacion", at1.token);
		} else if(at1.type != at2.type){
				errSem.deteccion("Tipo esperado: "+at1.type, at2.token);
		}
	}

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

	// public void checkReturn(SymbolFunction sf, Attributes at){
	// 	if(at.type == null || sf.returnType == null || sf.returnType != at.type) errSem.deteccion("El valor de retorno no es del tipo correcto. Se esperaba: " + sf.returnType, at.token);
	// }
}
