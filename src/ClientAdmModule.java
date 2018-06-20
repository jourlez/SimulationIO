
public class ClientAdmModule extends Module {

	int tipoConsulta;
	float tiempoHilo;
	float tiempoTransmision;


	public ClientAdmModule(Client Cliente) {

	}
	
	public Client nuevoCliente() {
		Client cliente = new Client();
		return cliente;
	}
	
	public void rechazarConexion() {
		
	}

}
