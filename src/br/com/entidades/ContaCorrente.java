package br.com.entidades;

// USANDO (HERANÇA, CLASSE FILHA HERDADNDO INFORMAÇÕES DA CLASSE PAI)
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
