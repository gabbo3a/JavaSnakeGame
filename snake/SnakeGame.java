package snake;

import java.awt.Point;
import javax.swing.*;

/**
 *
 * @author Gabbo3a
 */
public class SnakeGame {

    // Test snake obj
    public static void testSnakeOBJ() {
        // Sembra corretto da riguardare
        
        Snake snake = new Snake(new Point(4, 8), Snake.Direction.RIGHT);
        System.out.println(snake);
        
        // Primo move
        snake.setDirection(Snake.Direction.RIGHT);
        snake.move();
        System.out.println(snake);
        
        // Secondo move
        snake.setDirection(Snake.Direction.TOP);
        snake.move();
        System.out.println(snake);
        
        // Terzo move
        snake.setDirection(Snake.Direction.TOP);
        snake.move();
        System.out.println(snake);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Rendering
        JFrame screen = new JFrame();
        screen.setSize(200, 200);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // gestioe campo futuro field
        // DataManager dManager = new DataManager(11);
        // dManager.print();
        
        
        testSnakeOBJ();
    }
}
