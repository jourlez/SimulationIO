import java.util.Queue;

/**
 *
 */
public class Simulator {
	double reloj;
	Queue<Event> ListaEventos;
	ClientAdmModule moduloAdm;
	ExecuteModule moduloEjecutor;
	QueryModule moduloConsultas;
	ProcessModule moduloProcesos;
	TransactionsDataModule moduloTransacciones;
	Client cliente;
	
	public Simulator() {
		moduloAdm = new ClientAdmModule();
		moduloEjecutor = new ExecuteModule();
		moduloConsultas = new QueryModule();
		moduloProcesos = new ProcessModule();
		moduloTransacciones = new TransactionsDataModule();
		cliente = new Client();
	}
	
	public void iniciarSimulacion() {
		cliente = moduloAdm.iniciar();
		moduloProcesos.iniciar(cliente);
		moduloEjecutor.iniciar(cliente);
		moduloTransacciones.iniciar(cliente);
	}
	
	public void configurarVariables() {
		
	}
	
	public void actualizarVariables() {
		
	}
	
	public void generarEstadisticas() {
		System.out.println("El identificador del cliente es: " + cliente.getIdentificador());
		System.out.println("El cliente es de tipo: " + cliente.getTipoConsulta());
		System.out.println("El cliente es read-only?: " + cliente.isReadOnly());
		System.out.println("El tiempo de analisis lexico del cliente fue de: " + cliente.getLexica());
		System.out.println("El tiempo de analisis sintactico del cliente fue de: " + cliente.getSintactica());
		System.out.println("El tiempo de analisis semantico del cliente fue de: " + cliente.getSemantica());
		System.out.println("El tiempo de analisis de permisos del cliente fue de: " + cliente.getPermisos());
		System.out.println("El tiempo de analisis de optimizacion del cliente fue de: " + cliente.getOptimizacion());
		System.out.println("Los numeros de datos del cliente fueron de: " + cliente.getNumeroDatos());
		System.out.println("El tiempo de ejecucion del cliente fue de: " + cliente.getTiempoEjecucion());
	}
	
	public void generarEvento() {
		
	}
	
	public void siguienteEventp() {
		
	}
}
