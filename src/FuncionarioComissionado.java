public class FuncionarioComissionado extends Funcionario {

    private double vendas;
    private double percentual;

    public FuncionarioComissionado(int matricula, String nome, double vendas, double percentual) {
        super(matricula, nome);
        this.vendas = vendas;
        this.percentual = percentual;
    }

    @Override
    public double calcularSalario() {

        double comissao = vendas * percentual / 100;

        return SALARIO_BASE + comissao;

    }

}