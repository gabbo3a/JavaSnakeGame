// Class to rendering data model with snake game

package snakegame;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gabbo3a
 */
public class Screen extends JFrame implements KeyListener {
    private JPanel grid;                          // Container to grid
    private JPanel[][] tiles;                     // Matrix to rendering JPanel
    private Field field;                          // Data manager
    private boolean isStarted = false;            // Game is started
    
    // Builders
    public Screen (int size, int nfood) {
        // Init grid 
        grid = new JPanel(new GridLayout(size, size, 1, 1));
        grid.setBackground(Color.DARK_GRAY);
        
        // Init data manager
        field = new Field(size, nfood);
        
        // Init of frame
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setIconImage(new ImageIcon("snake.png").getImage());
        
        // Init gui field
        tiles = new JPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j]  = new JPanel();
                grid.add(tiles[i][j]);
            }
        }
        
        // Options
        this.add(grid);             // Add gris on frame
        this.setVisible(true);      
        this.addKeyListener(this);  // Event 
        this.setFocusable(true);    // Event     
        
        // Start Game (rendering)
        rendering(150);
    }
    
    // Methods to draw data model on GUI grid
    private void draw(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                switch (field[i][j]) {
                    case 0: tiles[i][j].setBackground(Color.BLACK); break;
                    case 1: tiles[i][j].setBackground(Color.GREEN); break;
                    case 3: tiles[i][j].setBackground(Color.CYAN);  break;
                    case 2: tiles[i][j].setBackground(Color.RED);   break;
                }
            }
        } 
    }
    
    // rendering methods (Si potrebbere fare una classe a parte che gestisce l clock)
    private void rendering (int msec) {
        boolean gameover = false;
        
        // Game main loop
        while (!gameover) {         
            try {
                draw(field.buildMatrixField());      // Draw dynamic matrix
                if (isStarted) gameover = !field.getSnake().move(); // Move
                field.checkSuperimposedAllPoint();
                Thread.sleep(msec);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
        // End game
        JOptionPane.showMessageDialog(this,"You are a loser 💩", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
        this.dispose(); // Close frame
    }

    @Override
    public void keyTyped(KeyEvent e) {  
        // Command mapping
        final Character[] TOP    = { 'w', 'W', KeyEvent.VK_UP };
        final Character[] BOTTOM = { 's', 'S', KeyEvent.VK_DOWN };
        final Character[] LEFT   = { 'a', 'A', KeyEvent.VK_LEFT };
        final Character[] RIGHT  = { 'd', 'D', KeyEvent.VK_RIGHT };
       
        
        // Change direction
        isStarted = true;
        Snake snake = field.getSnake();
        if (Arrays.asList(TOP).contains(e.getKeyChar())) 
            snake.setDirection(Snake.Direction.TOP);

        if (Arrays.asList(BOTTOM).contains(e.getKeyChar())) 
            snake.setDirection(Snake.Direction.BOTTOM);

        if (Arrays.asList(LEFT).contains(e.getKeyChar())) 
            snake.setDirection(Snake.Direction.LEFT);

        if (Arrays.asList(RIGHT).contains(e.getKeyChar())) 
            snake.setDirection(Snake.Direction.RIGHT);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
