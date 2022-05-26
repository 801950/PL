//*****************************************************************
// File:   Attributes.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   enero 2022
//         Clase única para almacenar los atributos que pueden aparecer en el traductor de adac
//         Se hace como clase plana, por simplicidad. Los atributos que se pueden almacenar
//         se autoexplican con el nombre
//*****************************************************************

package lib.attributes;
import lib.symbolTable.*;

import java.util.ArrayList;
import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;
import traductor.Token;
import lib.tools.codeGeneration.CodeBlock;

public class Attributes implements Cloneable {
    public Symbol.Types type;
    public Symbol.ParameterClass parClass;

    public int valInt;
    public boolean valBool;
    public char valChar;
    public String valString;
    public boolean constante;
    public ArrayList<Attributes> par;

    public Token token;

    public int dimension;
    public long dir;
    public int nivel;

    public CodeBlock code = new CodeBlock();

    public Attributes(){
        type = null;
        par = new ArrayList<Attributes>();
    }

    public Attributes(Symbol.Types tipo) {
        type = tipo;
        par = new ArrayList<Attributes>();
    }
    

    public Attributes clone() {
    	try {
    		return (Attributes) super.clone();
    	}
    	catch (CloneNotSupportedException e) {
    		return null; 
    	}
    }

    public String toString() {
        return
            "type = " + type + "\n" +
            "parClass = " + parClass + "\n" +
            "token = " + token.image + "\n" +
            "constante = " + constante + "\n";
            //COMPLETAR
    }
}
