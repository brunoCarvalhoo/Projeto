package camada2;

import camada1.Conta;
import camada1.Correntista;

public class ContaMediator {
	
	public static final int SUCESSO = 0;
	public static final int CPF_INVÁLIDO = 1;
	public static final int CODIGO_INVÁLIDO = 2;
	public static final int AGENCIA_INVÁLIDA = 3;
	public static final int TARIFA_INVÁLIDA = 4;
	public static final int TAXA_INVÁLIDA = 5;
	public static final int VALOR_INVÁLIDO = 6;
	public static final int CONTA_INEXISTENTE = 7;
	public static final int CORRENTISTA_INEXISTENTE = 8;
	public static final int DEBITO_INVÁLIDO = 9;
	
	private RepositorioCorrentista repositorioCorrentista;
	private RepositorioConta repositorioConta;
	
	public ContaMediator() {
		// Puxa as informações da fábrica de repositório
		repositorioCorrentista = FabricaRepositorio.getRepositorioCorrentista();
		repositorioConta = FabricaRepositorio.getRepositorioConta();
	}
	
	public int incluir(Conta conta, long cpf) {
		if(conta.getNumeroConta() <= 0) {
			return AGENCIA_INVÁLIDA;
		}else if(conta.getNumeroConta() <= 0) {
			return CODIGO_INVÁLIDO;
		}else{
			Correntista correntista = repositorioCorrentista.buscarPorCPF(cpf);
			if(correntista == null) {
				return CORRENTISTA_INEXISTENTE;
			}else {
				conta.setCliente(correntista);
			}
		}
		repositorioConta.incluir(conta);
		return SUCESSO;
	}
	
	public int debitar(int agencia,long numero,double valor) {
		if(valor < 0) {
			return VALOR_INVÁLIDO;
		}else {
			Conta conta = repositorioConta.buscar(agencia,numero);
			if(conta == null) {
				return CONTA_INEXISTENTE;
			}else {
				double aux_saldo = conta.getSaldo() - valor;
				if(aux_saldo >= 0) {
					conta.debitar(valor);
					return SUCESSO;
				}
				return DEBITO_INVÁLIDO;
			}
		}
	}
	
	public int creditar(int agencia,long numero,double valor) {
		if(valor < 0) {
			return VALOR_INVÁLIDO;
		}else {
			Conta conta = repositorioConta.buscar(agencia, numero);
			if(conta == null) {
				return CONTA_INEXISTENTE;
			}else {
				conta.creditar(valor);
				return SUCESSO;
			}
		}
	}
	
	public Conta[] consultarOrdenadoPorSaldo() {
		
		Conta[] contas = repositorioConta.consultarTodos();
		Conta aux = null;
		for (int i=0; i<contas.length; i++) {
			for (int k=i; k<contas.length; k++) {
				double preco1 = contas[i].getSaldo();
				double preco2 = contas[k].getSaldo();
				if (preco1 > preco2) {
					aux = contas[i];
					contas[i] = contas[k];
					contas[k] = aux;
				}
			}
		}
		return contas;
	}
}
