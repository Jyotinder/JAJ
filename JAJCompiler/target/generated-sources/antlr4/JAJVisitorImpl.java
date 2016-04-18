/**
 * Visitor Class for JAJ
 * Created By: Ayush Gupta
 * 			   Jeme John 
 * 			   Jyotinder Singh
 * Created on: 04/09/2016
 */

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class JAJVisitorImpl extends JAJBaseVisitor<String>{
	@Override
	public String visitFunctionDecl(JAJParser.FunctionDeclContext ctx) {
		/*String res = "FSTART\nFNAME " + ctx.ID().getText();
		res += "\nRTYPE " + visit(ctx.type()) + "\n";
		res += "PSTART\n";
		if(ctx.formalParameters() != null){
			res += visit(ctx.formalParameters());
		}
		res += "PEND\n";
		res += visit(ctx.block());
		res += "FEND\n";*/
		String res = ctx.ID().getText() + "_START ";
		if(ctx.formalParameters() != null){
			res += visit(ctx.formalParameters());
		}
		res += "\n";
		res += visit(ctx.funcBlock());
		return res;
	}
	
	@Override
	public String visitRelational(JAJParser.RelationalContext ctx){
		String res = "";
		String oper = ctx.op.getText();
		switch (oper){
			case ">":
				res += "GT ";
				break;
			case "<":
				res += "LT ";
				break;
			case "==":
				res += "CMP ";
				break;
			case ">=":
				res += "GTE ";
				break;
			case "<=":
				res += "LTE ";
				break;
		}
		res += visit(ctx.left) + " " + visit(ctx.right);
		return res;
	}

	@Override
	public String visitParens(JAJParser.ParensContext ctx) {
		return visit(ctx.expr());
	}
	
	@Override
	public String visitStat(JAJParser.StatContext ctx) {
		String res = "";
		if(ctx.assignment() != null){
			res += visit(ctx.assignment());
		}
		else if (ctx.varDecl() != null){
			res += visit(ctx.varDecl());
		}
		else if(ctx.ifCondition() != null){
			res += visit(ctx.ifCondition());
		}
		else if (ctx.while_stat() != null){
			res += visit(ctx.while_stat());
		}
		else if (ctx.functionDecl() != null){
			res += visit(ctx.functionDecl());
		}
		else if (ctx.functionCall() != null){
			res += visit(ctx.functionCall());
		}
		return res;
	}

	@Override
	public String visitMulDiv(JAJParser.MulDivContext ctx) {
		// TODO Auto-generated method stub
		String res = "";
		String a = ctx.op.getText();
		if (ctx.op.getText().equals("*") ){
			res += "MUL ";
		}
		else{
			res += "DIV ";
		}
		res += ctx.expr(0).getText() + " " + ctx.expr(1).getText() + "\n";   
		return res;
	}

	@Override
	public String visitAddSub(JAJParser.AddSubContext ctx) {
		String res = "";
		res += visit(ctx.expr(0));
		if (ctx.op.getText().equals("+")){
			res += "ADD";
		}
		else{
			res += "SUB ";
		}
		res += ctx.expr(0) + " " + ctx.expr(1) + " ";   
		return res;
	}

	@Override
	public String visitType(JAJParser.TypeContext ctx) {
		if(ctx.INT() != null){
			return ctx.INT().getText();
		}
		else if (ctx.VOID() != null){
			return ctx.VOID().getText();
		}
		return null;
	}

	@Override
	public String visitActualParameters(JAJParser.ActualParametersContext ctx) {
		String res = "";
		for(int i=0; i< ctx.actualParameter().size(); i++){
			res += visitActualParameter(ctx.actualParameter(i)) + " ";
		}
		return res;
	}

	@Override
	public String visitInt(JAJParser.IntContext ctx) {
		return ctx.INTVAL().getText();
	}

	@Override
	public String visitIfCondition(JAJParser.IfConditionContext ctx) {
		String res = "IF_START\n";
		res += "COND_START\n" + visit(ctx.relational(0)) + "\nCOND_END\n" + visit(ctx.block(0));
		res += "IF_END";
		for(int i=0; i < ctx.ELSEIF().size(); i++){
			res += "ELSEIF_START\n";
			res += "COND_START\n" + visit(ctx.relational(i+1)) + "\nCOND_END\n" + visit(ctx.block(i+1));
			res += "ELSEIF_END\n";
		}
		if(ctx.ELSE() != null){
			res += "ELSE_START\n";
			res += visit(ctx.block(ctx.block().size()-1));
			res += "ELSE_END\n";
		}
		return res;
	}

	@Override
	public String visitRoot(JAJParser.RootContext ctx) {
		if(ctx.ifCondition() != null){
			return visit(ctx.ifCondition());
		}
		else if(ctx.functionDecl() != null){
			return visit(ctx.functionDecl());
		}
		else if(ctx.functionCall() != null){
			return visit(ctx.functionCall());
		}
		return null;
	}

	@Override
	public String visitFunctionCall(JAJParser.FunctionCallContext ctx) {
		/*String res = "FCALL_START\n";
		res += "FID " + ctx.ID().getText() + "\n";
		res += "PSTART\n";
		if(ctx.actualParameters() != null){
			res += visit(ctx.actualParameters());
		}
		res += "PEND\n";
		res += "FCALL_END\n";
		 */
		String res = "CALL ";
		res += ctx.ID().getText() + " ";
		res += visit(ctx.actualParameters());
		return res;
	}

	@Override
	public String visitActualParameter(JAJParser.ActualParameterContext ctx) {
		// String res = "PID " + ctx.ID().getText() + "\n";
		String res = ctx.ID().getText();
		return res;
	}

	@Override
	public String visitFormalParameters(JAJParser.FormalParametersContext ctx) {
		String res = "";
		for(int i=0; i< ctx.formalParameter().size(); i++){
			res += visitFormalParameter(ctx.formalParameter(i)) + " ";
		}
		return res;
	}
	
	@Override
	public String visitBlock(JAJParser.BlockContext ctx) {
		/*String res = "BSTART\n";
		for(int i=0; i<ctx.stat().size();i++){
			res += visit(ctx.stat(i)) + "\n";
		}
		res += "\nBEND\n";
		 */
		String res = "";
		for (int i=0; i<ctx.stat().size();i++){
			res += visit(ctx.stat(i));
		}
		return res;
	}
	
	@Override
	public String visitFuncBlock(JAJParser.FuncBlockContext ctx) {
		/*String res = "BSTART\n";
		for(int i=0; i<ctx.stat().size();i++){
			res += visit(ctx.stat(i)) + "\n";
		}
		res += "\nBEND\n";
		 */
		String res = "";
		for (int i=0; i<ctx.funcstat().size();i++){
			res += visit(ctx.funcstat(i)) + "\n";
		}
		return res;
	}

	@Override
	public String visitFuncstat(JAJParser.FuncstatContext ctx) {
		String res = "";
		if(ctx.stat() != null){
			res += visit(ctx.stat()) + "\n";
		}
		else if (ctx.expr() != null){
			res += "RET" + visit(ctx.expr()) + "\n";
		}
		return res;
	}

	@Override
	public String visitId(JAJParser.IdContext ctx) {
		return ctx.ID().getText();
	}
		
	@Override
	public String visitFormalParameter(JAJParser.FormalParameterContext ctx) {
		/*String res = "PTYPE " + visit(ctx.type()) + "\n";
		res += "PID " + ctx.ID().getText() + "\n";
		*/
		String res = ctx.ID().getText();
		return res;
	}

	@Override
	public String visitParse(JAJParser.ParseContext ctx) {
		return visit(ctx.block());
	}

	@Override
	public String visitAssignment(JAJParser.AssignmentContext ctx) {
		String res = "";
		res += "MOV " + ctx.ID().getText() + " " + ctx.expr().getText() + "\n";
		return res;
	}

	@Override
	public String visitWhile_stat(JAJParser.While_statContext ctx) {
		String res = "";
		return res;
	}

	@Override
	public String visitVarDecl(JAJParser.VarDeclContext ctx) {
		return "VAR_" + ctx.ID().getText() + " " + ctx.INTVAL().getText() + "\n";
	}
}
