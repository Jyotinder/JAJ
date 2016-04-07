grammar Hello;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   loop NEWLINE                # whileLoop
    |   relational NEWLINE          # relat
    |   NEWLINE                     # blank 
    ;

expr:   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

relational:     expr op=(GREATER|LESS) expr     # GreaterEqual
          ;

loop:   'while' '('relational')' NEWLINE? '{'stat*'}'   #while
    ;

GREATER : '>' ;
LESS : '<' ;
MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
