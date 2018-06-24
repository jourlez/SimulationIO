
public class TransactionsDataModule extends Module {

	Client cliente = new Client();
	int bloques;
	RandomValueGenerator generator = new RandomValueGenerator();

	public TransactionsDataModule() {
		bloques = 0;
	}
	
	public void desocuparProcesos() {
		
	}
	
	public void calcularNuevaTransaccion() {
		
	}
	
	public void transaccionACola() {
		
	}
	
	public void calcularTiempoConcurrente() {
		
	}
	
	public void accesoADatos() {
		
	}
	
	public void calcularBloquesC() {
		if(cliente.getTipoConsulta() == 1){ //si es un Select
			bloques = 1;
		}
		else if (cliente.getTipoConsulta() == 3) {
			bloques = generator.bloquesJoin(); //cantidad de bloques del Join: distribucion uniforme en 1,2,3...64
		}
		//si es DDL o UPDATE tienen 0 bloques cargados, que se inicia en el constructor
	}
	
	public void procesarSalida() {
		
	}
	
	public void calcularTiempoBloque() {
		
	}

	public void setTiempos(){
		cliente.setNumeroDatos(bloques); //cada bloque dura 0.1 segundos para ejecutarse
		cliente.setTiempoCarga((double)bloques/10);
	}

	public void iniciar(Client Cliente){
		cliente = Cliente;
		this.calcularBloquesC();
		this.setTiempos();
	}

}
