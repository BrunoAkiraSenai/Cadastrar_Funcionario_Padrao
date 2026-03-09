public class Funcionario {

    protected int matricula;
    protected String nome;

    protected static final double SALARIO_BASE = 2000.0;

    public Funcionario(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public double calcularSalario() {
        return SALARIO_BASE;
    }

}