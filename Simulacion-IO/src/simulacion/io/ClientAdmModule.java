
public class ClientAdmModule extends Module {

	int tipoConsulta;
	double tiempoHilo;
	double tiempoTransmision;
	//se definen cuantas conexiones simultaneas se pueden hacer
    int n = 10;
    int conexiones = 0;
    Client cliente;
    int numeroCliente;
    RandomValueGenerator generator = new RandomValueGenerator();


	public ClientAdmModule(Client Cliente) {

	}

    /**
     * Metodo responsable de crear un nuevo cliente, y llenar sus datos primarios
     * @return
     */
	public Client nuevoCliente() {
		cliente = new Client();
		conexiones++;
		cliente.setIdentificador("cliente" + numeroCliente);
        cliente.setTipoConsulta(generator.tipoConsulta());
        if (cliente.getTipoConsulta() == 1 || cliente.getTipoConsulta() == 3){
            cliente.setReadOnly(true);
        } else{
            cliente.setReadOnly(false);
        }
		return cliente;
	}
	
	public void rechazarConexion() {
		if (conexiones > n){
		    System.out.println("Conexion rechazada");
        }
        else{
		    nuevoCliente();
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
     * @param Cliente
     * @return cliente, que sirve de parametro para el siguiente modulo
     */
    public Client iniciar(Client Cliente){
	    ClientAdmModule moduloAdm = new ClientAdmModule(Cliente);
	    moduloAdm.rechazarConexion();
	    moduloAdm.setTiempos();
	    return cliente;
    }
}
