package br.com.entidades;

// USANDO (HERANÇA, CLASSE FILHA HERDADNDO INFORMAÇÕES DA CLASSE PAI)
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO CONTA POUPANÇA ===");
		super.imprimirExtrato();
	}

}
