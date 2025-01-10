import java.util.Random; //Imports the Random type
//Contender class, is going to implement the Runnable interface. Creates the contenders that will
//fight against each other
public class Contender implements Runnable {
    private String name; //name of the contender
    private int hotDogs ; // Represents how many hot dogs are eaten at a time
    private int maxRest; // Maximum rest time in milliseconds
    private int totalHotDogsEaten; // Total hot dogs eaten
    private Water water; // Shared water object
    private static volatile boolean winner = false;

    //Constructor
    public Contender(String name, int hotDogs, int maxRest, Water water) {
        this.name = name;
        this.hotDogs = hotDogs;
        this.totalHotDogsEaten = 0;
        this.maxRest = maxRest;
        this.water = water;
    }

    //Run method
    @Override
    public void run() {
        Random random = new Random(); //Creates a new random number generator

        while (!winner) { //while loop that iterates until winner = true
            try { // try block starts
                // Rest for a random time within the maxRest limit
                int restTime = random.nextInt(maxRest);
                System.out.println(name + " is resting for " + restTime + "ms.");
                Thread.sleep(restTime);

                // Eat hot dogs
                totalHotDogsEaten += hotDogs;
                System.out.println(name + " ate " + hotDogs +" hot dogs. Total: " + totalHotDogsEaten);

                // Check if the contender has won (if they have eaten 200 or more hot dogs)
                if (totalHotDogsEaten >= 200) {
                    winner = true;
                    System.out.println(name + " has won the battle!");
                    break;
                }

                // Take a water break
                water.drink(name);

            }//try block ends
            catch (InterruptedException e) { //catch block starts
                e.printStackTrace();
            }// catch block ends
        }
    }
}
