package Root_Mean_Square_Propagation;
// Created: November 2022
public class SampleGradientProvider implements GradientProvider {
    private double[] parameters;
    public SampleGradientProvider(double[] parameters) {
        this.parameters = parameters;
    }
    @Override
    public double[] computeGradients() {
        double[] gradients = new double[parameters.length];
        gradients[0] = 2 * (parameters[0] - 2);
        gradients[1] = 4 * (parameters[1] + 1);
        gradients[2] = 0.5 * (parameters[2] - 3);
        return gradients;
    }
    @Override
    public double[] getParameters() {
        return parameters;
    }
}