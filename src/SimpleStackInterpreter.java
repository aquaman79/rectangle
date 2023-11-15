import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.management.RuntimeErrorException;

// Principe : 
// Pour un calcul les arguments sont récupérés dans la pile
//	- par pour un +, les opg et opd sont dépilé
// Quand le calcul est effectué, on empile le résultat
// Le parcous se fait en profondeur à gauche d'abord
// Le résultat courant est toujours en tête de pile
// A la fin du calcul d'une expression complete, la pile ne contient qu'un seul element, le résultat
//
// en entrée j'ai l'entier 9, le résultat est 9
// - le résultat du calcul pour une expression unaire est l'expression unaire elle-même
// en j'ai 2 * 3

public class SimpleStackInterpreter extends Visitor {
	Stack<Expr> stk;

	Stack<Context> stkContext;
	Map<Variable, IntExpr> values;
	Map<String, Variable> variables;
	Map<String,IntExpr> functionsRes;
	
	public SimpleStackInterpreter () {
		this.stk = new Stack<Expr>();
		this.stkContext = new Stack<Context>();
		this.values = new HashMap<>();
		this.variables = new HashMap<>();
		this.functionsRes = new HashMap<>();
	}
	
	public IntExpr getVariableValueFromName(String name) {
		Variable v = this.variables.get(name);
		if (v == null) throw new RuntimeErrorException(null, name);
		return this.values.get(v);
	}
	
	public void visitIntExpr(IntExpr intExpr) {
		stk.push(intExpr);
	}

	public void visitMultExpr(MultExpr multExpr) {
		Expr eg = multExpr.getOpg();
		Expr ed = multExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ied.getVal() * ieg.getVal()));
	}

	public void visitPlusExpr(PlusExpr plusExpr) {
		Expr eg = plusExpr.getOpg();
		Expr ed = plusExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ied.getVal() + ieg.getVal()));
	}

	public Expr result() {
		return stk.peek();
	}
	
	public void visitVariable(Variable variable) {
		Variable declared = this.variables.get(variable.getName());
		if (declared == null) 
			variables.put(variable.getName(), variable);
	}
	
	public void visitVariableUse(VariableUse v) {
		IntExpr e = values.get(v.getVariable());
		stk.push(e);

	}
	
	public void visitAssignment(Assignment a) {
		Variable lhs = a.getLeftHandSide();
		Expr rhs = a.getRightHandSide();
		lhs.accept(this);
		rhs.accept(this);
		IntExpr r = (IntExpr) stk.pop();
		values.put(lhs, r);

	}
	
	public void visitPrintln(Println p) {
		Expr [] args = p.getArguments();
		for (Expr a : args) {
			a.accept(this);
		}
		IntExpr [] res = new IntExpr[args.length];
		for (int idx = args.length - 1; idx >= 0; idx--) {
			res[idx] = (IntExpr)  stk.pop();
		}
		for (IntExpr ie : res) {
			System.out.print(ie);
			System.out.print(' ');
		}
		System.out.print('\n');
	}
	
	public void visitProgram(Program program) {
		for (Statement stmt : program.getStatements())
			stmt.accept(this);
	}


	public void visitFunction(FunctionCall functionCall){

		Function function = functionCall.getFunction();
	//	functionsRes.put(function.getName(),null);
		for(int i = 0 ; i < function.getStatements().length;i++){
			 function.getStatements()[i].accept(this);
		}
		Variable v = new Variable(function.getArgs()[0].getName());
		functionsRes.put(function.getName(),values.get(v));
		System.out.println(functionsRes.get(function.getName()));
	}
}
