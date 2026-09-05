// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
// Problem     Diagonal Difference
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 06:17 p.m.
// Technique   single-pass-diagonal-summation
// Time        O(n)
// Space       O(1)
// Insight     The algorithm iterates through the matrix rows once, accumulating the primary diagonal element at index i and the secondary diagonal element at index n-1-i simultaneously.
// Interview   Before: "I would iterate through the matrix twice to sum each diagonal separately." After: "I can compute both sums in a single O(n) pass by using the row index i to access arr[i][i] and arr[i][n-1-i], which is more efficient for a square matrix of size n."
// Pitfalls    (1) Confusing the secondary diagonal index calculation, which must be n-1-i to correctly access elements from the top-right to the bottom-left.  (2) Failing to use Math.abs() on the final difference, as the problem explicitly requires the absolute difference between the two sums.
// ──────────────────────────────────────────────────

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
        int firstSum = 0;
        int secondSum = 0;
        for(int i=0; i<arr.size(); i++){
            firstSum += arr.get(i).get(i);
            secondSum += arr.get(i).get(arr.size()-1-i);
        }
        
        return Math.abs(firstSum-secondSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
