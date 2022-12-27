import java.io.PrintStream;

/**
 * 
 * This class will export the log to CSV file. 
 * Which will make it easier to make a graph and analyze 
 * the data output. 
 * 
 * @author Kizuki Koyasu 
 * @version Ver.1
 */

public class Report
{
    static PrintStream ps;
    public Queue<Truck> truck;
    int truckCounter;
    int manifestDoneCounter;
    int totalNum;
    /**
     * Constructor for objects of class Report
     */
    public Report(Queue<Truck> truck)
    {
        truckCounter = 0;
        manifestDoneCounter = 0;
        try{
            ps = new PrintStream("CS150_Project2_Part3.csv");
        }catch(Exception e){
            System.err.println("Oops!" + e);
        }
    }

    public void header(Queue<Truck> truck){
        ps.print("Hour:,total number of Shipment:, Total Miles Driven: ,");
        for(int i = 0; i < truck.size(); i++){
            ps.print("Truck " + i + "'s coordinates ," );
        }
        ps.println("");
    }

    /**
     * this method will be used in later part of the project.
     * this is needed to record the data of truck's coordinate.
     */
    public  void output(Queue<Truck> truck){
        truckCounter =1;
        // for(int i = 0; i < truck.size(); i++){
        // //ps.print("Truck " + truckCounter + " : ("+ truck.get(i).getX() + "," + truck.get(i).getY() + ")");
        // if(truck.get(i).manifest.size() == 0){
        // ps.print("Delivery is Completed");
        // }
        // ps.println("");
        // truckCounter++;
        // }
        for(int i = 0; i < truck.size(); i++){
            totalNum +=  truck.get(i).manifestDoneCounter; 
        }
        ps.print( Clock.hour + "," + totalNum + "," + Truck.miles + ",");
        for(int i = 0; i < truck.size(); i++){
            ps.print("(" + truck.get(i).getX() + ":" + truck.get(i).getY() + "),");
        }
        ps.println("");
    }
}
