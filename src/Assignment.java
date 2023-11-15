
public class Assignment extends Statement {

	Variable lhs;
	Expr rhs;
	
	public Assignment(Variable lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitAssignment(this);
	}

	public Variable getLeftHandSide() {
		return this.lhs;
	}

	public Expr getRightHandSide() {
		return this.rhs;
	}

}
