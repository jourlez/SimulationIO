
public class QueryModule extends Module {

	Client cliente;
	RandomValueGenerator generator = new RandomValueGenerator();

	public QueryModule() {

	}
	
	public void finalizarSentencia() {
		
	}
	
	public void procesarTimeout() {
		
	}
	
	public void calcularTiempoEtapas() {
		
	}
	
	public void procesoACola() {
		
	}
	
	public void siguienteProceso() {
		
	}
	
	public void nuevoProceso() {
		
	}
	
	public void aTransaccion() {
		
	}
	
	public void ejecutarConsulta() {
		
	}

	public void setTiempos(){
		cliente.setTipoConsulta(generator.tipoConsulta());
		if (cliente.getTipoConsulta() == 1 || cliente.getTipoConsulta() == 3){
			cliente.setReadOnly(true);
		} else{
			cliente.setReadOnly(false);
		}
	}

	public Client iniciar(Client Cliente){
		cliente = Cliente;
		this.setTiempos();
		return cliente;
	}
	
}
