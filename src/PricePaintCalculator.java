public class PricePaintCalculator {
    static float averagePrice = 28;
    public static float getAveragePrice(){
        return averagePrice;
    }
    static float averageSize = 2.5f;
    public static float getAverageSize(){
        return averageSize;
    }

    public static int calcNumOfCans(float litres){
        double amount = Math.floor(litres/averageSize);
        amount+= (litres % averageSize > 0 ? 1 : 0);
        return (int)amount;
    }

    public static float totalPrice(int numOfCans){
        return numOfCans * averageSize;
    }
}
