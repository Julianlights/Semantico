package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

("public") {return new Symbol(sym.PUBLIC, yychar, yyline, yytext());}
("private") {return new Symbol(sym.PRIVATE, yychar, yyline, yytext());}

("void") {return new Symbol(sym.VOID, yychar, yyline, yytext());}
("double") {return new Symbol(sym.DOUBLE, yychar, yyline, yytext());}
("char") {return new Symbol(sym.CHAR, yychar, yyline, yytext());}
("int") {return new Symbol(sym.INT, yychar, yyline, yytext());}
("String") {return new Symbol(sym.STRING, yychar, yyline, yytext());}
("float") {return new Symbol(sym.FLOAT, yychar, yyline, yytext());}
("class") {return new Symbol(sym.CLASS, yychar, yyline, yytext());}
("return") {return new Symbol(sym.RETURN, yychar, yyline, yytext());}


/* Tipo de dato String */
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

( " "|"" ) {return new Symbol(sym.nada, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

( "," | ", " | " ," ) {return new Symbol(sym.Coma, yychar, yyline, yytext());}

{L}({L}|{D})* {return new Symbol(sym.name, yychar, yyline, yytext());}
("," | " ," | " ,")("int") {return new Symbol(sym.ComaInt, yychar, yyline, yytext());}
("," | " ," | " ,")("double") {return new Symbol(sym.ComaDouble, yychar, yyline, yytext());}
("," | " ," | " ,")("char") {return new Symbol(sym.ComaChar, yychar, yyline, yytext());}
("," | " ," | " ,")("String") {return new Symbol(sym.ComaString, yychar, yyline, yytext());}
("," | " ," | " ,")("float") {return new Symbol(sym.ComaFloat, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
