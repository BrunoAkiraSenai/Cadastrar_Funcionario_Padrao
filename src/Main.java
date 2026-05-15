import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        int opcao;

        do {

            System.out.println("\n========== SISTEMA DE FUNCIONÁRIOS ==========");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro(sc, "Digite um número: ");

            switch (opcao) {

                case 1:
                    cadastrarFuncionarioPadrao(sc, funcionarios);
                    break;

                case 2:
                    cadastrarFuncionarioComissionado(sc, funcionarios);
                    break;

                case 3:
                    cadastrarFuncionarioProducao(sc, funcionarios);
                    break;

                case 4:
                    gerarFolhaPagamento(funcionarios);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número entre 0 e 4.");

            }

        } while (opcao != 0);

        sc.close();

    }

    private static int lerInteiro(Scanner sc, String mensagemErro) {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida! " + mensagemErro);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static int lerInteiroPositivo(Scanner sc, String mensagemErro) {
        int valor;
        do {
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida! " + mensagemErro);
                sc.next();
            }
            valor = sc.nextInt();
            sc.nextLine();
            if (valor < 0) {
                System.out.print("O valor não pode ser negativo. " + mensagemErro);
            }
        } while (valor < 0);
        return valor;
    }

    private static double lerDoublePositivo(Scanner sc, String mensagemErro) {
        double valor;
        do {
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida! " + mensagemErro);
                sc.next();
            }
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor < 0) {
                System.out.print("O valor não pode ser negativo. " + mensagemErro);
            }
        } while (valor < 0);
        return valor;
    }

    private static double lerPercentual(Scanner sc, String mensagemErro) {
        double valor;
        do {
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida! " + mensagemErro);
                sc.next();
            }
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor < 0 || valor > 100) {
                System.out.print("O percentual deve estar entre 0 e 100. " + mensagemErro);
            }
        } while (valor < 0 || valor > 100);
        return valor;
    }

    private static String lerTexto(Scanner sc) {
        String texto;
        do {
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.print("O nome não pode estar vazio. Digite novamente: ");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static void cadastrarFuncionarioPadrao(Scanner sc, ArrayList<Funcionario> funcionarios) {
        System.out.println("\n--- Cadastrar Funcionário Padrão ---");

        System.out.print("Nome: ");
        String nome = lerTexto(sc);

        System.out.print("Matrícula: ");
        int matricula = lerInteiroPositivo(sc, "Digite uma matrícula válida: ");

        funcionarios.add(new FuncionarioPadrao(matricula, nome));
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void cadastrarFuncionarioComissionado(Scanner sc, ArrayList<Funcionario> funcionarios) {
        System.out.println("\n--- Cadastrar Funcionário Comissionado ---");

        System.out.print("Nome: ");
        String nome = lerTexto(sc);

        System.out.print("Matrícula: ");
        int matricula = lerInteiroPositivo(sc, "Digite uma matrícula válida: ");

        System.out.print("Valor total de vendas: R$ ");
        double vendas = lerDoublePositivo(sc, "Digite um valor válido para vendas: ");

        System.out.print("Percentual de comissão: ");
        double percentual = lerPercentual(sc, "Digite um percentual válido: ");

        funcionarios.add(new FuncionarioComissionado(matricula, nome, vendas, percentual));
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void cadastrarFuncionarioProducao(Scanner sc, ArrayList<Funcionario> funcionarios) {
        System.out.println("\n--- Cadastrar Funcionário Produção ---");

        System.out.print("Nome: ");
        String nome = lerTexto(sc);

        System.out.print("Matrícula: ");
        int matricula = lerInteiroPositivo(sc, "Digite uma matrícula válida: ");

        System.out.print("Quantidade de peças produzidas: ");
        int quantidade = lerInteiroPositivo(sc, "Digite uma quantidade válida: ");

        System.out.print("Valor por peça: R$ ");
        double valorPeca = lerDoublePositivo(sc, "Digite um valor válido por peça: ");

        funcionarios.add(new FuncionarioProducao(matricula, nome, quantidade, valorPeca));
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void gerarFolhaPagamento(ArrayList<Funcionario> funcionarios) {
        System.out.println("\n========== FOLHA DE PAGAMENTO ==========");

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Total de funcionários cadastrados: " + funcionarios.size());
        System.out.println("------------------------------------------");

        for (Funcionario funcionario : funcionarios) {

            double salarioFinal = funcionario.calcularSalario();
            double extras = salarioFinal - Funcionario.SALARIO_BASE;

            System.out.println("Funcionário: " + funcionario.getNome());
            System.out.println("Matrícula: " + funcionario.getMatricula());
            System.out.printf("Salário Base: R$ %.2f%n", Funcionario.SALARIO_BASE);
            System.out.printf("Extras: R$ %.2f%n", extras);
            System.out.printf("Salário Final: R$ %.2f%n", salarioFinal);
            System.out.println("------------------------------------------");

        }
    }

}
