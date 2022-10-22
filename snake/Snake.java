// Class snake

package snake;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Gabbo3a
 */
public class Snake {
    // Definitions
    enum Direction {TOP, RIGHT, BOTTOM, LEFT, NULL }
    public record SnakePoint (Point p, Point oldP) {} 
    
    // Data
    // private SnakePoint head;
    private Direction direction;
    private ArrayList<SnakePoint> body; // Snake body 
    
    // Bulders
    public Snake(Point headPosition, Direction dir) {
        body = new ArrayList(10); // Allocate memory
   
        // Init head and small tail to start game
        body.add(new SnakePoint(headPosition, headPosition));  // Haad
        for (int i = 1; i < 3; i++) {
            Point p = new Point((int) headPosition.x-i, headPosition.y);
            body.add(new SnakePoint(p, p));
        }
    }
    
    // [0] = head snake, [1-N] = tail
    // senza concetto di dimensione del campo (da mettere poi)
    public void move () { 
        
        // Move head logic
        // body.get(0).oldP.setLocation(body.get(0).p);
        body.set(0, new SnakePoint(new Point(body.get(0).p), new Point(body.get(0).p)));
        
        switch (direction) {
            case TOP:    body.get(0).p.translate(0,-1); break;
            case BOTTOM: body.get(0).p.translate(0, 1); break;
            case LEFT:   body.get(0).p.translate(-1,0); break;
            case RIGHT:  body.get(0).p.translate(1, 0); break;
            // default: throw new AssertionError();
        }
        
        // Propagation points 
        for (int i = 1; i < body.size(); i++) {
            
            Point o = new Point(body.get(i).p);         // Save his old point
            Point p = new Point(body.get(i-1).oldP);    // And then propagation
            body.set(i, new SnakePoint(p, o));          // Set
            
            //
            // body.get(i).oldP.setLocation(body.get(i).p);    // Save his old point 
            // body.get(i).p.setLocation(body.get(i-1).oldP);     // And then propagation
        }
    }
    
  
    // Util method
    // Setter & Getter
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    @Override
    public String toString() {
        String s = "Direction: " + direction + "\n"; 
        
        for (int i = 0; i < body.size(); i++) {
            s +=  "p"+ i +":    " + body.get(i).p + "\n";
            s +=  "OldP" + i +": " +  body.get(i).p + "\n";
            s +=  "----------------------------------\n";
        }
        for (SnakePoint snakePoint : body) {
            
            
        }
        return s;
    }
}
