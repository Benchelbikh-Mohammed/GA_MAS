package ma.enset.bddc;

import java.util.Arrays;
import java.util.Random;

public class Individual implements Comparable {
    private String string =new String(new char[GAUtils.STRING_SIZE]);
    private int fitness;




    public Individual() {
        for (int i=0;i<GAUtils.STRING_SIZE;i++) {
            GAUtils.replaceCar(this, GAUtils.generateRandomCharacter() ,i);
        }
    }

    public Individual(String string) {
        this.string = new String(string);
    }

    public void calculateFitness() {
        int fitness = 0;
        for (int i = 0; i < GAUtils.STRING_SIZE; i++) {
            if (string.charAt(i) == GAUtils.TARGET_STRING.charAt(i)) {
                fitness++;
            }
        }
        this.fitness = fitness;
    }

    public int getFitness() {
        return fitness;
    }

    public String getString() {
        return string;
    }

    public void setstring(String string) {
        this.string = string;
    }

    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o;
        if (this.fitness>individual.fitness){
            return  1;
        }else if(this.fitness< individual.fitness){
            return -1;
        }else{
            return 0;
        }
    }
}
