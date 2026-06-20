public class FinancialForecast {

    public static double predictFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case
        return predictFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1);
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue =
                predictFutureValue(
                        currentValue,
                        growthRate,
                        years);

        System.out.printf(
                "Predicted value after %d years = Rs.%.2f",
                years,
                futureValue);
    }
}