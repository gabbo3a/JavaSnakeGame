// Class to food Manager 
// (Non utilissima se non si fanno piu modalita con piu tipi di food e tipi di incremento)
package snakegame;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Gabbo3a
 */
public class FoodManager {
    private int max;
    private ArrayList<Point> foods;
    
    
    // Bulders
    public FoodManager (int max) {
        this.max = max;
        foods = new ArrayList(max);
    }
    
    public boolean isFull () {
        return foods.size() == max;
    }
    
    // Insert food on the field
    public void insertFood (Point p) {
        foods.add(new Point(p));
    }
    
    // Remove food on the field
    public void removeFood (Point p) {
        foods.remove(p);
    }
    
    // Methods to check if point p is busy by food
    public boolean isBusy (Point p) {
        for (Point food : foods) {
            double distance = food.distance(p);
            if (distance == 0) return true;
        }
        return false;
    }
}
