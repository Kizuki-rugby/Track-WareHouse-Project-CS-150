import java.awt.*;
/**
 * Write a description of class spd_5 here.
 *
 * @author Kizuki Koyasu
 * @version Ver.1
 */
public class spd_5 extends Truck
{
    double miles;
    /**
     * Constructor for objects of class spd_5
     */
    public spd_5(PriorityQueue<Warehouse> manifest, Clock clock){
        super(manifest, clock);
        this.speed = 5;
        this.capacity = 1;
    }

    /**
     * @return the smount of miles it has driven 
     */
    public double getMiles(){
        return miles;
    }

    public void draw(Graphics g){
        Graphics2D graphicsObj = (Graphics2D) g;
        Rectangle truck = new Rectangle((int)xpos, (int)ypos, 10, 10);
        Color color = new Color(255,0,0);
        graphicsObj.setColor(color);
        graphicsObj.fill(truck);
    }

    /**
     * move method for truck.
     */
    public void move(){
        super.move();
    }
}
