import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

/*
 * Class of the Driver
 * @author Trevor Hollack
 * 
 * The optimal percentage of deliveries by drone is:
 */
public class Driver {

    /*
     * Number of drones to be simulated
     */
    public static double droneCount;

    /*
     * Number of trucks to be simulated
     */
    public static int truckCount;

    /*
     * Value to track the total trip time of the trucks
     */
    public static double totalTruckTripTime = 0;

    /*
     * Value to rack the total trucks that have completed the trip
     */
    public static int totalTrucksCompleted = 0;

    /*
     * Method that calculates how many drones are needed
     * 
     * @param percentByDrone
     * 
     * @return droneCount
     */
    public static double droneAmount(double percentByDrone) {
        double droneCount = (1500 * percentByDrone);

        return droneCount;
    }

    /*
     * Method that calculates how many trucks are needed
     * 
     * @param percentByDrone
     * 
     * @return truckCount
     */
    public static int truckAmount(double percentByDrone) {
        double percentByTruck = 1 - percentByDrone;
        double truckCountD = ((1500 * percentByTruck) / 10);
        int truckCount = (int) Math.round(truckCountD);

        return truckCount;
    }

    /*
     * Method that calculates the total flight time of the drones
     * 
     * @param droneCount
     * 
     * @return totalTime
     */
    public static double droneDelivery(double droneCount) {
        int droneTrip = 60;
        int interval = 3;
        double totalTime = droneTrip + (droneCount - 1) * interval;

        return totalTime;
    }

    /*
     * Method that reads the train_schedule file and store the information
     * 
     * @param fileName
     * 
     * @return schedule
     */
    public static List<String> trainSchedule(String fileName) {
        List<String> schedule = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split(", ");
                int start = Integer.parseInt(line[0]);
                int duration = Integer.parseInt(line[1]);
                int end = start + duration;
                schedule.add(start + "-" + end);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    /*
     * Method to handle different events
     * 
     * @param event
     * 
     * @param eq
     * 
     * @param schedule
     */
    public static void eventHandle(Event event, PriorityQueue<Event> eq, List<String> schedule) {
        switch (event.type) {
            /*
             * The case of the truck starting
             */
            case TRUCK_START:
                System.out.println(event.time + ": Truck #" + event.truckId + " begins its journey");
                double truckCrossTime = event.time + (3000 / 30);
                eq.offer(new Event(event.time, EventType.TRUCK_CROSS, event.truckId));
                break;
            /*
             * The case of the truck crossing
             */
            case TRUCK_CROSS:
                if (!trainBlocking(event.time, schedule)) {
                    double truckTripTime = event.time + (27000 / 30);
                    System.out.println(event.time + ": Truck#" + event.truckId + " crosses the tracks");
                    totalTruckTripTime += truckTripTime;
                    totalTrucksCompleted++;
                } else {
                    System.out.println(event.time + ": Truck #" + event.truckId + " waits at tracks");
                    double newTime = getNextTrainClearTime(event.time, schedule) + 1;
                    eq.offer(new Event(newTime, EventType.TRUCK_CROSS, event.truckId));
                }
                break;
            /*
             * The case of the train blocking the crossing
             */
            case TRAIN_BLOCK:
                System.out.println(event.time + " TRAIN BLOCKS CROSSING");
                double newTime = getNextTrainClearTime(event.time, schedule) + 1;
                eq.offer(new Event(newTime, EventType.TRAIN_NOT_BLOCK, event.truckId));
                break;
            /*
             * The case of the train not blocking the crossing
             */
            case TRAIN_NOT_BLOCK:
                System.out.println(event.time + " TRAIN HAS PASSED");
                for (int i = 0; i < truckCount; i++) {
                    eq.offer(new Event(event.time + (i * 1.0), EventType.TRUCK_START, i + 1));
                }
                break;
            default:
                break;
        }
    }

    /*
     * Method to detect if a train is at the corssing
     * 
     * @param time
     * 
     * @param schedule
     * 
     * @return true if the train is at the crossing during the method call
     * 
     * @return false if the train is not at the crossing
     */
    public static boolean trainBlocking(double time, List<String> scheudle) {
        for (String entry : scheudle) {
            String[] times = entry.split("-");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            if (time >= start && time <= end) {
                return true;
            }
        }
        return false;
    }

    /*
     * Method to detect when the train will leave the crossing
     * 
     * @param time
     * 
     * @param schedule
     * 
     * @return nextClearTime
     */
    public static double getNextTrainClearTime(double time, List<String> schedule) {
        double nextClearTime = Double.MAX_VALUE;
        for (String entry : schedule) {
            String[] times = entry.split("-");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            if (time <= start && start < nextClearTime) {
                nextClearTime = start;
            }
        }
        return nextClearTime;
    }

    public static void main(String[] args) throws Exception {
        /*
         * Get input on what percentage of drones are to be used, and calculate how many
         * drones and trucks that is
         */
        System.out.println();
        System.out.println("Enter the percentage of drones you would like to test:");
        Scanner scnr = new Scanner(System.in);
        double percentByDrone = (scnr.nextDouble() / 100);
        scnr.close();
        droneCount = droneAmount(percentByDrone);
        truckCount = truckAmount(percentByDrone);

        /*
         * Print how many drones and trucks are being simulated
         */
        System.out.println();
        System.out.println("With " + percentByDrone * 100 + "% drones and 1500 packages,");
        System.out.println("There will be:");
        System.out.println("- " + droneCount + " drones");
        System.out.println("- " + truckCount + " trucks");

        /*
         * Read and store train schedule
         */
        List<String> schedule = trainSchedule("train_schedule.txt");

        /*
         * Print train schedule
         */
        System.out.println();
        System.out.println("Train Schedule:");
        for (String entry : schedule) {
            System.out.println(entry);
        }
        System.out.println();

        /*
         * Create event queue and add truck start events
         */
        PriorityQueue<Event> eq = new PriorityQueue<>();
        for (int i = 0; i < truckCount; i++) {
            eq.offer(new Event(i * 15.0, EventType.TRUCK_START, i + 1));
        }

        /*
         * Main simulation
         */
        while (!eq.isEmpty()) {
            Event ce = eq.poll();
            switch (ce.type) {
                case TRUCK_START:
                case TRUCK_AT_CROSS:
                case TRUCK_CROSS:
                case TRUCK_END:
                    eventHandle(ce, eq, schedule);
                    break;
                case TRAIN_BLOCK:
                    System.out.println(ce.time + ": TRAIN BLOCKS CROSSING");
                    eventHandle(ce, eq, schedule);
                    break;
                case TRAIN_NOT_BLOCK:
                    System.out.println(ce.time + ": TRAIN HAS PASSED");
                    eventHandle(ce, eq, schedule);
                    break;
            }
        }

        /*
         * Calculate and print total time for trucks
         */
        System.out.println();
        System.out.println("Average truck trip time: " + (totalTruckTripTime / totalTrucksCompleted) + " minutes");
        System.out.println("Total truck trip time: " + totalTruckTripTime + " minutes");

        /*
         * Calculate and print total time for drones
         */
        System.out.println();
        double totalDroneTime = droneDelivery(droneCount);
        System.out.println("Drone Trip Time: 60 minutes");
        System.out.println("Drone Total Time: " + totalDroneTime);

        /*
         * Calcualte and print total time of both trucks and drones;
         */
        System.out.println();
        double totalTime = 0;
        if (totalDroneTime <= totalTruckTripTime) {
            totalTime = totalTruckTripTime;
        } else {
            totalTime = totalDroneTime;
        }
        System.out.println("Total time: " + totalTime + " minutes");

    }
}