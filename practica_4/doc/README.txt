Práctica 1: Construcción de un analizador léxico para "adac"
Autores:
	César Borja Moreno 800675
	Nerea Gallego Sánchez 801950

Práctica 2: Construcción de un analizador sintáctico para "adac"

RECUPERACIÓN DE ERRORES:
    Se ha seguido una política de recuperación de errores en modo pánico.
    
    Al detectar la falta de un punto y coma al final de una instrucción, el 
    compilador salta todos los tokens que encuentra en la entrada hasta llegar 
    a la siguiente instrucción que contiene punto y coma.
    
    La falta de un token 'end' tras un bloque de sentencias, una instrucción de 
    bucle 'while' o una instrucción 'if', hace saltar esta misma política de 
    recuperación de errores, recuperando la ejecución al encontrar el siguente 
    token 'end' más próximo.

    Por último, ocurre lo mismo con la falta de un token de clausura de 
    paréntesis ')' en: las declaraciones de procedimientos y funciones, las 
    invocaciones a procedimientos y funciones, la instrucción de leer, la 
    instrucción de escribir, la instrucción de saltar una línea y expresiones 
    que requieren de paréntesis. Se saltan todos los tokens hasta encontrar el 
    siguiente token ')' más próximo.

Práctica 3: Construcción de un analizador semántico para "adac"

    El nivel atacado ha sido el nivel 4, por lo tanto, el lenguaje permite: el 
    uso de parámetros escalares y de vectores, tanto por valor como por 
    referencia en procedimientos y funciones. También permite realizar 
    declaraciones de variables simples y vectores. Además permite la 
    declaración anidada de procedimientos y funciones.

    Se ha añadido la clase Parameter. En ella se pasa información a cerca
    de los parámetros que tiene una función o procedimiento. Esta clase es
    de gran ayuda para realizar la comprobación de los parámetros y las invocaciones de las mismas.
    
    Además, cabe destacar que se han modificado algunas de las funciones que 
    han proporcionado los profesores de la asignatura. El principal ejemplo
    emaesto es la clase nticFunctions. En ella se han añadido funciones que 
    realizan comprobaciones de cada uno de los aspectos que permitir (o no 
    permitir) el lenguaje. Esta clase lanza un mensaje de error cuando la 
    comprobación detecta una invocación incorrecta en el código. También
    cabe destacar que se han añadido algunos campos a la clase Attributes. 
    Estos campos almacenan información de los tokens leidos y de los parámetros
    que se pasan.

Práctica 4: Generación de código para la máquina P

    Se ha aplicado optimización de código en las sentencias if-else y while.

    Se ha generado el código correspondiente al nivel 4 de evaluación.

    Las pruebas realizadas con el compilador construido han transcurrido de la siguiente manera:

        Se ha realizado una construcción gradual desde las expresiones hasta
        la construcción de procedimientos y funciones. Para garantizar el
        correcto funcionamiento de cada bloque se ha ido probando el código
        construido con el que ya se había hecho anteriormente.
        
        Dichas pruebas fueron mediante la comparación del código pcode generado 
        con el que genera el compilador proporcionado por los profesores de la 
        asignatura. Cuando los programas eran demasiado extensos y se podía 
        comprobar su corrección con la ejecución, se realizaba de esta manera.

        Cuando un bloque se había comprobado que funcionaba correctamente, se 
        procedía a construir el siguiente.

        Finalmente, se han realizado pruebas globales, ejecutanto los programas 
        proporcionados por los profesores de la asignatura, tanto como con los 
        programas propios presentados en la práctica 2.
    
    La organización del proyecto es la siguiente:

    practica_4/
    ├── build.xml
    ├── doc
    │   └── README.txt
    ├── lib
    │   ├── attributes
    │   │   ├── Attributes.java
    │   │   └── Parameter.java
    │   ├── errores
    │   │   └── ErrorSemantico.java
    │   ├── symbolTable
    │   │   ├── exceptions
    │   │   │   ├── AlreadyDefinedSymbolException.java
    │   │   │   └── SymbolNotFoundException.java
    │   │   ├── SymbolArray.java
    │   │   ├── SymbolBool.java
    │   │   ├── SymbolChar.java
    │   │   ├── SymbolFunction.java
    │   │   ├── SymbolInt.java
    │   │   ├── Symbol.java
    │   │   ├── SymbolProcedure.java
    │   │   └── SymbolTable.java
    │   └── tools
    │       ├── codeGeneration
    │       │   ├── CGUtils.java
    │       │   ├── CodeBlock.java
    │       │   ├── CodeElement.java
    │       │   ├── Comment.java
    │       │   ├── Label.java
    │       │   ├── PCodeInstruction.java
    │       │   └── XMLTag.java
    │       └── SemanticFunctions.java
    └── traductor
        └── adac_4.jj
