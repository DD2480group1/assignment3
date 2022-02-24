package com.thealgorithms.maths;

import java.util.ArrayList;

public class Gaussian {
    static int[] intArray = new int[11];

    public static ArrayList<Double> gaussian(int mat_size, ArrayList<Double> matrix) {
        ArrayList<Double> answerArray = new ArrayList<Double>();
        int i, j = 0;
        double[][] mat = new double[mat_size + 1][mat_size + 1];
        double[][] x = new double[mat_size][mat_size + 1];

        // Values from arraylist to matrix
        for (i = 0; i < mat_size; i++) {
            intArray[0]++;
            for (j = 0; j <= mat_size; j++) {
                intArray[1]++;
                mat[i][j] = matrix.get(i);
            }
        }

        mat = gaussianElimination(mat_size, i, mat);
        answerArray = valueOfGaussian(mat_size, x, mat);
        for(int k=0; k<intArray.length;k++){
            System.out.println(k+": "+ intArray[k]);
        }
        return answerArray;
    }

    // Perform Gaussian elimination
    public static double[][] gaussianElimination(int mat_size, int i, double[][] mat) {
        int step = 0;
        for (step = 0; step < mat_size - 1; step++) {
            intArray[2]++;
            for (i = step; i < mat_size - 1; i++) {
                intArray[3]++;
                double a = (mat[i + 1][step] / mat[step][step]);

                for (int j = step; j <= mat_size; j++) {
                    intArray[4]++;
                    mat[i + 1][j] = mat[i + 1][j] - (a * mat[step][j]);
                }
            }
        }
        return mat;
    }

    // calcilate the x_1, x_2,... values of the gaussian and save it in an arraylist.
    public static ArrayList<Double> valueOfGaussian(int mat_size, double[][] x, double[][] mat) {
        ArrayList<Double> answerArray = new ArrayList<Double>();
        int i, j;

        for (i = 0; i < mat_size; i++) {
            intArray[5]++;
            for (j = 0; j <= mat_size; j++) {
                intArray[6]++;
                x[i][j] = mat[i][j];
            }
        }

        for (i = mat_size - 1; i >= 0; i--) {
            intArray[7]++;
            double sum = 0;
            for (j = mat_size - 1; j > i; j--) {
                intArray[8]++;
                x[i][j] = x[j][j] * x[i][j];
                sum = x[i][j] + sum;
            }
            if (x[i][i] == 0) {
                intArray[9]++;
                x[i][i] = 0;
            } else {
                intArray[10]++;
                x[i][i] = (x[i][mat_size] - sum) / (x[i][i]);
            }
            answerArray.add(x[i][j]);
        }
        return answerArray;
    }
}