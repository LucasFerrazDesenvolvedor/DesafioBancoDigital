package br.com.entidades;

// USANDO (HERAN�A, CLASSE FILHA HERDADNDO INFORMA��ES DA CLASSE PAI)
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO CONTA POUPAN�A ===");
		super.imprimirExtrato();
	}

}
