package snakegame;

import java.awt.Point;

/**
 *
 * @author Gabbo3a
 */
public class SnakeGame {

    // Tests scemi scemi
    public static void testSnakeOBJ() {
        Snake snake = new Snake(new Point(4, 8), Snake.Direction.RIGHT, 15);
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // new Screen(15, 20);
        new Screen(20, 5);
    }
}