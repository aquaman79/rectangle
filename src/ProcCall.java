
public abstract class ProcCall extends Statement {

	Expr [] arguments;
	
	public ProcCall(Expr [] args) {
		this.arguments = args;
	}
	
	@Override
	public abstract void accept(Visitor v);

	public Expr [] getArguments() {
		return this.arguments;
	}

}
