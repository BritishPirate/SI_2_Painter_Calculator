public class AreaCalculator {
    public static float calculateArea(int ws, float num1, float num2){
        switch (ws){
            case 3:
                rectangleArea(num1, num2);
                break;
            case 4:
                break;
            default:
                throw new Error("You have called upon a non existant shape");
        }
        return 0f;
    }

    public static float calculateArea(int ws, float num1){
        switch (ws){
            case 1:
                squareArea(num1);
                break;
            case 2:
                circleArea(num1);
                break;
            default:
                throw new Error("You have called upon a non existant shape");
        }
        return 0f;
    }


    //region 1 number area calculators
    public static float squareArea(float side){ //Calculate the area of a square by multiplying a side by itself
        return side * side;
    }

    public static float circleArea(float diameter){
        float radius = diameter * 0.5f;
        return (float)(Math.PI * radius * radius);
    }
    //endregion

    //region 2 number area calculators
    public static float rectangleArea(float side1, float side2){
        return side1 * side2;
    }

    public static float triangleArea(float side1, float side2){
        return 0.5f * side1 * side2;
    }
    //endregion
}
