// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
// Problem     Mini-Max Sum
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 07:14 p.m.
// Technique   sorting-and-sliding-window-sum
// Time        O(N log N)
// Space       O(1)
// Insight     The minimum sum is the total of the first four elements, while the maximum sum is the total of the last four elements after sorting the array.
// Pitfalls    (1) Failing to use long integers for the sum variables, which causes overflow given the constraints.  (2) Assuming the input array is already sorted, which leads to incorrect minimum and maximum calculations.  (3) Incorrectly indexing the array during the loop, which results in an ArrayIndexOutOfBoundsException.
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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        arr.sort(null);
        
        long leftSum = 0;
        long rightSum = 0;
        
        for(int i=0; i<4; i++){
            leftSum += arr.get(i);
            rightSum += arr.get(i+1);
        }
        
        System.out.println(leftSum + " "+ rightSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
