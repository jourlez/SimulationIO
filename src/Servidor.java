import java.io.FileWriter;
import java.io.IOException;

public class Servidor {

    public Client cliente;
    ClientAdmModule moduloAdm;
    ExecuteModule moduloEjecutor;
    QueryModule moduloConsultas;
    ProcessModule moduloProcesos;
    TransactionsDataModule moduloTransacciones;
    public boolean ocupado;
    public double tiempo;

    public Servidor(){
        moduloAdm = new ClientAdmModule();
        moduloEjecutor = new ExecuteModule();
        moduloConsultas = new QueryModule();
        moduloProcesos = new ProcessModule();
        moduloTransacciones = new TransactionsDataModule();
        cliente = new Client();
        ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado() {
        this.ocupado = true;
    }

    public void setDesocupado(){
        this.ocupado = false;
    }

    public void iniciar(int numCliente){
        cliente = moduloAdm.iniciar(numCliente);
        moduloConsultas.iniciar(cliente);
        moduloProcesos.iniciar(cliente);
        moduloTransacciones.iniciar(cliente);
        moduloEjecutor.iniciar(cliente);
    }

    public void Estadisticas(FileWriter archivo){
        String tipo = "";
        System.out.println("El identificador del cliente es: " + cliente.getIdentificador());
        if(cliente.getTipoConsulta() == 1){ //SELECT
            tipo = "SELECT";
        }
        else if (cliente.getTipoConsulta() == 2){ //UPDATE
            tipo = "UPDATE";
        }
        else if (cliente.getTipoConsulta() == 3){ //JOIN
            tipo = "JOIN";
        }
        else { //DDL
            tipo = "DDL";
        }
        System.out.println("El cliente es de tipo: " + tipo);
        System.out.println("El cliente es read-only?: " + cliente.isReadOnly());
        System.out.println("El tiempo de analisis lexico del cliente fue de: " + cliente.getLexica());
        System.out.println("El tiempo de analisis sintactico del cliente fue de: " + cliente.getSintactica());
        System.out.println("El tiempo de analisis semantico del cliente fue de: " + cliente.getSemantica());
        System.out.println("El tiempo de analisis de permisos del cliente fue de: " + cliente.getPermisos());
        System.out.println("El tiempo de analisis de optimizacion del cliente fue de: " + cliente.getOptimizacion());
        System.out.println("Los numeros de datos del cliente fueron de: " + cliente.getNumeroDatos());
        System.out.println("El tiempo de carga de los bloques del cliente son de: " + cliente.getTiempoCarga());
        System.out.println("El tiempo de ejecucion del cliente fue de: " + cliente.getTiempoEjecucion());
        System.out.println();
        try {
            archivo.write("El identificador del cliente es: " + cliente.getIdentificador() + "\n");
            archivo.write("El cliente es de tipo: " + tipo + "\n");
            archivo.write("El cliente es read-only?: " + cliente.isReadOnly() + "\n");
            archivo.write("El tiempo de análisis léxico del cliente fue de: " + cliente.getLexica() + "\n");
            archivo.write("El tiempo de análisis sintáctico del cliente fue de: " + cliente.getSintactica() + "\n");
            archivo.write("El tiempo de análisis semántico del cliente fue de: " + cliente.getSemantica() + "\n");
            archivo.write("El tiempo de análisis de permisos del cliente fue de: " + cliente.getPermisos() + "\n");
            archivo.write("El tiempo de análisis de optimización del cliente fue de: " + cliente.getOptimizacion() + "\n");
            archivo.write("Los números de datos del cliente fueron de: " + cliente.getNumeroDatos() + "\n");
            archivo.write("El tiempo de carga de los bloques del cliente son de: " + cliente.getTiempoCarga() + "\n");
            archivo.write("El tiempo de ejecución del cliente fue de: " + cliente.getTiempoEjecucion() + "\n");
            archivo.write(" "  + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getTiempos(){
        tiempo = cliente.getLexica() + cliente.getSintactica() + cliente.getSemantica() + cliente.getPermisos() + cliente.getOptimizacion();
    }
}
