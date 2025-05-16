import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

/*
 * Class of the Genetic Algorithm
 * @author Trevor Hollack
 */
public class GeneticAlgorithm {

    /*
     * Reads in a data file and creates and returns an ArrayList of Item objects,
     * parses the file to ensure that there is 3 components to each line: 1. string
     * for item name, 2. double for item weight, 3. int for item value
     * 
     * @param filename name of the file
     * 
     * @return items ArrayList
     */
    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        try (Scanner scnr = new Scanner(new File(filename))) {
            while (scnr.hasNextLine()) {
                String nextLine = scnr.nextLine().trim();
                String[] parts = nextLine.split(",\\s");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    double weight = Double.parseDouble(parts[1].trim());
                    int value = Integer.parseInt(parts[2].trim());
                    items.add(new Item(name, weight, value));
                }
            }
        }
        return items;
    }

    /*
     * Creates and returns an ArrayList of populationSize Chromosome objects that
     * each contain the items, with their included field randomly true or false
     * 
     * @param items the ArrayList of items
     * 
     * @param populationSize how many Chromosome objects to create
     * 
     * @return population ArrayList of Chromosome objects
     */
    public static ArrayList<Chromosome> intializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    }

    /*
     * Reads data about the items from file called items.txt and performs steps
     * described in Running the Genetic Algorithm
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        /*
         * Create set of 10 individuals to be initial population
         */
        ArrayList<Item> items = null;
        try {
            items = readData("more_items.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found ");
        }

        ArrayList<Chromosome> currentPopulation = intializePopulation(items, 10);

        /*
         * Loop 40 times (Original 20 times was giving too many instances of 0 fitness results)
         */
        for (int i = 0; i < 40; i++) {
            ArrayList<Chromosome> nextGeneration = new ArrayList<>();

            /*
             * Add each individual in the current population to next generation
             */
            for (Chromosome individual : currentPopulation) {
                nextGeneration.add(new Chromosome(individual));
            }

            /*
             * Randomly pair individuals and crossover to create child to add to next
             * generation
             */
            for (int j = 0; j < currentPopulation.size(); j += 2) {
                Chromosome parent1 = currentPopulation.get(j);
                Chromosome parent2 = currentPopulation.get(j + 1);
                nextGeneration.add(parent1.crossover(parent2));
            }

            /*
             * Randomly mutate 10% of individuals
             */
            int mutationCount = nextGeneration.size() / 10;
            Random rng = new Random();
            for (int j = 0; j < mutationCount; j++) {
                int index = rng.nextInt(nextGeneration.size());
                nextGeneration.get(index).mutate();
            }

            /*
             * Sort individuals according to fitness
             */
            Collections.sort(nextGeneration);

            /*
             * Clear out population and add in the top 10 of the new generation into the
             * population
             */
            currentPopulation.clear();
            for (int j = 0; j < 10; j++) {
                currentPopulation.add(nextGeneration.get(j));
            }
        }

        /*
         * Sort population and display most fit individual
         */
        Collections.sort(currentPopulation);
        System.out.println("Fittest individual: ");
        System.out.print(currentPopulation.get(0));
        System.out.println();
    }
}