import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

/**
 *
 */
public class Simulator {
	double reloj;
	Queue<Event> ListaEventos;
	Client cliente;
    private ArrayList<Servidor> servidores;
    private Queue<Integer> ColaClientes;
    ClientAdmModule moduloAdm;
    ExecuteModule moduloEjecutor;
    QueryModule moduloConsultas;
    ProcessModule moduloProcesos;
    TransactionsDataModule moduloTransacciones;
    boolean terminado;
    int numeroCliente;
    boolean lleno;
	
	public Simulator() {
        servidores = new ArrayList<Servidor>();
        ColaClientes = new LinkedList<Integer>();
        moduloAdm = new ClientAdmModule();
        moduloEjecutor = new ExecuteModule();
        moduloConsultas = new QueryModule();
        moduloProcesos = new ProcessModule();
        moduloTransacciones = new TransactionsDataModule();
        terminado = false;
        numeroCliente = 1;
        lleno = false;
	}
	
	public void iniciarSimulacion() {
        //se inicializa el vector de servidores con el numero k de conexiones del modulo de administracion de clientes
        int conexiones = moduloAdm.getN();
        for (int i = 0; i < conexiones; i++){
            servidores.add(new Servidor());
        }
        servidores.trimToSize();
        while(!terminado){
            //entra un cliente al sistema, asi que se pregunta cual es el primer servidor que puede recibir la consulta
            for(int i = 0; i < servidores.size(); i++){
                if(!lleno){
                    if (!servidores.get(i).isOcupado()){
                        servidores.get(i).iniciar(numeroCliente);
                        numeroCliente++;
                        servidores.get(i).Estadisticas();
                        servidores.get(i).setOcupado();
                    }
                    if (i == servidores.size()-1){
                        lleno = true;
                    }
                }
                else{
                    //si el sistema esta lleno se agrega el nuevo identificador de cliente a cola
                    ColaClientes.add(numeroCliente);
                    terminado = true;
                }
            }

        }
        System.out.println("Fin de la simulacion");
	}
	
	public void configurarVariables() {
		
	}
	
	public void actualizarVariables() {
		
	}
	
	public void generarEstadisticas() {

	}
	
	public void generarEvento() {
		
	}
	
	public void siguienteEventp() {
		
	}
}
