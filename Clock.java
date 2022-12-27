/**
 * timer class that keep track of time using schedule. 
 * and keep track of data where trucks are each hour. 
 * boolean value will tell when the delivery is done. 
 *
 * @Kizuki Koyasu
 * @Ver.1
 */
public class Clock implements Schedule 
{
    static int hour;
    boolean done;
    Queue<Truck> truck;
    Queue<Warehouse> warehouse;
    DynamicMapCntrl dmc;
    Report report = new Report(truck);
    public Clock(Queue<Truck> truck, Queue<Warehouse> warehouse, DynamicMapCntrl dmc){
        hour = 0;
        done = false;
        this.truck = truck;
        this.warehouse = warehouse;
        this.dmc = dmc;
    }
    // Called each hour, allowing the object to perform an action.
    public void action(){
        start();
    }
    // Will store the object’s current information into a log file.
    //@return // log status for next part of project.
    public int log_status(){
        return 0;
    }
    //increase the timer by an hour. 
    //@return number of hours that has passed. 
    public int incr(){
        hour++;
        return hour;
    }

    /**
     * called at the start of model run. 
     * This method will call other appropriate methods to move 
     * trucks and load/unload shipments that needs to be delievered. 
     * Once all the shipments are being delivered, done variable 
     * becomes true and stop running.
     */
    
    public void start(){
        int counter = 0; // counter for how many trucks are done delivering 
        while(! done){
            log_status(); // log sttaus for filing data.
            for(int i = 0; i < truck.size(); i++){
                try{
                    truck.get(i).move(); // moves each truck 
                    dmc.refresh(); // refresh the dynamic map 
                    Thread.sleep(30); // space out the running time.
                    if(truck.get(i).manifest.size() == 0){
                        counter++; // when one truck is done delivering.
                    }
                    if(counter == truck.size()){ // situation when all trucks are done delivering. 
                        done = true;
                    }
                    report.output(truck);
                }catch(InterruptedException err) {
                    System.out.println(err);
                }
                incr(); // increase by an hour. 
            }
        }
    }
}

