
public class TransactionsDataModule extends Module {

	Client cliente = new Client();
	int bloques;
	RandomValueGenerator generator = new RandomValueGenerator();

	public TransactionsDataModule(Client Cliente) {
		cliente = Cliente;
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
		if(cliente.getTipoConsulta() == 4){ //si es un Select
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
	}

	public Client iniciar(Client Cliente){
		TransactionsDataModule moduloTransacciones = new TransactionsDataModule(Cliente);
		moduloTransacciones.calcularBloquesC();
		moduloTransacciones.setTiempos();
		return cliente;
	}

}
