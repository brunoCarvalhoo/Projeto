package camada2;

import camada1.Correntista;

public class CorrentistaMediator {
		
		public static final int SUCESSO = 0;
		public static final int CPF_INVÁLIDO = 1;
		public static final int NOME_INVÁLIDO = 2;
		private RepositorioCorrentista repositorioCorrentista;
		
		public CorrentistaMediator() {
			repositorioCorrentista = FabricaRepositorio.getRepositorioCorrentista();
		}
		
		public int incluir (Correntista correntista) {
			if(correntista.getCpf() < 0 ){
				return CPF_INVÁLIDO;
			}else if(correntista.getNome() == null || correntista.getNome().trim().equals("")) {
				return NOME_INVÁLIDO;
			}else {
				repositorioCorrentista.incluir(correntista);
				return SUCESSO;
			}
		}
		
		public Correntista[] consultarOrdenadoPorNome() {
			Correntista[] correntista = repositorioCorrentista.consultarTodos();
			Correntista aux = null;
			for (int i=0; i<correntista.length; i++) {
				for (int k=i; k<correntista.length; k++) {
					String nome1 = correntista[i].getNome();
					String nome2 = correntista[k].getNome();
					if (nome1.compareTo(nome2) > 0) {
						aux = correntista[i];
						correntista[i] = correntista[k];
						correntista[k] = aux;
					}
				}
			}
			return correntista;
		}
}
