package com.eisenhower.matrix.util;

class Solution_EX1_codility {
    public int solution(int[] A) {
        int n = A.length;

        // Step 1: Convert array A into the decimal representation of V
        int V = 0;
        for (int i = n - 1; i >= 0; i--) {
            V = V * 10 + A[i];
        }

        // Step 2: Calculate 17 * V
        int result = 17 * V;

        // Step 3: Calculate the sum of the digits in the decimal representation of 17 * V
        int sum = 0;
        while (result > 0) {
            sum += result % 10;
            result /= 10;
        }

        // Step 4: Return the sum
        return sum;
    }
}
