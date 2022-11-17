package camada1;

/**
 * 
 * Herdou-se as informações escritas na classe abstrata Conta através do "extends"
 * Segundo o diagrama de UML também foram adicionados atributos e métodos especificados.
 */

public class ContaCorrente extends Conta {

		private double tarifa;
		
		// Foram inicializadas as classes. Nesta classe há 2 construtores em questão. Um default(O 1º) e um parametrizado(O 2º)
		public ContaCorrente() {
			
		}
		public ContaCorrente(int numeroAgencia,long numeroConta, double saldo,double tarifa) {
			super(numeroAgencia,numeroConta,saldo);
			this.setTarifa(tarifa);
		}
		
		public void creditar(double valor) {
			super.setSaldo(valor + getSaldo());
		}
		public void debitar(double valor) {
			super.setSaldo(valor - getSaldo());
		}
		
		public double getTarifa() {
			return tarifa;
		}
		public void setTarifa(double tarifa) {
			this.tarifa = tarifa;
		}
}
