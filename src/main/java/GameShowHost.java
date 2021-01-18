import java.util.*;

public class GameShowHost {
    private Scanner input = new Scanner(System.in);
    private String message;
    private int numberOfDoors;

    public GameShowHost(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    private List<Door> createDoors() {
        ArrayList<Door> doors = new ArrayList<Door>(Collections.nCopies(numberOfDoors, new Door(Price.NOMONEY)));
        doors.set(new Random().nextInt(numberOfDoors), new Door(Price.MONEY));
        return doors;
    }

    public void simulate(int numberOfSimulations) {
        List<Door> doors = createDoors();
        Door selectedDoor;
        Random select = new Random();
        int wins = 0;

        // When not switching
        for (int i = 0; i < numberOfSimulations; i++) {
            selectedDoor = doors.get(select.nextInt(numberOfDoors));
            if (selectedDoor.getPrice() == Price.MONEY) {
                wins++;
            }
        }

        double winPercentage = (double) wins/numberOfSimulations;
        System.out.println("Win percentage when not switching: " + winPercentage);

        // Reset wins
        wins = 0;

        // When switching
        for (int i = 0; i < numberOfSimulations; i++) {
            selectedDoor = doors.get(select.nextInt(numberOfDoors));
            if (selectedDoor.getPrice() == Price.NOMONEY) {
                wins++;
            }
        }

        winPercentage = (double) wins/numberOfSimulations;
        System.out.println("Win percentage when switching: " + winPercentage);
    }

    public void startShow() {
        List<Door> doors = createDoors();
        Price price;

        System.out.println("The game has started! You can close it down by writing \"End\"");
        System.out.println("Please choose which which door you wish to open: 1-" + numberOfDoors);

        while (!"End".equalsIgnoreCase(message)) {
            message = input.nextLine();

            int index = Integer.parseInt(message);
            if (index >= 1 && index <= numberOfDoors) {
                price = doors.get(index - 1).getPrice();

                System.out.println("Do you wish to stick with your choice or switch?:");
                System.out.println("1: Stick");
                System.out.println("2: Switch");

                message = input.nextLine();

                switch (message) {
                    case "1":
                        if (price == Price.MONEY) {
                            System.out.println("You win! Congrats!");
                        } else {
                            System.out.println("Sorry, but you lose!");
                        }
                        break;
                    case "2":
                        if (price == Price.NOMONEY) {
                            System.out.println("You win! Congrats!");
                        } else {
                            System.out.println("Sorry, but you lose!");
                        }
                        break;
                }
                break;
            } else {
                System.out.println("Not a valid door number! Please try again: 1-" + numberOfDoors);
            }
        }
        System.out.println("Bye!");
    }
}
