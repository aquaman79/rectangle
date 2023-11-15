
public class IntExpr extends UnaryExpr {
	Integer val;
	
	public IntExpr(Integer val) {
		this.val = val;
	}

	public Integer getVal() {
		return val;
	}

	@Override
	public void accept(Visitor v) {
		v.visitIntExpr(this);
	}	
	
	
	public String toString() {
		return this.val.toString();
	}
}
