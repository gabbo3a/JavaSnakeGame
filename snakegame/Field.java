// Class to management game data
package snakegame;

import java.awt.Point;

/**
 *
 * @author Gabbo3a
 */
public class Field {
    private int size;
    private Snake snake;
    private FoodManager foodManager;

    // Builders
    public Field (int size, int nfood) {
        this.size = size;
        snake = new Snake(new Point(4, (size-1)/2), Snake.Direction.RIGHT, size); // size is shots
        foodManager = new FoodManager(nfood);
        foodFiller();
    }

    // Method to fill food on the field
    public void foodFiller () {
        // Genarete foods
        while (true) {
           int x = (int) (Math.random() * (this.size));
           int y = (int) (Math.random() * (this.size));
           Point p = new Point(x, y);
           
           if (!snake.isBusy(p) && !foodManager.isBusy(p)) foodManager.insertFood(p);
           if (foodManager.isFull()) break;
        }
    }

    // Build matrix field to pass a rendering obj
    public int[][] buildMatrixField () {
        Point snakeHead = snake.getBody().get(0);
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Point p = new Point(j, i);
                if (snake.isBusy(p)){
                    if (snakeHead.distance(p) == 0) matrix[i][j] = 3;
                    else matrix[i][j] = 1;
                }
                else if (foodManager.isBusy(p)) matrix[i][j] = 2;
                else matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    // Method to check if snake superimposed on an apple
    public void checkSuperimposedAllPoint () {
        for (Point food : foodManager.getFoods()) {
            if (snake.isBusy(food) && foodManager.isBusy(food)) {
                snake.eats();                   // Snake growth
                foodManager.removeFood(food);   // Removal of eaten apple
                foodFiller();                   // Generate new apple and fill food max gap
                break;
            }
        }
    }
    
    // Getter & Setter
    public Snake getSnake() { return snake; }
    public void setSnake(Snake snake) { this.snake = snake; }

    // Print field like matrix
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Point p = new Point(j, i);
                if (snake.isBusy(p))            s += "1 ";
                else if (foodManager.isBusy(p)) s += "2 ";
                else s += ". ";
            }
            s += "\n";
        }
        return s;
    }
}
