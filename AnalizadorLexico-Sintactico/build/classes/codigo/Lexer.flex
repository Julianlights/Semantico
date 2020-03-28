package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_-]+
D=[0-9]+
C=[,]+
espacio=[ \t\r\n]+

%{
    public String lexeme;
%}
%%
("public") {lexeme=yytext(); return Reservada;}
("private") {lexeme=yytext(); return Reservada;}
("void") {lexeme=yytext(); return Reservada;}
("double") {lexeme=yytext(); return Reservada;}
("char") {lexeme=yytext(); return Reservada;}
("int") {lexeme=yytext(); return Reservada;}
("String") {lexeme=yytext(); return Reservada;}
("float") {lexeme=yytext(); return Reservada;}
("class") {lexeme=yytext(); return Reservada;}
("return") {lexeme=yytext(); return Reservada;}
(","|", "|" ,") {lexeme=yytext(); return Coma;}
"," {lexeme=yytext(); return Coma;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
("(") {lexeme=yytext(); return Parentesis_a;}
(")") {lexeme=yytext(); return Parentesis_c;}
(";") {lexeme=yytext(); return P_coma;}
("{") {lexeme=yytext(); return Llave_a;}
("}") {lexeme=yytext(); return Llave_c;}
(".") {lexeme=yytext(); return ERROR;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
({D}*{L}*)|({D}{L}*{D}*) {return ERROR;}
. {return   ERROR;}

