//*****************************************************************
// File:   Attributes.java
// Author: Nerea Gallego, César Borja
// Date:   enero 2022
//         Clase única para almacenar los atributos que pueden aparecer en el traductor de adac
//         Se hace como clase plana, por simplicidad. Los atributos que se pueden almacenar
//         se autoexplican con el nombre
//*****************************************************************
package lib.attributes;
import lib.symbolTable.*;
import traductor.Token;

public class Parameter {
    public boolean constante;
    public Symbol.Types type;
    public Token token;

    public Parameter(boolean b, Symbol.Types t, Token tok){
        constante = b;
        type = t;
        this.token = tok;
    }
}
