package ma.enset.bddc;

import java.util.*;

public class GenticAlgorithm {
    private Individual[] population=new Individual[GAUtils.POPULATION_SIZE];
    private Individual individual1;
    public Individual individual2;
    public void initialize(){
        for (int i=0;i<GAUtils.POPULATION_SIZE;i++) {
            population[i]=new Individual();
            population[i].calculateFitness();
        }
    }

    public void crossover(){
        individual1=new Individual(population[0].getString());
        individual2=new Individual(population[1].getString());

        Random random=new Random();
        int crossPoint=random.nextInt(GAUtils.STRING_SIZE-1);
        crossPoint++;
        for (int i = 0; i <crossPoint ; i++) {

         GAUtils.replaceCar(individual1 , population[1].getString().charAt(i),i );
         GAUtils.replaceCar(individual2,population[0].getString().charAt(i), i );
        }


     //   System.out.println("crossover point "+crossPoint);
      //  System.out.println("Individual 1 "+Arrays.toString(individual1.getString()));
       // System.out.println("Individual 2 "+Arrays.toString(individual2.getString()));
    }
    public void showPopulation(){
        for (Individual individual:population) {
            System.out.println(individual.getString() +" = "+ individual.getFitness());
        }
    }
    public void sortPopulation(){
        Arrays.sort(population, Comparator.reverseOrder());
    }




    public void mutation(){
        Random random=new Random();
        // individual1
        GAUtils.mutateIndividual(individual1.getString());
        // individual2
        GAUtils.mutateIndividual(individual2.getString());
       // System.out.println("Après mutation ");
       // System.out.println("Individual 1 "+Arrays.toString(individual1.getString()));
        //System.out.println("Individual 2 "+Arrays.toString(individual2.getString()));
        individual1.calculateFitness();
        individual2.calculateFitness();
        population[GAUtils.POPULATION_SIZE-2]=individual1;
        population[GAUtils.POPULATION_SIZE-1]=individual2;
    }
    public int getBestFintness(){
        return population[0].getFitness();
    }
}
