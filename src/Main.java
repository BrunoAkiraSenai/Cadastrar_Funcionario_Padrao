import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        int opcao;

        do {

            System.out.println("      Sistema de Funciorários ");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastrar Funcionário Padrão");
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();



                    FuncionarioPadrao f = new FuncionarioPadrao(matricula, nome);

                    funcionarios.add(f);

                    System.out.println("Funcionário cadastrado!");

                    break;

                case 2:
                    System.out.println("Cadastrar Funcionário Comissionado");
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome2 = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula2 = sc.nextInt();

                    System.out.print("Valor das vendas: ");
                    double vendas = sc.nextDouble();

                    System.out.print("Percentual de comissão: ");
                    double percentual = sc.nextDouble();

                    FuncionarioComissionado f2 =
                            new FuncionarioComissionado(matricula2, nome2, vendas, percentual);

                    funcionarios.add(f2);

                    System.out.println("Funcionário cadastrado!");

                    break;

                case 3:
                    System.out.println("Cadastrar Funcionário Produção");
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome3 = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula3 = sc.nextInt();

                    System.out.print("Quantidade de peças: ");
                    int quantidade = sc.nextInt();

                    System.out.print("Valor por peça: ");
                    double valor = sc.nextDouble();

                    FuncionarioProducao f3 =
                            new FuncionarioProducao(matricula3, nome3, quantidade, valor);

                    funcionarios.add(f3);

                    System.out.println("Funcionário cadastrado!");
                case 4:
                    System.out.println("Gerar folha de pagamento");
                    System.out.println("Total de pessoas cadastradas: " + funcionarios.size());

                    for (Funcionario funcio : funcionarios) {

                        System.out.println("Nome: " + funcio.nome);
                        System.out.println("Matrícula: " + funcio.matricula);
                        System.out.println("Salário Fixo: " + Funcionario.SALARIO_BASE);

                        double salarioFinal = funcio.calcularSalario();
                        double extra = salarioFinal - Funcionario.SALARIO_BASE;

                        System.out.println("Extras: " + extra);
                        System.out.println("Salário Final: " + salarioFinal);

                    }

                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, escolha de 0 a 4");

            }

        } while (opcao != 0);

        sc.close();

    }

}