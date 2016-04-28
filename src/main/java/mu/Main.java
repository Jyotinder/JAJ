package main.java.mu;

import java.io.PrintWriter;
import java.lang.Exception;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import mu.MuLexer;
import mu.MuParser;

public class Main {

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			args = new String[] { "src/main/mu/test_block.mu" };
		}

		System.out.println("parsing: " + args[0]);

		MuLexer lexer = new MuLexer(new ANTLRFileStream(args[0]));
		MuParser parser = new MuParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.parse();
		PrintWriter writer = new PrintWriter("src/main/mu/input_block.txt");
		EvalVisitor visitor = new EvalVisitor(writer);
		visitor.visit(tree);
		writer.close();
	}
}