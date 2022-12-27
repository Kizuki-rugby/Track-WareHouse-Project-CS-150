import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

/**
 * The class for Warehouse, which takes care of dock control, loading, unloading, etc. 
 * The constructors will be used to determine the each warehouse's unique 
 * characteristics(DockNum, how many shipments they have, etc). 
 * Like truck,  each warehouse is randomly generated at the start of the test.
 *
 * @author Kizuki Koyasu
 * @version Ver.1
 */
public class Warehouse implements Render, Schedule 
{
    Random random;    
    double xpos, ypos, size;
    int dockNum;
    Queue q = new Queue();
    Queue<Shipment> ship = new Queue<Shipment>();
    Shipment[] shipment;
    static int count;
    public Warehouse(){

    }

    /**
     * Constructor for objects of class Warehouse.
     * The location of warehouses are randomly located each time 
     * warehouse objects are created. Moreover, the dock number is 
     * randomly generated as well. 
     */
    public Warehouse(Queue<Truck> queue)
    {
        random = new Random();
        xpos = random.nextInt(381) + 10;
        ypos = random.nextInt(231) + 10;
        size = 15;
        dockNum = random.nextInt(3)+1;
        this.count=count;
        // xPos[count] = xpos;
        // yPos[count] = ypos;
    }
    // Called each hour, allowing the object to perform an action.
    public void action(){
        unloading();
    }
    // Will store the object’s current information into a log file.
    public int log_status(){
        return 0;
    }
    // This will draw the object on the canvas.
    //@param graphics
    public void draw(Graphics g){
        Graphics2D graphicsObj = (Graphics2D) g;
        Rectangle rect = new Rectangle((int)xpos, (int)ypos, (int)size, (int)size);
        Color binColor1 = new Color(0, 0, 0);
        graphicsObj.setColor(binColor1);
        graphicsObj.fill(rect);
    }
    // get x coordinate of warehouse 
    //@return the x-coordinate of warehouse.
    public double getX(){
        return xpos;
    }
    // get y-coordinate of warehouse 
    // @return the value of the y-coordinate of warehouse.
    public double getY(){
        return ypos;
    }
    // load units from warehouse to trucks 
    // @param queue of truck that is being added. 
    public void loading(Truck truck){
        q.add(truck);
    }
    //add shipment to warehouse.
    // @param shipment that is added to the warehouse. 
    public void addShipment(Shipment shipment){
        ship.add(shipment);
    }

    /**
     * method to get the value of shipment's x-coordinate
     * @return the value of shipment's x-coordinate
     * @param the value of x-coordinate.
     */
    public double getShipmentX(Shipment shipment){
        return shipment.getX();
    }

    /**
     * method to get the value of shipment's y-coordinate
     * @return the value of shipment's y-coordinate
     * @param the value of y-coordinate.
     */
    public double getShipmentY(Shipment shipment){
        return shipment.getY();
    }

    /**
     * this method is to compare if the docknum is not being filled 
     * and if so it will let truck to unload its shipments that it has. 
     */
    public void unloading(){
        if(q.size() > 1){
            int i = 0;
            int j = 0;
            if(q.size() > dockNum){
                while(i < dockNum){
                    Truck truck = (Truck) q.remove(0);
                    i++;
                }
            }else{
                while(j < q.size()){
                    Truck truck = (Truck)q.remove(0);
                    j++;
                }
            }
        }else if (q.size() == 1){
            Truck truck = (Truck)q.remove(0);
        }
    }
}
