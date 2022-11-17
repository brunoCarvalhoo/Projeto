package camada1;


/**
 * 
 * Criamos uma classe abstrata chamada Conta que servirá de referência(Superclasse) 
 * para as classes ContaCorrente & ContaPoupança(Subclasses).
 * 
 * Esta classe não será implementada e servirá apenas como template. 
 * 
 */

public abstract class Conta {
		
	private int numeroAgencia;
	private long numeroConta;
	private double saldo;
	private Correntista cliente;
	
	public Conta() {
		
	}
	public Conta(int numeroAgencia,long numeroConta, double saldo) {
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public void setNumeroConta (long numeroConta) {
		this.numeroConta = numeroConta;
	}
	public void setSaldo (double saldo) {
		this.saldo = saldo;
	}
	public void setCliente (Correntista cliente) {
		this.cliente = cliente;;
	}
	
	public int getNumeroAgencia() {
		return numeroAgencia;
	}
	public long getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public Correntista getCliente() {
		return cliente;
	}
	// Métodos Abstratos são somente iniciados em outras classes apesar de serem aqui sinalizados
	public abstract void debitar(double valor);
	public abstract void creditar(double valor);
}
