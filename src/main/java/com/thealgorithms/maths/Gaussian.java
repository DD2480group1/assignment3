package com.thealgorithms.maths;

import java.util.ArrayList;

public class Gaussian {

    public static ArrayList<Double> gaussian(int mat_size, ArrayList<Double> matrix){
        int  i, j, step;
        ArrayList<Double> answerArray = new ArrayList<Double>();


        double[][] mat = new double[mat_size + 1][mat_size + 1];
        double[][] x = new double[mat_size][mat_size + 1];

        System.out.println("Enter value of the matrix");
        System.out.println(' ');
        for (i = 0; i < mat_size; i++) {
            for (j = 0; j <= mat_size; j++) {
                mat[i][j] = matrix.get(i) ;
            }
        }

        // perform Gaussian elimination
        for (step = 0; step < mat_size - 1; step++) {
            for (i = step; i < mat_size - 1; i++) {
                double a = (mat[i + 1][step] / mat[step][step]);

                for (j = step; j <= mat_size; j++) {
                    mat[i + 1][j] = mat[i + 1][j] - (a * mat[step][j]);
                }
            }
        }

        System.out.println("Matrix using Gaussian Elimination method: ");
        System.out.println(" ");
        for (i = 0; i < mat_size; i++) {
            for (j = 0; j <= mat_size; j++) {
                x[i][j] = mat[i][j];
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Value of the Gaussian Elimination method: ");
        System.out.println(" ");

        for (i = mat_size - 1; i >= 0; i--) {
            double sum = 0;
            for (j = mat_size - 1; j > i; j--) {
                x[i][j] = x[j][j] * x[i][j];
                sum = x[i][j] + sum;
            }
            if (x[i][i] == 0) {
                x[i][i] = 0;
            } else {
                x[i][i] = (x[i][mat_size] - sum) / (x[i][i]);
            }
            System.out.print("x" + i + "=" + x[i][i]);
            System.out.println(" ");
            answerArray.add(x[i][j]);
        }
        return answerArray;
    }
}

