import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Random;

/**
 * The class has all methods that truck needs such as load, unload, wait, 
 * move etc. The constructor will be passed with information that determines 
 * characteristics of each truck. 
 * Each truck will be randomly generated at the start of test.
 * 
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class Truck implements Render, Comparable {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    Stack stack = new Stack();
    double xpos, ypos, size; 
    int speed;
    int capacity;
    static double miles;
    boolean done;
    int manifestDoneCounter;
    Queue<Warehouse> manifest;
    // LinkedList<Warehouse> pickUpList;
    // LinkedList<Warehouse> dropoffList;
    //Manifest manifest = new Manifest();
    //Warehouse warehouse;
    // it would take x-coordinate, y-coordinate, size, possibly manifest?
    //or I could make 5 different classes to differentiate speed, loadNum
    public Truck(PriorityQueue<Warehouse> manifest, Clock clock){        
        Random random = new Random();
        xpos = random.nextInt(381) + 10;
        ypos = random.nextInt(231) + 10;
        size = 10; 
        done = false;
        this.manifestDoneCounter = manifestDoneCounter;
    }

    // movement of truck

    /**
     * 
     * each truck will go to destination of warehouses that is 
     * assigned by manifest. 
     * it will calculate the distance will will later be used for logging data analysis.
     * Each truck will move as specified speed which is randlmoly decided 
     * by random function in other class.
     * When the truck location is at the 0, it will lose one manifest and unload its
     * shipment.
     */
    public void move() {
        if(manifest.size() > 0){
            double xposDist = this.manifest.get(0).getX() - xpos;
            double yposDist = this.manifest.get(0).getY() - ypos;
            //double dist = Math.sqrt((xposNext - xpos)*(xposNext - xpos) + (yposNext - ypos)*(yposNext - ypos));
            double distance = Math.sqrt(Math.pow((xposDist), 2)+ Math.pow((xposDist),2));
            double theta = Math.atan2(yposDist,xposDist);
            this.miles += distance;
            if(distance > speed * 2){
                xpos += Math.cos(theta) * speed * 2;
                ypos += Math.sin(theta) * speed * 2;
            }else if(this.manifest.get(0)== null){
                xpos = xpos;
                ypos = ypos;
            }else{
                xpos = this.manifest.get(0).getX();
                ypos = this.manifest.get(0).getY();
                manifest.remove(0);
                manifestDoneCounter++;
                //manifest.peek().unloading();
                //warehouse.unloading();
            }
        }
    }

    // draws a truck on a dynamic map 
    public void draw(Graphics g) {
        try{
            Thread.sleep(10);
            Graphics2D graphicsObj = (Graphics2D) g;
            Rectangle rect = new Rectangle((int)xpos, (int)ypos, (int)size, (int)size);
            Color binColor1 = new Color(0, 255, 0);
            graphicsObj.setColor(binColor1);
            graphicsObj.fill(rect);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    } 
    // @Return returns to miles that truck has driven. 
    public double getMiles(){
        return miles;
    }
    // Return the value of x-coordinate.
    public double getX(){
        return xpos;
    }
    //@Return the value of y-coordinate.
    public double getY(){
        return ypos;
    }
    //@Return true if the delivery is done. 
    // method to check when the delivery is done.
    public boolean done(){
        // if(manifest.size() == 0) done = true;
        // return done;
        return false;
    }
    // @return true if truck is done delivering, if not it returns false
    public boolean empty(){
        return stack.empty();
    }
    // @return to see which warehouse to prioritize. 
    // TODO: probably use distance formula or some sort to see which one is closer
    public int compareTo(Object item){
        return 0;
    }
    // get manifest using shipment objects. 
    public void getManifest(Shipment shipment){
        pq.add(shipment.getCount());
    }

}
