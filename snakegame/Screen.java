// Class to rendering data model with snake game

package snakegame;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gabbo3a
 */
public class Screen extends JFrame{
    private static final GridLayout layout = new GridLayout(15, 15, 1, 1);
    private JPanel grid;
    private JPanel[][] tiles; 
    
    // Builders
    public Screen (int size) {
        
        //
        grid = new JPanel(layout);
        grid.setBackground(Color.DARK_GRAY);
        // grid.setVisible(true);
        
        // Init of frame
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Init gui field
        tiles = new JPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j]  = new JPanel();
                grid.add(tiles[i][j]);
            }
        }
        
        this.add(grid);         // Add gris on frame
        this.setVisible(true);  
    }
    
    // Methods to draw data model on GUI grid
    private void draw(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                switch (field[i][j]) {
                    case 0: tiles[i][j].setBackground(Color.BLACK); break;
                    case 1: tiles[i][j].setBackground(Color.GREEN); break;
                    case 2: tiles[i][j].setBackground(Color.RED);   break;
                }
                
            }
        }
        
    }
    
    public void rendering (int[][] field) {
        while (true) {         
            try {
                draw(field);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
