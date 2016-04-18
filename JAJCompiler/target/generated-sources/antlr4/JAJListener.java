// Generated from JAJ.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JAJParser}.
 */
public interface JAJListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JAJParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(JAJParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(JAJParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(JAJParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(JAJParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JAJParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JAJParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void enterFuncBlock(JAJParser.FuncBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void exitFuncBlock(JAJParser.FuncBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(JAJParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(JAJParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#funcstat}.
	 * @param ctx the parse tree
	 */
	void enterFuncstat(JAJParser.FuncstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#funcstat}.
	 * @param ctx the parse tree
	 */
	void exitFuncstat(JAJParser.FuncstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JAJParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JAJParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(JAJParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(JAJParser.While_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(JAJParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(JAJParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(JAJParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(JAJParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JAJParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JAJParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JAJParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JAJParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(JAJParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(JAJParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#actualParameters}.
	 * @param ctx the parse tree
	 */
	void enterActualParameters(JAJParser.ActualParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#actualParameters}.
	 * @param ctx the parse tree
	 */
	void exitActualParameters(JAJParser.ActualParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void enterActualParameter(JAJParser.ActualParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void exitActualParameter(JAJParser.ActualParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(JAJParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(JAJParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(JAJParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(JAJParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(JAJParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(JAJParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(JAJParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(JAJParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(JAJParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(JAJParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(JAJParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(JAJParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(JAJParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(JAJParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JAJParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JAJParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JAJParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JAJParser.TypeContext ctx);
}