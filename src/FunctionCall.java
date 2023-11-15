public class FunctionCall {
    Function function;

    Expr[] exprs;

    public FunctionCall(Function function, Expr[] exprs) {
        this.function = function;
        this.exprs = exprs;
    }

    public void accept(Visitor v) {
        v.visitFunction(this);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Expr[] getExprs() {
        return exprs;
    }

    public void setExprs(Expr[] exprs) {
        this.exprs = exprs;
    }
}
