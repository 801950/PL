Práctica 2: Construcción de un analizador sintáctico para "adac"

RECUPERACIÓN DE ERRORES:
    Se ha seguido una política de recuperación de errores en modo pánico.
    
    Al detectar la falta de un punto y coma al final de una instrucción, el compilador salta todos los tokens que encuentra en la entrada hasta llegar a la siguiente instrucción que contiene punto y coma.
    
    La falta de un token 'end' tras un bloque de sentencias, una instrucción de bucle 'while' o una instrucción 'if', hace saltar esta misma política de recuperación de errores, recuperando la ejecución al encontrar el siguente token 'end' más próximo.

    Por último, ocurre lo mismo con la falta de un token de clausura de paréntesis ')' en: las declaraciones de procedimientos y funciones, las invocaciones a procedimientos y funciones, la instrucción de leer, la instrucción de escribir, la instrucción de saltar una línea y expresiones que requieren de paréntesis. Se saltan todos los tokens hasta encontrar el siguiente token ')' más próximo.
