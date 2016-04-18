import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

public class MainFile {
	public static void main(String[] args) {
		String inputstr = "if(a<b){a=b;int a = 10;}";
		ANTLRInputStream input = new ANTLRInputStream(inputstr); // create a lexer that feeds off of input CharStream
		JAJLexer lexer = new JAJLexer(input); // create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
		JAJParser parser = new JAJParser(tokens);
		ParseTree tree = parser.stat(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		JAJVisitorImpl visitor = new JAJVisitorImpl();
		String res = visitor.visit(tree);
		System.out.println(res);
	}
}
