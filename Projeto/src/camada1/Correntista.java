package camada1;

/**
 * 
 * Esta classa foi inicializada sem o auxílio de classes abstratas ou sem ser Subclasse/Superclasse de algo
 * Portanto, não precisou do "extends"
 *
 */

public class Correntista {
		
	private long cpf;
	private String nome;
	
	// Nesta classe há 2 construtores em questão. Um default(O 1º) e um parametrizado(O 2º)
	
	public Correntista() {
		
	}
	public Correntista(long cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public void setCpf(long cpf){
		this.cpf = cpf;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public long getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
}
