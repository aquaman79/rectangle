public class Context {

    Variable variable ;

    String parametre;

    public Context(Variable variable, String parametre) {
        this.variable = variable;
        this.parametre = parametre;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public String getParametre() {
        return parametre;
    }

    public void setParametre(String parametre) {
        this.parametre = parametre;
    }
}
