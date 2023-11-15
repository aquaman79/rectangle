
public class VariableUse extends Expr {
	
	Variable v;
	
	public VariableUse(Variable v) {
		this.v = v;
	}
	
	public Variable getVariable() {
		return this.v;
	}
	
	public String getName() {
		return this.v.getName();
	}

	@Override
	public void accept(Visitor v) {
		v.visitVariableUse(this);
	}

}
