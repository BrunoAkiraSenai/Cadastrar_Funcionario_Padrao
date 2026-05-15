public class Funcionario {

    protected int matricula;
    protected String nome;

    public static final double SALARIO_BASE = 2000.0;

    public Funcionario(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return SALARIO_BASE;
    }

    public double calcularSalario() {
        return SALARIO_BASE;
    }

}