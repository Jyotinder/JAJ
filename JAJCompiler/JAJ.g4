/**
 * Grammar for JAJ
 * Created By: Ayush Gupta
 * 			   Jeme John 
 * 			   Jyotinder Singh
 * Created on: 04/09/2016
 */
 
grammar JAJ;

root	:	ifCondition
	 	|	assignment
	 	|	functionDecl
	 	|	functionCall
	 	;
parse
	:	block
	;
	
block
 : stat*
 ;
 
funcBlock	:	funcstat*
			;

stat
 : assignment
 | varDecl
 | ifCondition
 | while_stat
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 | functionDecl
 | functionCall
 ;

funcstat
 : stat
 | 'return' expr
 ;
 
assignment
 : ID ASSIGN expr ';'
 ;

while_stat
 : WHILE '(' relational ')' '{' block '}'
 ;


ifCondition		:	(IF '(' relational ')' '{' block '}')+ (ELSEIF '(' relational ')' '{' block '}')* (ELSE '{' block '}' )?
				;

functionDecl	:	type ID '(' formalParameters? ')' '{' funcBlock '}' // "void f(int x) {...}"
				;

formalParameters	:	formalParameter (',' formalParameter)*
					;

formalParameter
	:	type ID
	;

functionCall
	:	ID '(' actualParameters? ')' ';' // "void f(int x) {...}"
	;

actualParameters
	:	actualParameter (',' actualParameter)*
	;

actualParameter	:	ID	;

relational	:	left=expr op=(GREATER|LESS|EQUALCOMP|GREATEREQUAL|LESSEQUAL) right=expr     
			;
			
expr	:	left=expr op=('*'|'/') right=expr      # MulDiv
    	|	left=expr op=('+'|'-') right=expr      # AddSub
    	|	INTVAL                         		   # int
    	|	ID                          		   # id
    	|	'(' expr ')'                		   # parens
    	;

varDecl	:	type ID	(ASSIGN INTVAL)? ';'
		;

type	:	INT
	 	|	VOID
	 	;
MULDIV	:	'*' | '/'	;
W	:	[ \t\r\n]+ -> skip	;
IF	: 'if'	;
ELSEIF	:	'else if'	;
ELSE	:	'else'	;
GREATER	: '>' ;
LESS	: '<' ;
GREATEREQUAL	:	'>='	;
LESSEQUAL	: '<='	;
EQUALCOMP	: '=='	;
INTVAL	:	'-'?[0-9]+	;
INT	: 'int'	;
VOID	: 'void'	; 
BOOLEAN	: 'true'
	   	| 'false'
	   	;
ID	:	[a-z]+	;	

WHILE	:	'while'	;
ASSIGN	:	'='	;
OTHER
 : . 
 ;