package camada2;

import camada1.Conta;

public class RepositorioConta {
		
	private Conta[] listaConta;
	private int tamanhoAtual = -1;
	
	public RepositorioConta() {
		// Atribui uma lista de 100 espaços numa conta nula até então
		listaConta = new Conta[100];
	}
	
	public void incluir (Conta conta) {
		tamanhoAtual++;
		listaConta[tamanhoAtual] = conta;
	}
	
	public Conta buscar (int agencia, long numero) {
		for(Conta conta : listaConta) {
			if(conta != null && conta.getNumeroConta() == numero && conta.getNumeroAgencia() == agencia) {
				return conta;
			}
		}
		return null;
	}
	
	public Conta[] consultarTodos() {
		Conta[] conta = new Conta[tamanhoAtual];
		for(int i = 0; i < conta.length; i++) {
			conta[i] = listaConta[i];
		}
		return conta;
	}
}
