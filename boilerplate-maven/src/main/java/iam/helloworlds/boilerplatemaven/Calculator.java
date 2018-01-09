package iam.helloworlds.boilerplatemaven;

public class Calculator {
    public double divide(double numerator, double denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("Denominator cannot be 0");
        }

        return numerator / denominator;
    }
}
