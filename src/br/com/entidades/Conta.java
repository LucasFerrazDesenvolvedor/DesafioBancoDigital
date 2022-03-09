package br.com.entidades;

import java.util.Objects;
import java.util.Random;

public abstract class Conta {

	Random random = new Random();

	private static final int AGENCIA_PADRAO = 1;
	// private static int SEQUENCIAL = 1;

//	CRIANDO PROPRIEDADES E ATRIBUTOS	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = 1 + random.nextInt(9999);
		this.cliente = cliente;
	}

//	CRIANDO METODOS ( IMPLEMENTANDO METODOS ATRAVES DE INTERFACE)

	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println(String.format("Você efetuou um saque de R$ %.2f da conta corrente\n", valor));
		} else {
			System.err.println("\nSaldo insuficiente!!!");
		}
	}

	public void depositar(double valor) {
		saldo += valor;
		System.out.println(String.format("Foram depositados R$ %.2f na conta\n", valor));
	}

// TA PEGANDO A CONTA, SACANDO O VALOR DELA E TRANSFERINDO PARA A CONTA DESTINO NO CASO SERIA A POUPAÇA OU VICE VERSA

	public void transferir(double valor, Conta contaDestino) {
		if (saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.err.println("Impossivel realizar sua transferencia, voce não possui saldo na conta!");
		}

	}

	protected void imprimirExtrato() {

		if (Objects.isNull(this.cliente.getNome())) {
			System.err.println("TITULAR: nome invalido!");
			System.err.println("AGENCIA: agencia invalida!");
			System.err.println("NUMERO: numero de conta invalida!");
			System.out.println(String.format("SALDO: %.2f", this.saldo));
		} else {
			System.out.println(String.format("TITULAR: %s", this.cliente.getNome()));
			System.out.println(String.format("AGENCIA: %d", this.agencia));
			System.out.println(String.format("NUMERO: %d", this.numero));
			System.out.println(String.format("SALDO: %.2f", this.saldo));
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

}
