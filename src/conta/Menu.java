package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 322, 4, "Bernardo", 200000f, 5100000.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 324, 7, "Israel", 560000f, 6100000.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 323, 5, "Silva", 34100000f, 30);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 325, 6, "MAxIsrael", 89100000f, 25);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + "*****************************************");
			System.out.println("****** Banco do Brasil com Israel *******");
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println("[1] Criar Conta");
			System.out.println("[2] Listar todas as Contas");
			System.out.println("[3] Buscar Conta por número");
			System.out.println("[4] Atualizar dados da Conta");
			System.out.println("[5] Apagar Conta");
			System.out.println("[6] Sacar");
			System.out.println("[7] Depositar");
			System.out.println("[8] Tranferir valores entre Contas");
			System.out.println("[9] Sair");
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println("Entre com a opção desejada: ");
			System.out.println("                      " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;

			}
			if (opcao == 9) {
				System.out.println("\nBanco do Brasil com Israel - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Criar Conta\n\n");
				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da Conta (1- Conta Corrente ou 2- Conta Poupança): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de Crédito(R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Consulta de dados - por número\n\n");

				System.out.println("Digite o número da Conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Atualizar dados da Conta\n\n");
				System.out.println("Digite  número da Conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {

					System.out.println("Digite número da Agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da Conta: ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito(R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta invalido!");
					}
					}
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Apagar Conta\n\n");

				System.out.println("Digite o número da Conta: ");
				numero = leia.hashCode();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Saque\n\n");

				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do Saque (R$); ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Depósito\n\n");

				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = leia.nextFloat();

				} while (valor <= 0);
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Transferencia entre contas\n\n");
				System.out.println("Digite o número da Conta Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da Conta Destino: ");
				numeroDestino = leia.nextInt();
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = leia.nextFloat();

				} while (valor <= 0);
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "\nOpção Invalida!\n");
				keyPress();
				break;
			}
		}

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
