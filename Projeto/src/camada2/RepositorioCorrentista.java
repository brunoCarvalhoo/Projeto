package camada2;
import camada1.Correntista;

public class RepositorioCorrentista {
		
		private int tamanhoAtual = -1;
		private Correntista[] listaCorrentistas;
		
		public RepositorioCorrentista(){
			listaCorrentistas = new Correntista[100];
		}
		
		public void incluir(Correntista correntista) {
			// Adicionamos uma correntista
			tamanhoAtual++;
			listaCorrentistas[tamanhoAtual] = correntista;
		}
		
		public Correntista buscarPorCPF(long cpf) {
			// Buscamos o Correntista
			for(Correntista correntista : listaCorrentistas) {
				if(correntista != null && correntista.getCpf()== cpf) {
					return correntista;
				}
			}
			return null;
		}
		
		public Correntista[] consultarTodos() {
			// Imprime a lista de correntistas completa
			Correntista[] listaRetorno = new Correntista[tamanhoAtual];
			for(int i = 0; i < listaRetorno.length; i++) {
				listaRetorno[i] = listaCorrentistas[i];
			}
			return listaRetorno;
		}
		
}
