import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalroundswon = 0;
        int totalscore = 0;
        int roundnumber = 1;
        boolean playAgain = true;

        
        System.out.println(" WELCOME TO THE GAME ");
        System.out.println("GUESS THE NUMBER: ");

        while (playAgain) {
            int min = 1;
            int max = 100;
            int targetnumber = random.nextInt(max - min + 1) + min;
            int maxattempts = 8;
            int attemptstaken = 0;
            boolean won = false;

            System.out.println(" Round " + roundnumber );
            System.out.println("U need to chose a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxattempts + " attempts to guess if u dont guess u lose");

            while (attemptstaken < maxattempts) {
                System.out.print("\nEnter number you guessed: ");
                
                // Validate input to ensure it is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println(" Please enter a valid number.");
                    System.out.print("Enter number you guessed: ");
                    scanner.next();
                }
                
                int userGuess = scanner.nextInt();
                attemptstaken++;

                if (userGuess == targetnumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attemptstaken + " attempts.");
                    won = true;
                    totalroundswon++;
                
                    int roundScore = (maxattempts - attemptstaken + 1) * 10;
                    totalscore += roundScore;
                    System.out.println("You earned " + roundScore + " points in this round.");
                    break;
                } else if (userGuess < targetnumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                int remainingattempts = maxattempts - attemptstaken;
                if (remainingattempts > 0) {
                    System.out.println("Remaining attempts: " + remainingattempts);
                }
            }

            if (!won) {
                System.out.println("\nGame Over for this round! You've run out of attempts.");
                System.out.println("The correct number was: " + targetnumber);
            }

            // Display current scoreboard
            System.out.println("\n  CURRENT SCOREBOARD ");
            System.out.println("Rounds Won: " + totalroundswon);
            System.out.println("Total Score: " + totalscore + " points");
            System.out.println("      END    ");

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            
            if (response.startsWith("y")) {
                roundnumber++;
            } else {
                playAgain = false;
            }
        }

        System.out.println("\nThank you for playing! Final Score: " + totalscore + " | Rounds Won: " + totalroundswon);
        scanner.close();
    }
}
