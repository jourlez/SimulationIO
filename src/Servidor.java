public class Servidor {

    public Client cliente;
    ClientAdmModule moduloAdm;
    ExecuteModule moduloEjecutor;
    QueryModule moduloConsultas;
    ProcessModule moduloProcesos;
    TransactionsDataModule moduloTransacciones;
    public boolean ocupado;

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

    public void Estadisticas(){
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
        System.out.println();
    }
}
