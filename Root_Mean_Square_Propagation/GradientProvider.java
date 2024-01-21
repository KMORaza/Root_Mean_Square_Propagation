package Root_Mean_Square_Propagation;
// Created: November 2022
public interface GradientProvider {
    double[] computeGradients();
    double[] getParameters();
}
