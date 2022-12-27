// import java.util.Random;

// /**
 // * Write a description of class Manifest here.
 // *
 // * @author Kizuki Koyasu
 // * @version Ver.1
 // */
// public class Manifest extends Warehouse{
    // PriorityQueue<Manifest> manifest = new PriorityQueue<Manifest>();
    // int randVal;
    // double xpos, ypos;
    // Random random;
    // Warehouse[] warehouse;
    // Truck[] truck;
    // Shipment[] shipment;
    // Configuration config = new Configuration();
    // static int id = -1;
    // int count = 0;
    // public Manifest(Warehouse[] warehouse, Shipment[] shipment, Truck[] truck)
    // {
        // random = new Random();
        // this.warehouse = warehouse;
        // this.shipment = shipment;
        // this.truck = truck;
        // count = idGen(); 
        // this.xpos = xpos;
        // this.ypos = ypos;
    // }

    // public void manifestCreater(double[] xPos, double[] yPos)
    // {
        // config.fileIntake("hey");
        // for(int i = 0; i <config.getShipmentNum(); i++){
            // randVal = random.nextInt(config.getWarehouseNum());
            // warehouse[randVal].loading(shipment[i]);
            // xpos = xPos[randVal];
            // ypos = yPos[randVal];
        // }
    // }

    // public void manifestTruckCreater(double[] xPos, double[] yPos){
        // config.fileIntake();
        // for(int i = 0; i < config.getShipmentNum(); i++){
            // randVal = random.nextInt(config.getTruckNum());
            // truck[randVal].getManifest(shipment[i]);
        // }
    // }

    // public int idGen(){
        // id++;
        // return id;
    // }

    // public int size(){
        // return 0;
    // }
// }
