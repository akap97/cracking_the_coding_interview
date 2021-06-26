package basic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RotateMatrix {
//    Given an image represented by an NxN matrix, where each pixel in the image is 4
//    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    public static void main(String[] args) {
        //4bytes is int
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        RotateMatrix r = new RotateMatrix();
        r.rotate(matrix);
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i =0; i<n/2;i++) {
            int last = n - (i+1);
            for (int j = i; j<last;j++) {
                int offset = j-i; // keeps moving to copy edges one by one
                int temp= matrix[i][j]; //top
                matrix[i][j] = matrix[last-offset][i]; //left -> top
                matrix[last-offset][i] = matrix[last][last - offset]; //bottom -> left
                matrix[last][last-offset] = matrix[j][last]; // right -> bottom
                matrix[j][last] = temp; // top -> right
            }
        }
    }

}
