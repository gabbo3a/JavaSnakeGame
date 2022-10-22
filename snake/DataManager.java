// Class to manage data with snake game

package snake;

/**
 *
 * @author Gabbo3a
 */
public class DataManager {
    
    // Const
    public static final byte GRASS = 0; 
    public static final byte SNAKE_BODY = 1;
    public static final byte APPLE = 2;
    
    // State
    private byte [][] field;  // = new int[10][20];

    // Builders
    public DataManager() {}
    public DataManager(int size) {
        field = new byte [size][size];
       
    }
    public DataManager(byte [][] field) {
        this.field = field;
    }
    
    // Print field method
    public void print (){
        for (byte[] is : field) {
            for (byte i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    } 

    // Snake move method
    // 1 = top, 2 = right, 3 = bottom, 4 = left
    public void move (int direction) {
        
    }
    
    
}
