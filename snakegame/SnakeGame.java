package snakegame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gabbo3a
 */
public class SnakeGame {

    // Tests scemi scemi
    public static void testSnakeOBJ() {
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
    public static void testFiledsOBJ() {
        Field f = new Field(15, 2);
        f.init();
        System.out.println(f); 
    }
    public static void testMove_1(Field f) {
    
        System.out.println(f);
        Snake snake = f.getSnake();
            
        // Primo move
        snake.setDirection(Snake.Direction.RIGHT);
        snake.move();
        System.out.println(f);
        
        // Secondo move
        snake.setDirection(Snake.Direction.TOP);
        snake.move();
        System.out.println(f);
        
        // Terzo move
        snake.setDirection(Snake.Direction.TOP);
        snake.move();
        System.out.println(f);
    }
    

    
    // Test filds obj
    public static void start(int size, int nfood) {
        Field f = new Field(size, nfood);
        f.init();
   
        int[][] m = f.buildMatrixField();
        
        Screen screen = new Screen(size);
        
        
        testMove_1(f);
        
        screen.rendering(m);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start(15, 2);
    }
}

// inplementare aumento tramite mele (fuori da qui)
// testSnakeOBJ();
// testFiledsOBJ();
// testMove_1();