
public class ProcessModule extends Module {

	Client cliente;
	RandomValueGenerator generator = new RandomValueGenerator();

	public ProcessModule() {
	}
	
	public void crearHilo() {
		
	}
	
	public void calcularTiempoCreacion() {
		
	}
	
	public void procesarConsulta() {
		
	}

	@Override
	public void setTiempos() {
		double optimizacion;
		if(cliente.isReadOnly()){
			optimizacion = 0.1;
		}
		else{
			optimizacion = 0.25;
		}
		cliente.procesamientoConsultas(0.1, generator.validacionSintactica(), generator.validacionSemantica(), 0.7, optimizacion);
	}

	/**
	 * Metodo para iniciar la simulacion del procesamiento de consultas
	 * @param Cliente
	 * @return cliente, que sirve de parametro para el siguiente modulo
	 */
	public void iniciar(Client Cliente){
		cliente = Cliente;
		this.setTiempos();
	}
}
