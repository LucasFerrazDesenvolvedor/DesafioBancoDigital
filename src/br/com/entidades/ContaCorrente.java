package br.com.entidades;

// USANDO (HERAN�A, CLASSE FILHA HERDADNDO INFORMA��ES DA CLASSE PAI)
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO CONTA CORRENTE ===");
		super.imprimirExtrato();
	}

}
