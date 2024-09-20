package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int playerOnePoints = 0;
    private static int playerTwoPoints = 0;

    public static void main(String[] args) {
        playPigs();

    }

    private static void playPigs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vil du spille Pigs? ('ja/nej') ");
        String answer = scanner.nextLine();
        if (answer.equals("ja")) {
            System.out.println("Spillet begynder! Held og lykke!");
            while (playerOnePoints < 100 && playerTwoPoints < 100) {
                System.out.println("Spiller 1 starter.");
                System.out.println("Spiller 1 har: " + playerOnePoints);
                playRound01();
                if (playerOnePoints >= 100) {
                    System.out.println("Spillet er slut!");
                    System.out.println("Spiller 1 vinder!");
                    return;
                }
                System.out.println();

                System.out.println("Spiller 2 starter");
                System.out.println("Spiller 2 har: " + playerTwoPoints);
                playRound02();
                if (playerTwoPoints >= 100) {
                    System.out.println("Spillet er slut!");
                    System.out.println("Spiller 2 vinder!");
                    return;
                }
                System.out.println();
            }

        }
    }

    private static void playRound01() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int face = rollDie();
        int roundTotal = 0;
        System.out.println("Du rullede: " + face);
        if (face == 1) {
            System.out.println("Desværre! Du får ingen point i denne runde.");
            return;
        } else {
            roundTotal += face;
            System.out.println("Vil du stoppe eller fortsætte?: ");
            answer = scanner.nextLine();
        }
        while (!answer.equals("nej")) {
            face = rollDie();
            if (face == 1) {
                System.out.println("Du rullede: 1");
                System.out.println("Desværre! Du får ingen point i denne runde.");
                roundTotal += 0;
                return;
            } else {
                System.out.println("Du rullede: " + face);
                roundTotal += face;
                System.out.println("Du er nu på: " + roundTotal);
                System.out.println("Vil du fortsætte?");
                answer = scanner.nextLine();
            }
        }
        playerOnePoints += roundTotal;
    }

    private static void playRound02() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int face = rollDie();
        int roundTotal = 0;
        System.out.println("Du rullede: " + face);
        if (face == 1) {
            System.out.println("Desværre! Du får ingen point i denne runde.");
            return;
        } else {
            roundTotal += face;
            System.out.println("Vil du stoppe eller fortsætte?: ");
            answer = scanner.nextLine();
        }
        while (!answer.equals("nej")) {
            face = rollDie();
            if (face == 1) {
                System.out.println("Du rullede: 1");
                System.out.println("Desværre! Du får ingen point i denne runde.");
                roundTotal += 0;
                return;
            } else {
                System.out.println("Du rullede: " + face);
                roundTotal += face;
                System.out.println("Du er nu på: " + roundTotal);
                System.out.println("Vil du fortsætte?");
                answer = scanner.nextLine();
            }
        }
        playerTwoPoints += roundTotal;
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
}