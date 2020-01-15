package com.montyhall.app.monetized;

import java.util.Random;

public class App {
    private final static int NUMBER_OF_ROUNDS = 300000;

    public static void main(String[] args) {
        int winBySwitching = 0;
        int winByStaying = 0;
        Random rndGen = new Random();
        Box[] boxSet = getBoxes();

        for (int plays = 0; plays < NUMBER_OF_ROUNDS; plays++) {

            resetBoxSet(boxSet);
            boxSet[rndGen.nextInt(3)].setIsFull(true);

            int choice = getChoice(rndGen, boxSet);
            int shown = getShown(rndGen, boxSet);

            winByStaying += (!boxSet[choice].isFull()) ? 1 : 0;
            winBySwitching += boxSet[3 - choice - shown].isFull() ? 0 : 1;
        }

        publishResults(winBySwitching, winByStaying);
    }

    private static void publishResults(double winBySwitching, double winByStaying) {
        System.out.printf("Out of %d rounds that we simulated the game,\n", NUMBER_OF_ROUNDS);
        System.out.printf("\t- Switching would have made you win %.3f percent of games!\n",
                winBySwitching /NUMBER_OF_ROUNDS*100);
        System.out.printf("\t- While staying would have made you win the other %.3f percent of games!\n",
                winByStaying /NUMBER_OF_ROUNDS*100);
    }

    private static int getChoice(Random gen, Box[] boxSet) {
        int choice = gen.nextInt(3);
        boxSet[choice].setIsChosen(true);
        return choice;
    }

    private static int getShown(Random gen, Box[] boxSet) {
        int shown;
        do {
            shown = gen.nextInt(3);
        } while (boxSet[shown].isFull() || boxSet[shown].isChosen());
        return shown;
    }

    private static void resetBoxSet(Box[] boxSet) {
        for (Box box : boxSet) {
            box.setIsFull(false);
            box.setIsChosen(false);
        }
    }

    private static Box[] getBoxes() {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        return new Box[]{box1, box2, box3};
    }
}
