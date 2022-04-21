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
import lib.symbolTable.exceptions.*;
import lib.errores.*;

public class SemanticFunctions {
	private ErrorSemantico errSem; //clase común de errores semánticos

	public SemanticFunctions() {
		errSem = new ErrorSemantico();
	}

	public void checkInt(Attributes at){
		if(at.type != Symbol.Types.INT){
			errSem.deteccion("Tipo esperado: INT", null);
		}
	}

	public void checkBool(Attributes at) {
		if(at.type != Symbol.Types.BOOL){
			errSem.deteccion("Tipo esperado: boolean",null);
		}
	}

	public void checkChar(Attributes at) {
		if(at.type != Symbol.Types.CHAR){
			errSem.deteccion("Tipo esperado: char",null);
		}
	}

	public void check2types(Attributes at1, Attributes at2, Attributes at){
		if((at2.type != null && at1.type == at2.type) || at2.type == null){
			at.type = at1.type;
		} else {
			errSem.deteccion("Tipos incorrectos",null);
		}
	}

	public void check2typesWithOperator(Attributes at1, Attributes at2, Attributes at3, Attributes at) {
		if((at1.type != at3.type || at2.type != at3.type) && at3.type != null){
			errSem.deteccion("Tipos incorrectos", null);
		} else { 
			at.type = at1.type;
		}
	}

	public void checkArray(SymbolTable ts, Token t, Attributtes at){
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
		Symbol s;
		try {
			s = ts.getSymbol(t.image);
			at.type = s.type;
		} catch(SymbolNotFoundException e) {
			errSem.deteccion(e, t);
		}
	}
}
