
import java.util.*;
public class Number_Guessing_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        boolean play_Again = true;


        while (play_Again) {
            int no_guessed = rand.nextInt(100) ;
            int attempts = 1;
            boolean correctguess = false;
            System.out.println("\t  Welcome to the number guessing game. \t\t");

            System.out.println("\t  Guess the number between 1 and 100.   \t");
            System.out.println("--------------------NOTE--------------------");
            System.out.println("You will have 8 attempts to guess the number. ");

            while (!correctguess && attempts < 9) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                System.out.println("Current attempt no "+attempts);
                attempts++;

                if (guess == no_guessed) {
                    System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts.");
                    System.out.println("you have guessed the correct no = "+ no_guessed);

                    correctguess = true;
                }
                else if(guess>100 ){
                    System.out.println("Out of bound ! Please try guess no less than 100 ");
                    if(guess<0){
                        System.out.println("Out of bound ! Please try guess no greater than  0");
                    }

                }
                else if (guess < no_guessed)
                {
                    System.out.println("Your guessed number is too low, Please try again .\n ");
                }
                else
                {
                    System.out.println("Your guessed number is too high, Please try again .\n");
                }

            }

            if (!correctguess)
            {
                System.out.printf("Sorry, you've exceeded the maximum number of attempts.\nThe correct number was %d.%n", no_guessed);
            }

            System.out.print("Do you want to play the game again? (yes/no): ");
            String playChoice = scanner.next();
            if (!playChoice.equalsIgnoreCase("yes")) {
                play_Again = false;
            }
        }


        System.out.println("Thanks for playing!");
    }
}
