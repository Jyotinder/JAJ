// Generated from Hello.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(HelloParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(HelloParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(HelloParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(HelloParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(HelloParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(HelloParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(HelloParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(HelloParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relat}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRelat(HelloParser.RelatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relat}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRelat(HelloParser.RelatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(HelloParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(HelloParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(HelloParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(HelloParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(HelloParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(HelloParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(HelloParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(HelloParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(HelloParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(HelloParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(HelloParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(HelloParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterEqual}
	 * labeled alternative in {@link HelloParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqual(HelloParser.GreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterEqual}
	 * labeled alternative in {@link HelloParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqual(HelloParser.GreaterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile(HelloParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile(HelloParser.WhileContext ctx);
}