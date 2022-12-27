import java.awt.*;
/**
 * Write a description of class spd_3 here.
 *
 * @author Kizuki Koyasu
 * @version Ver.1
 */
public class spd_3 extends Truck 
{
    double miles;
    /**
     * Constructor for objects of class spd_3
     */
    public spd_3(PriorityQueue<Warehouse> manifest, Clock clock)
    {
        super(manifest, clock);
        this.speed = 3;
        this.capacity = 3;
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
