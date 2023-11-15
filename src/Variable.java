
public class Variable  {
	
	String name;
	
	public Variable(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}


	public void accept(Visitor v) {
		v.visitVariable(this);

	}

}
