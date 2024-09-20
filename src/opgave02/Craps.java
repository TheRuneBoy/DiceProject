package opgave02;

import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        System.out.println("Velkommen til spillet Craps.");
        printRules();
        System.out.println();

        playCraps();

    }

    private static void printRules() {
        System.out.println("=================================================================================");
        System.out.println("Regler for Craps");
        System.out.println("Spilleren ruller 2 terninger. det første rul kaldes 'come out roll'.");
        System.out.println("Hvis spilleren slår 7 eller 11 i 'come out roll', vinder spilleren med det samme.");
        System.out.println("Ender 'come out roll' derimod på 2, 3 eller 12, taber spilleren med det samme.");
        System.out.println("Alle andre slag bliver i stedet gemt som spillerens 'point'.");
        System.out.println("Spilleren slår defter igen, og fortsætter indtil de rammer deres 'point' eller 7.");
        System.out.println("Hvis spilleren rammer deres 'point', vinder de. Hvis de rammer 7, taber de.");
        System.out.println("Held og lykke!");
        System.out.println("==================================================================================");
    }

    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Spil Craps? ('ja/nej') ");
        String answer = scanner.nextLine();
        int result = 0;
        if (answer.equals("ja")) {
            int[] roll = rollDice();
            result = roll[0] + roll[1];
            System.out.println("Du rullede: " + result);
            if (result == 7 || result == 11) {
                System.out.println("Tillykke! Du vandt!");
            } else if (result == 2 || result == 3 || result == 12) {
                System.out.println("Desværre! Du har tabt. Bedre held næste gang!");
            } else {System.out.println("Spillet fortsætter. Dit mål er nu: " + result);
            int point = result;
            rollForPoint(point);
            if (rollForPoint(point)) {
                System.out.println("Du rullede: " + point);
                System.out.println("Tillykke! Du vandt!");
            } else {
                System.out.println("Du rullede: " + 7);
                System.out.println("Desværre! Du har tabt. Bedre held næste gang!");
            }
            }
        }

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

    private static boolean rollForPoint(int point) {
        int[] roll = rollDice();
        int result = roll[0] + roll[1];
        while (point != result) {
            if (result == 7) {
                return false;
            }
            roll = rollDice();
            result = roll[0] + roll[1];
        }
        return true;
    }
}