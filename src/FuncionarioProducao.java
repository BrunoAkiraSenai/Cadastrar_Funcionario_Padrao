public class FuncionarioProducao extends Funcionario {

    private int quantidadePecas;
    private double valorPeca;

    public FuncionarioProducao(int matricula, String nome, int quantidadePecas, double valorPeca) {
        super(matricula, nome);
        this.quantidadePecas = quantidadePecas;
        this.valorPeca = valorPeca;
    }

    @Override
    public double calcularSalario() {

        double bonus = quantidadePecas * valorPeca;

        return SALARIO_BASE + bonus;

    }

}