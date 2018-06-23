
public class ClientAdmModule extends Module {

	int tipoConsulta;
	double tiempoHilo;
	double tiempoTransmision;
	//se definen cuantas conexiones simultaneas se pueden hacer
    int n = 5;
    int conexiones = 0;
    Client cliente;
    int numeroCliente = 0;
    RandomValueGenerator generator = new RandomValueGenerator();


	public ClientAdmModule() {
        tipoConsulta = 0;
        tiempoHilo = 0;
        tiempoTransmision = 0;
	}

    /**
     * Metodo responsable de crear un nuevo cliente, y llenar sus datos primarios
     * @return cliente, que sirve de parametro para el iniciar
     */
	public Client nuevoCliente(int NumCliente) {
		cliente = new Client();
		cliente.setIdentificador("cliente" + NumCliente);
		conexiones++;
		return cliente;
	}

	@Override
	public int getN() {
		return n;
	}

	public void rechazarConexion() {
		if (conexiones > n){
		    System.out.println("Conexion rechazada");
        }
	}

	public void salidaCliente(){
	    conexiones--;
    }

    @Override
    public void setTiempos() {
        cliente.setAdministracion(0.7, 12);
    }

    /**
     * Metodo para iniciar la simulacion del modulo de administracion de clientes
     * @return cliente, que sirve de parametro para el siguiente modulo
     */
    public Client iniciar(int NumCliente){
	    cliente = nuevoCliente(NumCliente);
	    this.setTiempos();
	    return cliente;
    }
}
