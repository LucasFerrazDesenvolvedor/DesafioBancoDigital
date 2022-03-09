package br.com.entidades;

import java.util.Locale;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	Cliente cliente = new Cliente();
	Conta cc = new ContaCorrente(cliente);
	Conta poupanca = new ContaPoupanca(cliente);


//	CRIAR UM METODO
	
	public void menu() {
		
		double valor;
		String titular;

		System.out.println("==================================================");
		System.out.println("======== BEM VINDO AO NOSSO BANCO DIGITAL ========");
		System.out.println("==================================================");
		System.out.println("========= QUAL OPERA��O DESEJA EXECUTAR ==========");
		System.out.println("==================================================");
		System.out.println("------------------- 1. DEPOSITAR -----------------");
		System.out.println("------------------- 2. SACAR ---------------------");
		System.out.println("------------------- 3. TRANSFERIR ----------------");
		System.out.println("------------------- 4. EXTRATO -------------------");
		System.out.println("------------------- 5. SAIR ----------------------");
		System.out.println("==================================================");
		System.out.println(" -------- INFORME QUAL A OP��O DESEJADA: ---------");
		int op = sc.nextInt();

		do {

			switch (op) {

			case 1:
				System.out.print("Informe o nome do Titular: ");
				cliente.setNome(titular = sc.next().toUpperCase());
				try {
					if(cliente.getNome().substring(0,5).matches("[A-Z]*")){
						System.out.print("Digite o valor do deposito: ");
						System.out.print("R$");
						valor = sc.nextDouble();
						cc.depositar(valor);
					}
					
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println(" Nome invalido! digite o nome corretamente.");
					}
				
				menu();
				break;

			case 2:
				System.out.print("Digite o valor do saque: ");
				System.out.print("R$");
				valor = sc.nextDouble();
				cc.sacar(valor);
				menu();
				break;

			case 3:
				System.out.print("Quanto voc� deseja transferir para a POUPAN�A?");
				System.out.print("R$");
				valor = sc.nextDouble();
				cc.transferir(valor, poupanca);
				menu();
				break;

			case 4:
				System.out.println("qual conta deseja imprimir o extrato? \n1. CONTA CORRENTE:\n2. CONTA POUPAN�A:");
				op = sc.nextInt();
				if (op == 1) {
					cc.imprimirExtrato();
					menu();
				}
				else if (op == 2) {
					poupanca.imprimirExtrato();
					menu();
					break;
				}
				
			case 5:
				System.out.println("\nVoc� est� saindo do menu obrigado...\nOpera��o finalizada!");
				break;

			default:
				System.err.println("Op��o Invalida!!!");
				menu();
				break;

			}

		} while (op != 5);	
	}
}
