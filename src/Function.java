public class Function {
    private String name ;

    private  Argument[] args;

    private  Statement[] statements;

    public Function(String name, Argument[] args, Statement[] statements) {
        this.name = name;
        this.args = args;
        this.statements = statements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Argument[] getArgs() {
        return args;
    }

    public void setArgs(Argument[] args) {
        this.args = args;
    }

    public Statement[] getStatements() {
        return statements;
    }

    public void setStatements(Statement[] statements) {
        this.statements = statements;
    }
}
