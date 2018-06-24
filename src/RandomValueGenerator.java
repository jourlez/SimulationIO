import java.util.Random;
/**
 *
 */
public class RandomValueGenerator {
    int n;
    Random random = new Random();

    public RandomValueGenerator(){
        int n = 0;
    }

    public int tipoConsulta(){
        float aleatorio = random.nextFloat();
        if(aleatorio < 0.29){
            n = 1; //equivale al query SELECT
        }
        else if (aleatorio < 0.54){
            n = 2; //equivale al query UPDATE
        }
        else if (aleatorio < 0.89){
            n = 3; //equivale al query JOIN
        }
        else{
            n = 4; //equivale al query DLL
        }
        return n;
    }

    public double validacionSintactica(){
        float sintactica = random.nextFloat();
        return  sintactica;
    }

    public double validacionSemantica(){
        float semantica = random.nextInt(2) + random.nextFloat();
        return  semantica;
    }

    public int bloquesJoin(){
        int bloques = random.nextInt(64) + 1;
        return bloques;
    }

    /*
     * Metodo encargado de procesar un numero aleatorio para convertirlo en el tiempo entre llamadas, o sea, el tiempo cuando va a llamar el siguiente cliente
     * Tabla Llegadas
     * 1 segundos --> 0.20
     * 2 segundos --> 0.60
     * 3 segundos --> 0.20
     */
    public int Llegada() {
        /**int llegada;
        float aleatorio = random.nextFloat();
        if (aleatorio <= 0.19) {
            llegada = 1;
        } else if (aleatorio <= 0.79) {
            llegada = 2;
        } else {
            llegada = 3;
        }
        return llegada;**/
        return 1;
    }
}
