import java.awt.*;

/**
 * Write a description of class spd_4 here.
 *
 * @author Kizuki Koyasu
 * @version Ver.1
 */
public class spd_4 extends Truck
{
    double miles;
    /**
     * Constructor for objects of class spd_4
     */
    public spd_4(PriorityQueue<Warehouse> manifest, Clock clock)
    {
        super(manifest, clock);
        this.speed = 4;
        this.capacity = 2;
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
