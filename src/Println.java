
public class Println extends ProcCall {

	public Println(Expr[] args) {
		super(args);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPrintln(this);
	}

}
