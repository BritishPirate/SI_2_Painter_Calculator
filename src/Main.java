import java.util.Scanner;

public class Main { // Main class, starts here
    public static void main(String[] args){ // Main method, starts here
        Scanner sc = new Scanner(System.in); // Generate a new scanner to take console input with
        System.out.println("How many walls do you need to paint?");
        int numOfWalls = sc.nextInt();
        System.out.println("Do you want the same number of coats on all of them? (Anything other than yes is considered no)");
        boolean sameNumCoats = sc.next().trim().toLowerCase().equals("yes");
        int coats = 0;
        float[] wallsArea = new float[numOfWalls];
        float[] wallsPaint = new float[numOfWalls];
        if(sameNumCoats){
            System.out.println("How many coats would you like?");
            coats = sc.nextInt();
            for(int i = 0; i < numOfWalls; i++){
                System.out.println("Wall number " + i);
                wallsArea[i] = findArea(sc);
                wallsPaint[i] = PaintCalculator.calcPaint(wallsArea[i], coats);
            }
        }
        else{
            for(int i = 0; i < numOfWalls; i++){
                System.out.println("Wall number " + i);
                System.out.println("How many coats would you like for this wall?");
                coats = sc.nextInt();
                wallsArea[i] = findArea(sc);
                wallsPaint[i] = PaintCalculator.calcPaint(wallsArea[i], coats);
            }
        }
        float totalPaint = arrSum(wallsPaint);
        int numberOfCans = PricePaintCalculator.calcNumOfCans(totalPaint);

        printResults(wallsArea, wallsPaint, numberOfCans);
    }

    /*
    Prints the results
     */
    private static void printResults(float[] wallsArea, float[] wallsPaint, int numOfCans){
        System.out.println("Calculations complete.");
        System.out.println("Total surface area: " + arrSum(wallsArea));
        System.out.println("Total paint required: " + arrSum(wallsPaint) + " at " + PaintCalculator.getRatio() + " Litres per meter squared");
        System.out.println("This would require a total number of " + numOfCans + " cans of paint, costing a total of £" + PricePaintCalculator.totalPrice(numOfCans) + " at £" + PricePaintCalculator.averagePrice + " per can.");
        System.out.println("Breakdown: ");
        for(int i = 0; i < wallsArea.length; i++){
            System.out.println("Wall number " + i + " with a total surface area (to paint) of " + wallsArea[i] + " meters squared and require a total of " + wallsPaint[i] + " litres of paint to paint.");
        }
    }


    //region Area Questions
    /*
    Overarching function, start with finding out what shape and area the wall has, then find out any gaps that should not be painted.
    */

    private static float findArea(Scanner sc){
        float area = findShapeArea(sc, "wall");
        System.out.println("Are there any gaps in your wall? Please consider any sockets, windows, doors and any other area that should not be painted.");
        System.out.println("Please answer in Yes or No");
        boolean gaps = (sc.next().trim().toLowerCase().equals("yes"));
        if(gaps){
           float gapTotal = 0;
           while(gaps){
                gapTotal += findShapeArea(sc, "gap");
                System.out.println("Are there any more gaps in your wall? Please consider any sockets, windows, doors and any other area that should not be painted.");
                System.out.println("Please answer in Yes or No");
                gaps = (sc.next().trim().toLowerCase().equals("yes"));
            }
           return area - gapTotal;
        }
        return area;
    }

    /*
    Find out the shape and pass down to correct function to calculate the area.
    */

    private static float findShapeArea(Scanner sc, String gapOrWall){
        System.out.println("What shape is the " + gapOrWall + "? (Please reply with the corresponding number to the option below)");
        String options =
                "1: Square\n" +
                "2: Circle\n" +
                "3: Rectangle\n" +
                "4: Triangle";
        System.out.println(options);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                return SquareArea(sc);
            case 2:
                return circleArea(sc);
            case 3:
                return rectangleArea(sc);
            case 4:
                return triangleArea(sc);
            default:
                throw new Error("You are trying a shape that does not exist!");
        }
    }
     /*
    Get the details needed for the area of a square and call upon the area calculator to calculate the area.
     */
    private static float SquareArea(Scanner sc){
        System.out.println("How wide is the area in meters?"); // Prompt the width question
        float width = sc.nextLong(); // Take the user input as the width
        return AreaCalculator.squareArea(width);
    }
    /*
       Get the details needed for the area of a circle and call upon the area calculator to calculate the area.
    */
    private static float circleArea(Scanner sc){
        System.out.println("Please measure the distance from 2 opposite ends of the circle");
        float diameter = sc.nextFloat();
        return AreaCalculator.circleArea(diameter);
    }
    /*
       Get the details needed for the area of a rectangle and call upon the area calculator to calculate the area.
    */
    private static float rectangleArea(Scanner sc){
        System.out.println("How wide is the area in meters?"); // Prompt the width question
        float width = sc.nextLong(); // Take the user input as the width
        System.out.println("How high is the wall in meters?"); // Prompt height question
        float height = sc.nextLong(); // Take user input as height
        return AreaCalculator.rectangleArea(width, height);
    }

    /*
    Get the details needed for the area of a triangle and call upon the area calculator to calculate the area.
     */
    private static float triangleArea(Scanner sc){
        System.out.println("Please measure the longest side of the triangle, and then\n measure from the corner that doesn't touch the longest side to it, perpendicularly.");
        System.out.println("How wide is the area in meters?"); // Prompt the width question
        float width = sc.nextLong(); // Take the user input as the width
        System.out.println("How high is the area in meters?"); // Prompt height question
        float height = sc.nextLong(); // Take user input as height
        return AreaCalculator.triangleArea(width, height);
    }
    //endregion

    //region Helper Functions
    /*
    Get the sum from an array of floats
     */
    private static float arrSum(float[] arr){
        float total = 0;
        for(float f : arr){
            total += f;
        }
        return total;
    }
    //endregion

    //region Coats methods
    private static void paintOneWall(Scanner sc, int coats, float area){
        System.out.println("");
        System.out.println("You are going to need " + PaintCalculator.calcPaint(area, coats) + " litres of paint to paint your wall!");
    }

    private static void paintOneWall(Scanner sc, float area){
        System.out.println("How many coats would you like?"); // Prompt coats question
        int coats = sc.nextInt(); // Take user's request amount of coats
        System.out.println("You are going to need " + PaintCalculator.calcPaint(area, coats) + " litres of paint to paint your wall!");
    }
    // endregion
}
