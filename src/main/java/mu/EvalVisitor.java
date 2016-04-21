package main.java.mu;


import org.antlr.v4.runtime.misc.NotNull;

import mu.MuBaseVisitor;
import mu.MuParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class EvalVisitor extends MuBaseVisitor<Value> {

    // used to compare floating point numbers
	public int LabelCount = 0;
    public static final double SMALL_VALUE = 0.00000000001;

    // store variables (there's only one global scope!)
    private Map<String, Value> memory = new HashMap<String, Value>();

    // assignment/id overrides
    @Override
    public Value visitAssignment(MuParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = null;
        if(ctx.stack_top() != null){
        	System.out.println("TOPS VAR_"+ctx.stack_top().ID());
        	System.out.println("MOV VAR_"+ctx.getChild(0).toString()+" EAX");
        }
        else if(ctx.functionCall() != null){ 
        	value = this.visit(ctx.functionCall()); 
        	System.out.println("MOV VAR_"+ctx.getChild(0).toString()+" "+value);
            
        }
        
        else if (isInteger(ctx.expr().getText())) {
        	System.out.println("VAR_" + ctx.getChild(0).toString() + " " + ctx.expr().getText());
    	}
        else{
        	value = visit(ctx.expr());
        	System.out.println("MOV VAR_"+ctx.getChild(0).toString()+" "+value);
            
        }
        return memory.put(id, value);
    }
    
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }
    
    public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
    }

    
    @Override 
    public Value visitFunctionDefinition(MuParser.FunctionDefinitionContext ctx) { 
    	//System.out.println(ctx.ID(0).toString().toUpperCase()+"_START");
    	String s = ctx.ID(0).toString().toUpperCase()+"_START";
    	for(int i=1; i < ctx.ID().size();i++){
    		s = s+ " VAR_"+ctx.ID(i).getText();
    	}
    	System.out.println(s);
    	
    	visitChildren(ctx); 
    	System.out.println(ctx.ID(0).toString().toUpperCase()+"_END");
    	return null;
    }
    
    @Override 
    public Value visitFunctionCall(MuParser.FunctionCallContext ctx) { 
    	this.visitChildren(ctx);
    	for(int i=0;i<ctx.paramDefs().getChildCount();i++){
    		if(!(ctx.paramDefs().getChild(i).toString().equals(","))){
    			System.out.println("PUSH VAR_"+ctx.paramDefs().getChild(i));
    		}
//    		if(!(ctx.paramDefs().getChild(i).toString().equals(","))){
//    			this.visit(ctx.paramDefs().getChild(i));
//    			
//    		}
    	}
    	System.out.println("CALL "+ctx.ID().toString().toUpperCase()+"_START");
    	//return visitChildren(ctx); 
    	return new Value("EAX");
    }
	
    @Override 
    public Value visitParamDefs(MuParser.ParamDefsContext ctx) { 
    	return visitChildren(ctx); 
    }

    @Override
    public Value visitIdAtom(MuParser.IdAtomContext ctx) {
        String id = ctx.getText();
//        Value value = memory.get(id);
//        if(value == null) {
//            throw new RuntimeException("no such variable: " + id);
//        }
        return new Value(ctx.getText());
    }

    // atom overrides
    @Override
    public Value visitStringAtom(MuParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(MuParser.NumberAtomContext ctx) {
        return new Value(Integer.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(MuParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(MuParser.NilAtomContext ctx) {
        return new Value(null);
    }
    
    @Override 
    public Value visitStack_init(MuParser.Stack_initContext ctx) { 
    	System.out.println("STACK VAR_"+ctx.ID().getText());
    	return visitChildren(ctx); 
    }
	
    @Override 
    public Value visitStack_operations(MuParser.Stack_operationsContext ctx) { 
    	if(ctx.getChild(0).getText().equals("spush")) {
    		System.out.println("STACK_PSHS VAR_"+ctx.ID().getText() +" "+ ctx.INT().getText());
    	}
    	else if(ctx.getChild(0).getText().equals("spop")) {
    		System.out.println("STACK_POP VAR_"+ctx.ID().getText());
    	}
    	else if(ctx.getChild(0).getText().equals("empty")) {
    		System.out.println("EMPTY VAR_"+ctx.ID().getText());
    	}
    	
    	return visitChildren(ctx); 
    }
	
    
    // expr overrides
    @Override
    public Value visitParExpr(MuParser.ParExprContext ctx) {
    	
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(MuParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(MuParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(MuParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull MuParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        String op1 = left.asString(), op2 = right.asString();
        String operator = "MUL";
        Value returnValue = null;
        int flagl = 0, flagr = 0;
        
        try{
        	op1 = ""+Double.parseDouble(left.toString());
        	
        }
        catch(Exception e){
        	op1 = "VAR_"+left.toString();
        }
        try{
        	op2 = ""+Double.parseDouble(right.toString());
        	
        }
        catch(Exception e){
        	op2 = "VAR_"+right.toString();
        }

        switch (ctx.op.getType()) {
            case MuParser.MULT:
            	operator = "MUL";
            	break;
            case MuParser.DIV:
            	operator = "DIV";
            	break;
            case MuParser.MOD:
            	operator = "MOD";
            	break;
                
        }
        System.out.println(operator + " " + op1+ " " + op2);
        return new Value("EAX");
    }

    @Override
    public Value visitAdditiveExpr(@NotNull MuParser.AdditiveExprContext ctx) {
    	//System.out.println("expr ctx = "+ctx.getText());
    	Value left = new Value(ctx.expr(0).getText());
        Value right = new Value(ctx.expr(1).getText());

        String op1 = left.asString(), op2 = right.asString();
        String operator = "ADD";
        Value returnValue = null;
        int flagl = 0, flagr = 0;
        
        try{
        	op1 = ""+Integer.parseInt(left.toString());
        	
        }
        catch(Exception e){
        	op1 = "VAR_"+left.toString();
        }
        try{
        	op2 = ""+Integer.parseInt(right.toString());
        	
        }
        catch(Exception e){
        	op2 = "VAR_"+right.toString();
        }
        switch (ctx.op.getType()) {
        	case MuParser.PLUS:
        		operator = "ADD";
        		break;
            case MuParser.MINUS:
            	operator = "SUB";
            	break;
            
        }
        System.out.println(operator+ " " + op1 + " " + op2);
        return new Value("EAX");
    }

    @Override
    public Value visitRelationalExpr(@NotNull MuParser.RelationalExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        System.out.println("CMP "+left+ " " +right);
        switch (ctx.op.getType()) {
            case MuParser.LT:
            	System.out.println("JGE LABEL_"+LabelCount);
            	break;
                
            case MuParser.LTEQ:
            	System.out.println("JGT LABEL_"+LabelCount);
            	break;
            case MuParser.GT:
            	System.out.println("JLE LABEL_"+LabelCount);
            	break;
            case MuParser.GTEQ:
            	System.out.println("JLT LABEL_"+LabelCount);
            	break;
            default:
                throw new RuntimeException("unknown operator: " + MuParser.tokenNames[ctx.op.getType()]);
        }
        return new Value("LABEL_"+LabelCount++);
    }

    @Override
    public Value visitEqualityExpr(@NotNull MuParser.EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        if(!isInteger(left.toString())){
        	left = new Value("VAR_"+left.asString());
        }
        if(!isInteger(right.toString())){
        	right = new Value("VAR_"+right.asString());
        }

        switch (ctx.op.getType()) {
            case MuParser.EQ:
            	System.out.println("CMP "+left+ " "+ right);
            	System.out.println("JNE LABEL_"+LabelCount);
                return new Value("LABEL_"+LabelCount++);
                        
            case MuParser.NEQ:
            	System.out.println("CMP "+left+ " "+ right);
            	System.out.println("JE LABEL_"+LabelCount);
                return new Value("LABEL_"+LabelCount++);
            default:
                throw new RuntimeException("unknown operator: " + MuParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(MuParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(MuParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }
    
    @Override 
    public Value visitReturn_stat(MuParser.Return_statContext ctx) {
    	if(isInteger(ctx.getChild(1).getText())){
    		System.out.println("RET " + ctx.getChild(1).getText());
    	}
    	else{
    		System.out.println("RET VAR_" + ctx.getChild(1).getText());
    	}
    	return visitChildren(ctx);
    }
    
    @Override 
    public Value visitPrint(MuParser.PrintContext ctx) {
		System.out.println("PRINT VAR_" + ctx.ID().getText());
    	return visitChildren(ctx);
    }
    
    // log override
    @Override
    public Value visitLog(MuParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(MuParser.If_statContext ctx) {

        List<MuParser.Condition_blockContext> conditions =  ctx.condition_block();

        boolean evaluatedBlock = false;
        //ctx.getChiled(0)
        Value label = null;
        for(MuParser.Condition_blockContext condition : conditions) {
        	if(label != null){
        		System.out.println(label);
        	}

            label = this.visit(condition.expr());

            this.visit(condition.stat_block());
            
        }

        System.out.println(label);
        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(MuParser.While_statContext ctx) {
    	String while_label = "LABEL_"+LabelCount++;
        System.out.println(while_label);
        Value value = this.visit(ctx.expr());
        this.visit(ctx.stat_block());
        System.out.println("JMP "+while_label);
        System.out.println(value);
        return Value.VOID;
    }
}