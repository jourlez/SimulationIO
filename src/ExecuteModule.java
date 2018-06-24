
public class ExecuteModule extends Module {

	Client cliente;

	public ExecuteModule(){

	}
	
	public void calcularSiguienteS() {
		
	}
	
	public void ejecutarConsulta() {
		
	}
	
	public void calcularTiempoAlg() {
		
	}
	
	public void procesarTimeout() {
		
	}
	
	public void sentenciaACola() {
		
	}
	
	public void calcularTiempoFinalizacion() {
		
	}
	
	public void terminarQuery() {
		
	}

	@Override
	public void setTiempos() {
		int bloques = cliente.getNumeroDatos();
		int tipo = cliente.getTipoConsulta();
		if (tipo == 1 || tipo == 3){ //SELECT o JOIN
			cliente.setTiempoEjecucion(bloques * bloques);
		}
		else if (tipo == 2){ //UPDATE
			cliente.setTiempoEjecucion(1);
		}
		else{ //DDL
			cliente.setTiempoEjecucion(0.5);
		}

	}

	/**
	 * Metodo para iniciar la simulacion del modulo de ejecucion de consultas
	 * @param Cliente
	 * @return cliente, que sirve de parametro para los otros modulos
	 */
	public Client iniciar(Client Cliente){
		cliente = Cliente;
		this.setTiempos();
		return cliente;
	}
}
