import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleStackInterpreterTest {
/*
	@Test
	void test() {
		Expr e1 = new IntExpr(9);
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		e1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		IntExpr ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 9);
		Expr e2 = new IntExpr(2);
		Expr mult1 = new MultExpr(e1,e2);
		mult1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 18);
		Expr plus1 = new PlusExpr(e1,e2);
		plus1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 11);
		// ((9*2) + (9+2))
		Expr mult2 = new MultExpr(mult1,plus1);
		mult2.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 198);
	}

	@Test
	void testPrintlnWithNoArg() {
		Expr [] args = new Expr [0];
		Println pln = new Println( args );
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		pln.accept(interpreter);
	}

	@Test
	void testPrintlnWithOneIntArg() {
		Expr [] args = new Expr [1];
		args[0] = new IntExpr(99);
		Println pln = new Println( args );
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		pln.accept(interpreter);
	}

	@Test
	void testPrintlnWithThreeArgs() {
		Expr [] args = new Expr [3];
		Expr e1 = new IntExpr(9);
		Expr e2 = new IntExpr(2);
		args [0] = e1;
		args [1] = e2;
		args [2] = new MultExpr(e1,e2);
		Println pln = new Println( args );
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		pln.accept(interpreter);
	}

	@Test
	void testVariableUseWithNull() {
		Variable v = new Variable("V");
		VariableUse vu = new VariableUse(v);
		Expr [] args = new Expr [1];
		args [0] = vu;
		Println pln = new Println( args );
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		pln.accept(interpreter);
	}

	@Test
	void testAssignment1() {
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		Variable v = new Variable("V");
		Assignment assign = new Assignment(v, new IntExpr(33));
		assign.accept(interpreter);
		System.out.println(interpreter.getVariableValueFromName("V"));
	}

	@Test
	void testAssignment2() {
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		Variable v = new Variable("V");
		Assignment assign = new Assignment(v, new IntExpr(33));
		assign.accept(interpreter);
		assign = new Assignment(v, new MultExpr(new IntExpr(2), new VariableUse(v)));
		assign.accept(interpreter);
		Expr [] args = new Expr [1];
		args[0] = new VariableUse(v);
		Println pln = new Println(args);
		pln.accept(interpreter);
	}

	@Test
	void testProgram() {
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		Statement [] statements = new Statement[3];
		Variable v = new Variable("V");
		statements [0] = new Assignment(v, new IntExpr(33));
		statements [1] = new Assignment(v, new MultExpr(new IntExpr(2), new VariableUse(v)));
		Expr [] args = new Expr [1];
		args[0] = new VariableUse(v);
		statements[2] = new Println(args);
		Program prg = new Program(statements);
		prg.accept(interpreter);
	}

 */

	@Test
	void testFunction(){
		Argument[] arguments = new Argument[1];
		arguments[0]= new Argument("x");

		Statement[] statements = new Statement[1];
		Variable v = new Variable("V");
		statements[0] = new Assignment(v,new MultExpr(new IntExpr(3), new IntExpr(4)));

		Function f = new Function("mafunction",arguments,statements);

		Expr[] exprs = new Expr[1];
		exprs[0]= new IntExpr(3);

		//Println println = new Println()
		FunctionCall functionCall = new FunctionCall(f,exprs);
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		interpreter.visitFunction(functionCall);
	}
}
