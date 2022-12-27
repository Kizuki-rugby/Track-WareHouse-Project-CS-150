import java.awt.*;
/**
 * class description 
 * 
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
class spd_1 extends Truck{
    double miles;
    public spd_1(PriorityQueue<Warehouse> manifest, Clock clock){
        super(manifest, clock);
        this.speed = 1;
        this.capacity = 5;
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
