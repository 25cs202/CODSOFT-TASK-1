import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalwon = 0;
        int totalscore = 0;
        int roundnumber = 1;
        boolean again = true;

        System.out.println("          WELCOME TO THE CODSOFT NUMBERGUESSING GAME             ");
        System.out.print(" Enter ur name: ");
        String name = scanner.nextLine();
        System.out.println("\nCODSOFT WELCOMES U : " + "MR." + name);
        System.out.println("\nGUESS THE NUMBER: ");

        while (again) {
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
                    totalwon++;
                
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
            System.out.println("Rounds Won: " + totalwon);
            System.out.println("Total Score: " + totalscore + " points");
            System.out.println("      END    ");

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            
            if (response.startsWith("y")) {
                roundnumber++;
            } else {
                again = false;
            }
        }

        System.out.println("\n ur Final Score: " + totalscore + " | Rounds Won: " + totalwon);
        System.out.println("MR." + name + "  Thank You for playing CODSOFT NUMBERGUESSING GAME");
        System.out.println("CODSOFT always welcomes u");
        scanner.close();
    }
}
