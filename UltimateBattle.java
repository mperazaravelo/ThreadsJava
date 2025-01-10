/*
Marla Peraza Ravelo, COP-3330C-17193, 9/29/2024
The objective of this program is to demonstrate the use of threads and concurrency, by creating two
threads which will run independently and go into a battle, only one of them being the winner.
The user will not need to input any values, and everything will be printed out in the screen according to
the values provided.
First, each contestant will rest for a certain amount of time. Then, they will perform an action (in this
case eating an amount of hot dogs). The program will evaluate if the contestant has won (if they have eaten
200 hot dogs or more). If there is a winner, there will be a message printed out, and if not, the contestants
will drink water, and the iteration will begin again.
 */
//class UltimateBattleApp, the main class where we will instantiate the Contender and Water classes, and where
//all the actions take place
class UltimateBattleApp {
    public static void main(String[] args) {
        // Create a shared Water object
        Water water = new Water();

        // Create two contenders with different rest times and actions per iteration
        Contender blue = new Contender("Blue", 5, 200, water);
        Contender red = new Contender("Red", 10, 400, water);

        // Create and start threads for the contenders
        Thread thread1 = new Thread(blue);
        Thread thread2 = new Thread(red);

        thread1.start();
        thread2.start();

        try {//try block starts
            // Wait for both threads to complete
            thread1.join();
            thread2.join();
        }//try block ends
        catch (InterruptedException e) {//catch block starts
            e.printStackTrace();
        }//catch block ends

        //prints out a message signaling that the battle is over
        System.out.println("The battle is over!");
    }
}
