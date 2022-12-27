import java.util.Random;

/**
 * Shipment class, that generates shipments. 
 * countructor will be passed with each shipment's 
 * unique characteristics. 
 * it will generate id for each shipment(unique code.)
 * 
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class Shipment extends Warehouse
{
    int capacity;
    static int id = -1;
    int count = 0; // for local count 
    int capa;
    double xpos, ypos;
    /**
     * Constructor for objects of class Shipment
     */
    public Shipment()
    {
        count = idGen();
        capacity = capaGen();
    }

    /**
     * generate an identification for each shipments.(start from 0 and increment by one each time).
     */
    public int idGen(){
        id++;
        return id;
    }

    /**
     * 
     * method to call capacity for each truck.
     * @return the value of unit that each Shipment holds.
     */
    public int capaGen(){
        Random random = new Random();
        capa = random.nextInt(6)+1;
        return capa;
    }

    /**
     * the method to get the count of shipment
     * @return the value of count variable.
     */
    public int getCount(){
        return count;
    }

    /**
     * the method to get the x-coordinate of a warehouse 
     * @return the value of x-coordinate.
     */
    public double getX(){
        return super.xpos;
    }

    /**
     * the method to get the y-coordinate of a shipment
     * @return the value of y-coordinate.
     */
    public double getY(Warehouse warehouse){
        return super.ypos;
    }

}
