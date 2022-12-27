import java.awt.Dimension;
import java.util.Random;

/**
 * Main class that run whole test.
 * This will be tested many times with 4 different congigurations 
 * and 10 different seeds. Moreover, it needs to be recoreded and analyzed 
 * with graphs. 
 * 
 * @author Kizuki Koyasu 
 * @Version Ver.1 
 */

public class ModelRunner {
    public ModelRunner(){
    }

    /**
     * @param name of configuration file.
     * (config.txt, config2.txt, config3.txt, config4.txt);
     * this will run 10 times with different kinds of seeds 
     * and 4 different kinds of configurations. 
     * 
     */

    public static void runner(String configName) {
        Random random = new Random();
        Configuration config = new Configuration();
        Shipment[] shipment;
        //Truck[] truck = new Truck[10];
        spd_5 truck5;
        spd_4 truck4;
        spd_3 truck3;
        spd_2 truck2;
        spd_1 truck1;
        Warehouse warehouse;
        int spd4Num, spd3Num, spd2Num, spd1Num;
        Queue<Shipment> shipmentItem;
        config.fileIntake(configName);
        Queue<Truck> truck = new Queue();
        Queue<Warehouse> dest = new Queue();
        PriorityQueue<Warehouse> manifest = new PriorityQueue();

        shipment = new Shipment[config.getShipmentNum()];

        DynamicMap dm = new DynamicMap();
        DynamicMapCntrl dmc = new DynamicMapCntrl("Dynamic Map");

        Clock clock = new Clock(truck, dest, dmc);
        boolean done = false;
        Report report = new Report(truck);
        
        int spd5Num = random.nextInt(3)+1;
        for(int i = 0; i < spd5Num; i++){
            truck5 = new spd_5(manifest, clock);
            truck.add(truck5);
            dmc.add(truck5);
        }
        if(config.getTruckNum() - spd5Num > 0){
            spd4Num = random.nextInt(3)+1;
            for(int i = 0; i < spd4Num; i++){
                truck4 = new spd_4(manifest, clock);
                truck.add(truck4);
                dmc.add(truck4);
            }
            if(config.getTruckNum() - spd5Num - spd4Num > 0){
                spd3Num = random.nextInt(3)+1;
                for(int i = 0; i < spd3Num; i++){
                    truck3 = new spd_3(manifest, clock);
                    truck.add(truck3);
                    dmc.add(truck3);
                }
                if(config.getTruckNum() - spd5Num - spd4Num - spd3Num > 0){
                    spd2Num = random.nextInt(config.getTruckNum() - spd5Num - spd4Num - spd3Num)+1;
                    for(int i = 0; i < spd2Num; i++){
                        truck2 = new spd_2(manifest,clock);
                        truck.add(truck2);
                        dmc.add(truck2);
                    }
                    if(config.getTruckNum() - spd5Num - spd4Num - spd3Num - spd2Num > 0 && config.getTruckNum() - spd5Num - spd4Num - spd3Num - spd2Num <=6){
                        spd1Num = config.getTruckNum() - spd5Num - spd4Num - spd3Num - spd2Num;
                        for(int i = 0; i <  spd1Num; i++){
                            truck1 = new spd_1(manifest, clock);
                            truck.add(truck1);
                            dmc.add(truck1);
                        }
                    }
                }
            }
        }
        dmc.refresh();
        // //warehouse location holder
        // double[] xPos = new double[5];
        // double[] yPos = new double[5];

        // warehouse creation 
        for(int i = 0; i < config.getWarehouseNum(); i++){
            warehouse = new Warehouse(truck);
            dest.add(warehouse);
            dmc.add(warehouse);
            dmc.refresh();
        }

        //shipment creation 
        for(int i = 0; i < config.getShipmentNum(); i++){
            int rand = random.nextInt(5);
            shipment[i] = new Shipment();
        }

        // //shipment location getter
        // for(int i = 0; i < config.getShipmentNum(); i++){
        // shipment[i].getX();
        // shipment[i].getY();
        // }

        // // manifest creation
        /**
         * 

        for(int i = 0; i < truck.size(); i++){
        truck.get(i).manifest = new Queue();
        for(int j = 0; j < config.getShipmentNum(); j++){
        int random1 = random.nextInt(dest.size());
        int random2 = random.nextInt(10);
        truck.get(i).manifest.add(dest.get(random1));
        }
        }
         */

        for(int i = 0; i < truck.size(); i++){
            truck.get(i).manifest = new Queue();
            for(int j = 0; j < config.getShipmentNum(); j++){
                int random1 = random.nextInt(dest.size());
                truck.get(i).manifest.add(dest.get(random1));
            }
        }

        // Manifest manifest = new Manifest(warehouse, shipment, truck);
        // manifest.manifestCreater(xPos, yPos);
        // manifest.manifestTruckCreater(xPos, yPos);

        report.header(truck);
        clock.start();
        dmc.refresh();
        dmc.clear();
    }
}


//}
