
public class ExecuteModule extends Module {

	Client cliente;

	public ExecuteModule(Client Cliente) {
		cliente = Cliente;
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
		int tiempoTransmision = cliente.getTiempoTransmision();
		cliente.setTiempoEjecucion(tiempoTransmision * tiempoTransmision);
	}

	/**
	 * Metodo para iniciar la simulacion del modulo de ejecucion de consultas
	 * @param Cliente
	 * @return cliente, que sirve de parametro para los otros modulos
	 */
	public Client iniciar(Client Cliente){
		ExecuteModule moduloEjecutor = new ExecuteModule(Cliente);
		moduloEjecutor.setTiempos();
		return cliente;
	}
}
