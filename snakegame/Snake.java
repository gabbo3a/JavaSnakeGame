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
    // public record SnakePoint (Point p, Point oldP) {} 
    
    // Data
    // private SnakePoint head;
    private Direction direction = Direction.RIGHT;
    private ArrayList<Point> body; // Snake body 
    
    // Bulders
    public Snake(Point headPosition, Direction dir) {
        body = new ArrayList(10); // Allocate memory
   
        // Init head and small tail to start game
        body.add(headPosition); // Haad
        for (int i = 1; i < 3; i++) {
            body.add(new Point(headPosition.x-i, headPosition.y));
        }
    }
    

    // Eats methods (add point in same position on last point pre-update)
    private void eats () {
        Point p = new Point(body.get(body.size()-1));
        body.add(p);
    }
    
    // [0] = head snake, [1-N] = tail
    // Eats methods
    // implemetare dimensioni  campoù
    // implemetare blocchi (se sei TOP, no puoi BOTTOM ecc)
    // ---------------------------------------------------------------------------------------------------------------------------------------------
    private void check () {
        
        // NewPoint of Head 
        // | implementare check
        switch (direction) {
            case TOP:    body.get(0).translate(0,-1); break;
            case BOTTOM: body.get(0).translate(0, 1); break;
            case LEFT:   body.get(0).translate(-1,0); break;
            case RIGHT:  body.get(0).translate(1, 0); break;
            // default: throw new AssertionError();
        }
    }
    
    // Methods to check if point p is busy by snake
    public boolean isBusy (Point p) {
        for (Point snakePoint : body) {
            double distance = snakePoint.distance(p);
            if (distance == 0) return true;
        }
        return false;
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
    public void move () {
        this.propagation();
        this.check();
    }
    
    // Util method
    // Setter & Getter
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

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
