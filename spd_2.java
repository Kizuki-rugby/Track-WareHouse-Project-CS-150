import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;

/**
 * Write a description of class spd_2 here.
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class spd_2 extends Truck 
{
    double miles;
    public spd_2(PriorityQueue<Warehouse> manifest, Clock clock)
    {
        super(manifest, clock);
        this.speed = 2;
        this.capacity = 4;
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
