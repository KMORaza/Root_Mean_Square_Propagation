package Root_Mean_Square_Propagation;
// Created: November 2022
public class RMSPropOptimizer {
    private double learningRate;
    private double decayFactor;
    private double epsilon;
    private double[] squaredGradients;
    public RMSPropOptimizer(double learningRate, double decayFactor, double epsilon, int numParameters) {
        this.learningRate = learningRate;
        this.decayFactor = decayFactor;
        this.epsilon = epsilon;
        this.squaredGradients = new double[numParameters];
    }
    public double[] minimize(GradientProvider gradientProvider) {
        double[] gradients = gradientProvider.computeGradients();
        for (int i = 0; i < gradients.length; i++) {
            squaredGradients[i] = decayFactor * squaredGradients[i] + (1 - decayFactor) * Math.pow(gradients[i], 2);
        }
        double[] parameters = gradientProvider.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] -= (learningRate / (Math.sqrt(squaredGradients[i]) + epsilon)) * gradients[i];
        }
        return parameters;
    }
}