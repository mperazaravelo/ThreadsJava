// Class Water, represents some data that will be shared by multiple threads, and it simulates
// the action of taking a water break.
// When the contender is "drinking", the thread will be asleep.
public class Water {
    // Synchronized drink method to ensure only one contender drinks at a time
    public synchronized void drink(String contenderName) {
        try { //try block starts
            System.out.println(contenderName + " is drinking water.");
            // Simulate the drinking time, where one contender drinks longer than the other
            if (contenderName.equals("Blue")) {
                Thread.sleep(500); // Blue drinks for 500ms
            } else {
                Thread.sleep(300); // Red drinks for 300ms
            }
            System.out.println(contenderName + " has finished drinking water.");
        } //try block ends
        catch (InterruptedException e) { //catch block starts
            e.printStackTrace();
        } //catch block ends
    }
}
