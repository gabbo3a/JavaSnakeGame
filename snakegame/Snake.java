// Class snake

package snakegame;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Gabbo3a
 */
public class Snake {
    // Definitions
    enum Direction {TOP, RIGHT, BOTTOM, LEFT, NULL }
    
    // Data
    private int fieldSize;
    private Direction direction = Direction.RIGHT;
    private ArrayList<Point> body; // Snake body 
    
    // Bulders
    public Snake(Point headPosition, Direction dir, int fieldSize) {
        this.fieldSize = fieldSize;
        body = new ArrayList(10); // Allocate memory
   
        // Init head and small tail to start game
        body.add(headPosition); // Haad
        for (int i = 1; i < 3; i++) {
            body.add(new Point(headPosition.x-i, headPosition.y));
        }
    }
    
    // Eats methods (add point in same position on last point pre-update)
    public void eats () {
        body.add(new Point(body.get(body.size()-1)));
    }
    
    // Method to check if point p is busy by snake
    public boolean isBusy (Point p) {
        for (Point snakePoint : body) {
            double distance = snakePoint.distance(p);
            if (distance == 0) return true;
        }
        return false;
    }

    // Method to check if next point is valid
    private boolean check (Point nextPoint) {
        // Check if the snake hit itself
        for (Point point : body) 
            if (point.distance(nextPoint) == 0) return false;
        System.out.println();
        // Check if snake out of scope
        if (nextPoint.x < 0 || nextPoint.x >= fieldSize) return false;
        if (nextPoint.y < 0 || nextPoint.y >= fieldSize) return false;
        
        return true;
    }
    
    // Methods to propagation points 
    private void propagation () {
        Point c1 = new Point(body.get(0)); // Save old head point
        Point c2 = new Point();            // Save old first tail point
        
        // Propagation points
        for (int i = 1; i < body.size(); i++) {
            // Alternate commodo var
            if (i % 2 != 0) {
                c2 = new Point(body.get(i));                // Save his old point
                body.set(i, c1);                            // And then propagation
            } else { 
                c1 = new Point(body.get(i));                // Save his old point
                body.set(i, c2);                            // And then propagation
            }
        }
    }
    
    // Methods to move snake
    public boolean move () {
        propagation();      // Propagation snake point
       
        // Check and move
        Point next = (Point) body.get(0).clone();
        switch (direction) {
               case TOP:    next.translate(0,-1); break;
               case BOTTOM: next.translate(0, 1); break;
               case LEFT:   next.translate(-1,0); break;
               case RIGHT:  next.translate(1, 0); break;
        }
        if (check(next)) {
            body.set(0, next);
            return true;
        } 
        else return false;
    }
    
    // Util method
    // Setter & Getter
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) {
        
        // Brutto da ripensare in modo piu carino
        if (this.direction == Direction.TOP && direction == Direction.BOTTOM) return;
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT) return;
        if (this.direction == Direction.BOTTOM && direction == Direction.TOP) return;
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) return;
        this.direction = direction; 
    }
    
    public ArrayList<Point> getBody() { return body; }

    @Override
    public String toString() {
        String s = "Direction: " + direction + "\n"; 
        for (int i = 0; i < body.size(); i++) {
            s +=  "p-"+ i +":" + body.get(i) + "\n";
        }
        s +=  "---------------------------\n";
        return s;
    }
}