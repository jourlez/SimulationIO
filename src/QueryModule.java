
public class QueryModule extends Module {

	Client cliente;

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

	}

	public void iniciar(Client Cliente){
		cliente = Cliente;
		this.setTiempos();
	}
	
}
