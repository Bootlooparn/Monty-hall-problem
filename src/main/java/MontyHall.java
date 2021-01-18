import java.io.Console;
import java.util.Scanner;

public class MontyHall {
    public static void main(String[] args) {
        System.out.println("How many selectable doors do you wish to have?:");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        int numberOfDoors = Integer.parseInt(answer);
        GameShowHost steve = new GameShowHost(numberOfDoors);

        System.out.println("Do you wish to simulate or play the game?");
        System.out.println("1: Simulate the game");
        System.out.println("2: Play the game");

        answer = scanner.nextLine();

        switch (answer) {
            case "1":
                System.out.println("How many simulations?");
                int numberOfSimulations = scanner.nextInt();
                steve.simulate(numberOfSimulations);
                break;
            case "2":
                steve.startShow();
                break;
            default:
                System.out.println("No valid choice made and thus I'm closing down!");
        }
    }
}
