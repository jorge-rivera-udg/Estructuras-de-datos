/*
 * Ambriz Cordero Diego Said
 * Medeles Bryan Jonathan
 * Rivera Andrade Jorge
 */
package back.utils;

/**
 *
 * @author jra
 */
public class TextoANumeroUtils {
    public static int obtenerEntero(String text) {
        try{
            return Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
    
    public static float obtenerFlotante(String text) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException nfe){
            return 0;
        }
    }
    
    public static double obtenerDoble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException nfe){
            return 0;
        }
    }
}
