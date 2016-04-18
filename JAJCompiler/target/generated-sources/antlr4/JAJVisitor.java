// Generated from JAJ.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JAJParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JAJVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JAJParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(JAJParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(JAJParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JAJParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#funcBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBlock(JAJParser.FuncBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(JAJParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#funcstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncstat(JAJParser.FuncstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JAJParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(JAJParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(JAJParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(JAJParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JAJParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JAJParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(JAJParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#actualParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameters(JAJParser.ActualParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#actualParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameter(JAJParser.ActualParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(JAJParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(JAJParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(JAJParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(JAJParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(JAJParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link JAJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(JAJParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(JAJParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JAJParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JAJParser.TypeContext ctx);
}