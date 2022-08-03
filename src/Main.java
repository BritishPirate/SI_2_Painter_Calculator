import java.util.Scanner;

public class Main { // Main class, starts here
    public static void main(String[] args){ // Main method, starts here
        Scanner sc = new Scanner(System.in); // Generate a new scanner to take console input with
        System.out.println("How wide is the wall in meters?"); // Prompt the width question
        float width = sc.nextLong(); // Take the user input as the width
        System.out.println("How high is the wall in meters?"); // Prompt height question
        float height = sc.nextLong(); // Take user input as height
        System.out.println("How many coats would you like?"); // Prompt coats question
        long coats = sc.nextLong(); // Take user's request amount of coats
        System.out.println("You are going to need " + calcPaint(width, height, 6.5f, coats) + " litres of paint to paint your wall!");
    }

    private static float calcPaint(float width, float height, float paintRatio, long coats){ // Multiply the result of 1 coat by number of coats
        return calcPaint(width * height, paintRatio) * coats;
    }

    private static float calcPaint(float width, float height, float paintRatio){ // Calculate the area and feed it down
        return calcPaint(width * height, paintRatio);
    }

    private static float calcPaint(float wallArea, float paintRatio){ // Multiply the area by the paint ratio to calculate the amount of paint needed for a coat
        return wallArea * paintRatio;
    }
}
