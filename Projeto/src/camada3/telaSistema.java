package camada3;

import java.util.Scanner;

import camada1.Conta;
import camada1.ContaCorrente;
import camada1.ContaPoupança;
import camada1.Correntista;
import camada2.ContaMediator;
import camada2.CorrentistaMediator;

public class telaSistema {
		
	private final Scanner ENTRADA = new Scanner(System.in);
	private ContaMediator contaMediator;
	private CorrentistaMediator correntistaMediator;
	
	public telaSistema() {
		contaMediator = new ContaMediator();
		correntistaMediator = new CorrentistaMediator();
	}

	
	public void executarTela() {
		boolean continua;
		do {
			continua = menuPrincipal();
		}while(continua);
	}
	
	private boolean menuPrincipal() {
		System.out.println("1 - Incluir Correntista");
		System.out.println("2 - Incluir Conta");
		System.out.println("3 - Creditar Conta");
		System.out.println("4 - Debitar Conta");
		System.out.println("5 - Listar Correntistas");
		System.out.println("6 - Listar Contas");
		System.out.println("7 - Sair");
		
		int opção = ENTRADA.nextInt();
		boolean ret = true;
		switch (opção) { 
		case 1:
			incluirCorrentista();
			break;
		case 2:
			incluirConta();
			break;
		case 3:
			creditarConta();
			break;
		case 4:
			debitarConta();
			break;
		case 5:
			listarCorrentistas();
			break;
		case 6:
			listarProdutos();
			break;
		case 7:
			ret = false;
			break;
		}
		return ret;
	}
	
	private void incluirCorrentista() {
		System.out.println("Digite o cpf");
		long cpf = ENTRADA.nextLong();
		System.out.println("Digite o nome");
		String nome = ENTRADA.next();
		Correntista correntista = new Correntista(cpf,nome);
		int ret = correntistaMediator.incluir(correntista);
		mostrarSucessoNaoSucesso("Correntista incluído ", "Correntista não incluído ", 
				CorrentistaMediator.SUCESSO, ret);
	}
	
	private void incluirConta() {
		Conta conta = null;
		double tarifa = 0.0;
		double taxaBonus = 0.0;
		System.out.println("Digite 1 para Conta Corrente e 2 para Conta Poupança");
		int opcProduto = ENTRADA.nextInt();
		System.out.println("Digite o Nº da Agência: ");
		int numeroAgencia = ENTRADA.nextInt();
		System.out.println("Digite o Nº da Conta: ");
		long numeroConta = ENTRADA.nextLong();
		System.out.println("Digite o Nº do CPF do cidadão: ");
		long cpf = ENTRADA.nextLong();
		
		if (opcProduto == 1) {
			System.out.println("Digite a tarifa da: ");
			tarifa = ENTRADA.nextDouble();
			conta = new ContaCorrente(numeroAgencia, numeroConta, 0.0,tarifa);
		} else {
			System.out.println("Digite a taxa bônus: ");
			taxaBonus = ENTRADA.nextDouble();
			conta = new ContaPoupança(taxaBonus,numeroAgencia,numeroConta,0.0);
		}
		
		int ret = contaMediator.incluir(conta, cpf);
		mostrarSucessoNaoSucesso("Conta incluida ", "Conta não incluída ", 
				ContaMediator.SUCESSO, ret);
	}
	
	private void creditarConta() {
		System.out.println("Digite o cpf do cidadão ");
		long cpf = ENTRADA.nextLong();
		System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
		int ret = contaMediator.creditar(0, cpf, valor);
		mostrarSucessoNaoSucesso("Conta Creditada ", "Conta não Credítada ",ContaMediator.SUCESSO, ret);
	}
	
	private void debitarConta() {
		System.out.println("Digite o cpf do cidadão ");
		long cpf = ENTRADA.nextLong();
		System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
		int ret = contaMediator.debitar(0, cpf, valor);
		mostrarSucessoNaoSucesso("Conta Debitada ", "Conta não Debitada ", ContaMediator.SUCESSO, ret);	
	}
	
	private void listarCorrentistas() {
		Correntista[] listaCorrentistas = correntistaMediator.consultarOrdenadoPorNome();
		for(Correntista correntista:listaCorrentistas) {
			System.out.println(correntista.getNome() + " , " 
					+ correntista.getCpf());	
		}
	}
	
	private void listarProdutos() {
		Conta[] listaConta = contaMediator.consultarOrdenadoPorSaldo();
		for(Conta conta:listaConta) {
			System.out.println(conta.getNumeroAgencia() + " , " 
					+ conta.getNumeroConta() + " , " + conta.getSaldo());	
		}
	}
	
	private void mostrarSucessoNaoSucesso(String msgSucesso, String msgNaoSucesso, int codigoSucesso, int ret) {
		if (ret == codigoSucesso) {
			System.out.println(msgSucesso + " com sucesso");
		} else {
			System.out.println(msgNaoSucesso + ", cod retorno: " + ret);
		}		
	}
}
