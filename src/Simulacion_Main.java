/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class Simulacion_Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulator simulador;
        FileWriter estadisticas = null;
        try {
            estadisticas = new FileWriter("estadisticas.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++){
            try {
                estadisticas.write("Simulacion "  + i  + "\n");
                estadisticas.write(" "  + "\n");
            } catch (IOException e){
                e.printStackTrace();
            }
            simulador = new Simulator();
            simulador.iniciarSimulacion(estadisticas);
        }
        try {
            estadisticas.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
