package camada2;


public class FabricaRepositorio {
	private static RepositorioConta repositorioConta = 
			new RepositorioConta();
	private static RepositorioCorrentista repositorioCorrentista = 
			new RepositorioCorrentista();
	public static RepositorioCorrentista getRepositorioCorrentista() {
		return repositorioCorrentista;
	}
	public static RepositorioConta getRepositorioConta() {
		return repositorioConta;
	}	
}