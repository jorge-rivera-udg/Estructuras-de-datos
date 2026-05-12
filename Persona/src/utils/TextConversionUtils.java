/*
 * Ambriz Cordero Diego Said
 * Medeles Bryan Jonathan
 * Rivera Andrade Jorge
 */
package utils;

/**
 *
 * @author jra
 */
public class TextConversionUtils {
    
    public int getInt(String text) {
        try{
            return Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
    
    public float getFloat(String text) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException nfe){
            return 0;
        }
    }
    
    public double getDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException nfe){
            return 0;
        }
    }
}
