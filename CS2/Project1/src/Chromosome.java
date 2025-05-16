import java.util.ArrayList;
import java.util.Random;

/*
 * Class of the Chromosome
 * @author Trevor Hollack
 */
public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {

    /*
     * Default Constructor for the Chromosome
     */
    public Chromosome() {

    }

    /*
     * Constructor that adds a copy(not a deep copy) of the items passed in to the
     * Chromosome. Uses a
     * random number to decide if each item's included field is true or false
     * 
     * @param items
     */
    public Chromosome(ArrayList<Item> items) {
        super(items);
        Random rng = new Random();
        for (Item item : this) {
            item.setIncluded(rng.nextBoolean());
        }
    }

    /*
     * Constructor that creates and returns a new child chromosome by performing the
     * crossover operation on this chromosome and the other one that is passed in
     * 
     * @param other
     * 
     * @return childCHromosome
     */
    public Chromosome crossover(Chromosome other) {
        Chromosome childChromosome = new Chromosome(new ArrayList<>());
        Random rng = new Random();
        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            boolean useChromosome = rng.nextBoolean();
            Item newItem = useChromosome ? new Item(this.get(i)) : new Item(other.get(i));
            childChromosome.add(newItem);
        }
        return childChromosome;
    }

    /*
     * Performs the mutation operation on this chromosome (for each item, use a
     * random number to decide whether to flip the included field's value)
     */
    public void mutate() {
        Random rng = new Random();
        for (Item item : this) {
            boolean switchIncluded = rng.nextBoolean();
            if (switchIncluded) {
                item.setIncluded(!item.isIncluded());
            }
        }
    }

    /*
     * Returns the fitness of this chromosome. If the sum of the weights > 10,
     * fitness is 0. Otherwise, fitness is = sum of value
     * 
     * @return 0 if the sum of the weights is greater than 10
     * 
     * @return sumValue if the total weight is less than 10
     */
    public int getFitness() {
        double sumWeight = 0;
        int sumValue = 0;
        for (Item item : this) {
            if (item.isIncluded()) {
                sumWeight += item.getWeight();
                sumValue += item.getValue();
            }
        }
        if (sumWeight > 10) {
            return 0;
        } else {
            return sumValue;
        }

    }

    /*
     * Returns -1 if this chromosome's fitness is greater than the other's, 1 if
     * this is less fit than the other's, and 0 if they are the same
     * 
     * @return -1 if this Chromosome is more fit than the other
     * 
     * @return 1 if this Chromosome is less fit than the other
     * 
     * @return 0 if both Chromosomes have the same fitness
     */
    @Override
    public int compareTo(Chromosome other) {
        int thisFitness = this.getFitness();
        int otherFitness = other.getFitness();
        if (thisFitness > otherFitness) {
            return -1;
        } else if (thisFitness < otherFitness) {
            return 1;
        } else {
            return 0;
        }

    }

    /*
     * Displays the name, weight, and value of all items in this chromosome whose
     * included value is true, followed by the fitness
     * 
     * @return output as <name> (<weight> lbs, $<value>, Fitness: <fitness>
     */
    @Override
    public String toString() {
        String output = "";
        for (Item item : this) {
            if (item.isIncluded()) {
                output += item.toString();
            }
        }
        output += ", Fitness: " + getFitness();
        return output;
    }

}
