package Root_Mean_Square_Propagation;
// Created: November 2022
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int numParameters = 3;
        double learningRate = 0.001;
        double decayFactor = 0.9;
        double epsilon = 1e-8;
        RMSPropOptimizer optimizer = new RMSPropOptimizer(learningRate, decayFactor, epsilon, numParameters);
        double[] initialParameters = {1.0, 2.0, 3.0};
        GradientProvider gradientProvider = new SampleGradientProvider(initialParameters);
        int numIterations = 100;
        for (int i = 0; i < numIterations; i++) {
            initialParameters = optimizer.minimize(gradientProvider);
            gradientProvider = new SampleGradientProvider(initialParameters);
            System.out.println("ITERATION " + (i + 1) + ": Parameters = " + Arrays.toString(initialParameters));
        }
    }
}