public class PaintCalculator {
    static float paintRatio = 6.5f;
    public static float getRatio(){
        return paintRatio;
    }
    public static float calcPaint(float area, int coats){ // Multiply the result of 1 coat by number of coats
        return area * paintRatio * coats;
    }
}
