package ma.enset.bddc;

import java.util.Random;

public class GAUtils {
    public static final int STRING_SIZE=7;
    public static final int POPULATION_SIZE=20;
    public static final double MUTATION_PROP=0.5;
    public static final int MAX_ITERATIONS=10000;

    public static final String TARGET_STRING = "Bonjour";


    public static char generateRandomCharacter() {
        int randomAscii = new Random().nextInt(26) + 97;  // Generate a random ASCII value between 97 ('a') and 122 ('z')
        return (char) randomAscii;
    }

    public static void replaceCar(Individual i,  char c  ,int pos) {

        char[] stringChars = i.getString().toCharArray();
        stringChars[pos] = GAUtils.generateRandomCharacter();
        i.setstring(String.valueOf(stringChars));

    }

    public static String mutateIndividual(String individual) {
        StringBuilder mutatedIndividual = new StringBuilder(individual);
        Random random = new Random();

        for (int i = 0; i < individual.length(); i++) {
            if (random.nextDouble() <= GAUtils.MUTATION_PROP) {
                char newCharacter = GAUtils.generateRandomCharacter();
                mutatedIndividual.setCharAt(i, newCharacter);
            }
        }

        return mutatedIndividual.toString();
    }

}
