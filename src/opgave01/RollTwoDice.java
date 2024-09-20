package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int totalSum = 0;
    private static int sameRoll = 0;
    private static int highestTotal = 0;
    private static int[] numbersOnDice = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længe man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul et sæt terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.println("Du rullede: " + faces[0] + " og " + faces[1]);
            System.out.println();

            updateStatistics(faces);

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] diceRolled = new int[2];
        int dice01 = 0;
        int dice02 = 0;
        for (int index = 0; index < diceRolled.length; index++)
            dice01 = (int) (Math.random() * 6 + 1);
        dice02 = (int) (Math.random() * 6 + 1);
        return new int[]{dice01, dice02};
    }


    private static void updateStatistics(int[] faces) {
        totalSum += faces[0] + faces[1];
        for (int index = 1; index <= 6; index++) {
            if (faces[0] == index) {
                numbersOnDice[index - 1]++;
            }
            if (faces[1] == index) {
                numbersOnDice[index - 1]++;
            }
        }
        rollCount++;
        if (faces[0] == faces[1]) {
            sameRoll++;
        }
        if (highestTotal < faces[0] + faces[1]) {
            highestTotal = faces[0] + faces[1];
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum af rul:", totalSum);
        System.out.printf("%17s %4d\n", "Samme rul:", sameRoll);
        System.out.printf("%17s %4d\n", "Højeste rul:", highestTotal);
        for (int index = 0; index < numbersOnDice.length; index++) {
            System.out.println("Antal " + (index + 1) + "'ere: " + numbersOnDice[index]);
        }
    }
}
