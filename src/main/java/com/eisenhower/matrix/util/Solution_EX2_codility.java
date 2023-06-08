package com.eisenhower.matrix.util;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class Solution_EX2_codility {

    // Function to count the number of
    // possible numbers divisible by 3
    public int solution(String number)
    {

        // Calculate the sum
        int sum = 0;
        for (int i = 0; i < number.length(); ++i) {
            sum += number.charAt(i) - 48;
        }

        // Store the answer
        int count = 0;
        if (sum % 3 == 0)
            count++;

        // Iterate over the range
        for (int i = 0; i < number.length(); ++i) {

            // Decreasing the sum
            int remaining_sum
                    = sum - (number.charAt(i) - 48);

            // Iterate over the range
            for (int j = 0; j <= 9; ++j) {

                // Checking if the new sum
                // is divisible by 3 or not
                if ((remaining_sum + j) % 3 == 0
                        && j != number.charAt(i) - 48) {

                    // If yes increment
                    // the value of the count
                    ++count;
                }
            }
        }
        return count;
    }
}

