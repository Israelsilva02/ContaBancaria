package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
	
		ContaCorrente cc1 = new ContaCorrente(11, 322, 4, "Bernardo", 0.0f, 5100000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		
		ContaPoupanca cp1 = new ContaPoupanca(12, 323, 5, "Silva", 34100000.0f);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();


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
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brasil com Israel - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Criar Conta\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Consulta de dados - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Apagar Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Depôsito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Transferencia entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "\nOpção Invalida!\n");
				break;
			}
		}

	}

}
