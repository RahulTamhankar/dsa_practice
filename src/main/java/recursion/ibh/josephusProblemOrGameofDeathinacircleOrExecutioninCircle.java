package recursion.ibh;


import java.lang.reflect.Array;
import java.util.ArrayList;

//this problem is recursively defined just like Kth Grammer to identify
public class josephusProblemOrGameofDeathinacircleOrExecutioninCircle {

    // Function to solve the Josephus Problem
    public static void solve(int idx, int k, ArrayList<Integer> person) {
        // Base Case: If only one person remains, that person is the survivor
        if (person.size() == 1) {
            System.out.println("Survivor: " + person.get(0));
            return;
        }

        // Compute the index of the next person to eliminate
        idx = (idx + k) % person.size();

        // Remove the person from the circle
        person.remove(idx); // here no need to save the deleted item in temp for induction step like sorting... as there is no need of deleted item

        // Recursively call solve with the updated index and person list
        solve(idx, k, person);
    }

    // Main method to initialize the problem
    public static void main(String[] args) {
        // Create a list of 40 people (1 to 40)
        ArrayList<Integer> person = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            person.add(i);
        }

        // Define the step size k (eliminate every 7th person)
        int k = 7;

        // Start the process with initial index 0 and step size k-1
        // We subtract 1 from k because the elimination starts from position k in a 0-based list
        solve(0, k - 1, person);
    }
}