package main.java.mu;

import java.io.PrintWriter;
import java.lang.Exception;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import mu.JAJLexer;
import mu.JAJParser;
import mu.MuLexer;
import mu.MuParser;

public class Main {

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			args = new String[] { "test_exp.jaj" };
		}

		System.out.println("parsing: " + args[0]);

		MuLexer lexer = new MuLexer(new ANTLRFileStream("src/main/mu/"+args[0]));
		MuParser parser = new MuParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.parse();
		PrintWriter writer = new PrintWriter("src/main/mu/"+args[0]+"i");
		EvalVisitor visitor = new EvalVisitor(writer);
		visitor.visit(tree);
		writer.close();
	}
}