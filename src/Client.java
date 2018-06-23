public class Client {
    private String identificador;
    private double tiempoHilo;
    private int tiempoTransmision;
    private int tipoConsulta;
    private boolean readOnly;
    private double lexica;
    private double sintactica;
    private double semantica;
    private double permisos;
    private double optimizacion;
    private int concurrencia;
    private int numeroDatos;
    private int tiempoEjecucion;
    private double tiempoCarga;


    public Client(){
        this.identificador = "default";
        this.tipoConsulta = 0;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public int getTiempoTransmision() {
        return tiempoTransmision;
    }

    public double getLexica() {
        return lexica;
    }

    public double getSemantica() {
        return semantica;
    }

    public double getSintactica() {
        return sintactica;
    }

    public double getPermisos() {
        return permisos;
    }

    public double getOptimizacion() {
        return optimizacion;
    }

    public int getNumeroDatos() {
        return numeroDatos;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public double getTiempoCarga() {
        return tiempoCarga;
    }

    public void setIdentificador(String nombre){
        this.identificador = nombre;
    }

    public void setTipoConsulta(int numeroConsulta){
        this.tipoConsulta = numeroConsulta;
    }

    public String getIdentificador(){
        return identificador;
    }

    public void setConcurrencia(int concurrencia) {
        this.concurrencia = concurrencia;
    }

    public void procesamientoConsultas(double Lexica, double Sintactica, double Semantica, double Permisos, double Optimizacion){
        this.lexica = Lexica;
        this.sintactica = Sintactica;
        this.semantica = Semantica;
        this.permisos = Permisos;
        this.optimizacion = Optimizacion;
    }

    public void setNumeroDatos(int numeroDatos) {
        this.numeroDatos = numeroDatos;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setAdministracion(double TH, int TT){
        tiempoHilo = TH;
        tiempoTransmision = TT;
    }

    public void setTiempoCarga(double tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
}
