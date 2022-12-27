import java.util.Scanner;
import java.io.File;

/**
 * This class intakes a file that has written all needed information 
 * to determine the number of trucks, warehouses, and so on. 
 * Which will be passed to other classes. There will be 4 different 
 * kinds of configurations, which will be tested. 
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class Configuration
{    
    int warehouseNum, truckNum, shipmentNum;
    public Configuration()
    {    
    }
    // the simulation takes configuration from a file. 
    // maybe read 4 differents kind of file to complete the assigment 
    public void fileIntake(String configName){
        File file = new File(configName);// choose which config file to use 
        try{
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                warehouseNum = s.nextInt(); // warehouse number
                s.next();//skip the comments 
                truckNum = s.nextInt(); // truck number 
                s.next();// skip the comments 
                shipmentNum = s.nextInt(); // shipment number 
                s.next(); // skip the comments 
            }
        }catch(Exception e){
            System.err.println("An error was generated" + e );
        }
    }

    /**
     * @return the number of warehouses that is identified by config reader
     */
    public int getWarehouseNum(){
        return warehouseNum;
    }

    /**
     * @return the number of trucks that is identified by config reader
     */
    public int getTruckNum(){
        return truckNum;
    }

    /**
     * @return the number of shipments that is identified by config reader
     */
    public int getShipmentNum(){
        return shipmentNum;
    }

}
