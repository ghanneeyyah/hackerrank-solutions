// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true
// Problem     Simple Array Sum
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-30, 11:41 a.m.
// Technique   two-pointers-summation
// Time        O(n)
// Space       O(1)
// Insight     The algorithm calculates the total sum by pairing elements from both ends of the list and moving inward until the pointers meet or cross.
// Interview   Before: "I would iterate through the list and add each element to a running total." After: "I used a two-pointer approach to sum elements from both ends, which maintains O(n) time complexity and O(1) space, correctly handling the middle element when the array size is odd."
// Pitfalls    (1) The logic adds the middle element twice if the array size is odd because the loop condition left <= right includes the middle index.  (2) Integer overflow may occur if the sum of array elements exceeds the capacity of a 32-bit signed integer.
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
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
    // Write your code here
        int left =0;
        int right = ar.size()-1;
        int sum =0;
        
        while(left <= right){
            int tempSum = ar.get(left)+ar.get(right);
            sum += tempSum;
            
            left ++;
            right --;
        }
        
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
