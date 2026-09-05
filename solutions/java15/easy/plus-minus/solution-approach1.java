// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
// Problem     Plus Minus
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 06:37 p.m.
// Technique   linear-scan-counter
// Time        O(n)
// Space       O(1)
// Insight     The algorithm maintains three independent counters to track the frequency of positive, negative, and zero elements during a single pass over the input list.
// Interview   Before: "I will use a hash map to store counts." After: "Using three integer counters is more efficient, achieving O(n) time and O(1) space, while ensuring the required six-decimal precision via printf formatting."
// Pitfalls    (1) Integer division will truncate results to zero if the numerator is not cast to double before dividing by the array size.  (2) Failing to use the %.6f format specifier will result in incorrect precision, as the problem explicitly requires six decimal places.
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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int totalPositive =0;
        int totalNegative = 0;
        int totalZero = 0;
        
        for (int element : arr){
            if (element >0){
                totalPositive ++;
            }
            else if (element<0){
                totalNegative ++;
            }
            else{
                totalZero ++;
            }
        }
        System.out.printf("%.6f\n", (double) totalPositive/arr.size());
        System.out.printf("%.6f\n", (double) totalNegative/arr.size());
        System.out.printf("%.6f\n", (double) totalZero/arr.size());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
