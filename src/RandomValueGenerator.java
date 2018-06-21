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
}
