
public class Program {
	
	Statement [] statements;
	
	public Program(Statement [] statements) {
		this.statements = statements;
	}
	
	public Statement [] getStatements() {
		return this.statements;
	}
	
	public void accept(Visitor v) {
		v.visitProgram(this);
	}
	
}
