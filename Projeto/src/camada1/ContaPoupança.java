package camada1;

/**
 * 
 * Herdou-se as informações escritas na classe abstrata Conta através do "extends"
 * Segundo o diagrama de UML também foram adicionados atributos e métodos especificados.
 */

public class ContaPoupança extends Conta{
		
		private double taxaBonus;
		
		// Foram inicializadas as classes. Nesta classe há 2 construtores em questão. Um default(O 1º) e um parametrizado(O 2º)
		
		public ContaPoupança() {
			
		}
		public ContaPoupança(double taxaBonus,int numeroAgencia,long numeroConta, double saldo) {
			super(numeroAgencia,numeroConta,saldo);
			this.setTaxaBonus(taxaBonus);
		}
		public double getTaxaBonus() {
			return taxaBonus;
		}
		public void setTaxaBonus(double taxaBonus) {
			this.taxaBonus = taxaBonus;
		}
		public void creditar(double valor) {
			super.setSaldo(valor + getSaldo()+(valor*taxaBonus));
		}
		public void debitar(double valor) {
			 super.setSaldo(valor - getSaldo());
		}
}
