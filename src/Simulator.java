import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

/**
 *
 */
public class Simulator {
	double reloj;
	ArrayList<Event> ListaEventos;
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

    double tiempoLimite;
    RandomValueGenerator generator;
    private ArrayList<Integer> tablaLlegadas;
    private ArrayList<Integer> tablaSalidas;
	
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
        tiempoLimite = 0;
        generator = new RandomValueGenerator();
        ListaEventos = new ArrayList<Event>();
        tablaLlegadas = new ArrayList<Integer>();
        //agrega un elemento para que coincidan los indices
        tablaLlegadas.add(-1);
        tablaSalidas = new ArrayList<Integer>();
        //agrega un elemento para que coincidan los indices
        tablaSalidas.add(-1);
	}
	
	public void iniciarSimulacion(FileWriter estadisticas) {
        //se inicializa el vector de servidores con el numero k de conexiones del modulo de administracion de clientes
        int conexiones = moduloAdm.getN();
        int i = 0;
        int u = 0;
        int llegada = 0;
        int salida = 0;
        int tiempo = 0;
        for (int j = 0; j < conexiones; j++){
            servidores.add(new Servidor());
        }

        this.setTiempoLimite(100);
        //se produce la primera llegada, con el reloj en 0
        tablaLlegadas.add(0);
        while(!terminado){
            //pregunta si el reloj ya llego al tiempo limite
            if (tiempo >= tiempoLimite){
                terminado = true;
            }
            //pregunta si deberia de haber una salida
            if (tablaSalidas.contains(tiempo)){
                //saca el elemento que va a salir
                for (int t = 0; t < servidores.size(); t++){
                    if (servidores.get(t).cliente.getNumero() == tablaSalidas.indexOf(tiempo)){
                        servidores.get(t).setDesocupado();
                        System.out.println("");
                        System.out.println("Se ha producido la salida del " + servidores.get(t).cliente.getIdentificador());
                        System.out.println("");
                        lleno = false;
                    }
                }
            }
            //pregunta si deberia de haber una llegada
            if (tablaLlegadas.contains(tiempo)){
                //entra un cliente al sistema, asi que se pregunta cual es el primer servidor que puede recibir la consulta
                while(i < servidores.size() && tiempo <= tiempoLimite) {
                    if(!lleno){
                        if (!servidores.get(i).isOcupado()){
                            //mete un cliente nuevo al sistema
                            System.out.println("Se produjo una llegada en el tiempo: " + tiempo);
                            servidores.get(i).iniciar(numeroCliente);
                            salida = (int)Math.ceil(servidores.get(i).getTiempos());
                            //crea un evento en la tabla de eventos
                            ListaEventos.add(new Event(numeroCliente, tiempo, salida + tiempo));
                            numeroCliente++;
                            //se agrega la salida a la tabla
                            int salidaTotal = salida + tiempo;
                            tablaSalidas.add(salidaTotal);
                            reloj += servidores.get(i).getTiempos() + tiempo;
                            servidores.get(i).Estadisticas(estadisticas);
                            System.out.println("Reloj: " + reloj);
                            try {
                                estadisticas.write("Tiempo Entrada; " + tiempo + "\n");
                                estadisticas.write("Tiempo Salida: " + salidaTotal + "\n");
                                estadisticas.write(" "  + "\n");
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            System.out.println();
                            servidores.get(i).setOcupado();
                            //despues de meter un cliente, produce una entrada nueva
                            tablaLlegadas.add(generator.Llegada() + tiempo);
                            //produce una bandera para salir del sistema apenas se meta el cliente al sistema
                            i = servidores.size();
                        }
                        if (i == servidores.size()-1){
                            lleno = true;
                        }
                    }
                    else{
                        //si el sistema esta lleno se ignora la conexion
                        //se produce una llegada
                        tablaLlegadas.add(generator.Llegada() + tiempo);
                        // terminado = true;
                    }
                    i++;
                }
            }
            //aumenta tiempo
            tiempo++;
            i = 0;
        }


        System.out.println("Fin de la simulacion");
	}
	
	public void configurarVariables() {

    }

	public void desocuparServidores() {
	    for (int i = 0; i < servidores.size(); i++){
                servidores.get(i).setDesocupado();
            }
	}

	
	public void actualizarVariables() {
		
	}
	
	public void generarEstadisticas() {

	}
	
	public void generarEvento() {
		
	}
	
	public void siguienteEventp() {
		
	}

    public void setTiempoLimite(double tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }
}
