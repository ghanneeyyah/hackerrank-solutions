// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
// Problem     Birthday Cake Candles
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 07:28 p.m.
// Technique   sorting-and-linear-scan
// Time        O(N log N)
// Space       O(1)
// Insight     The algorithm sorts the list to identify the maximum value at the last index and then performs a linear scan to count all occurrences of that maximum value.
// Interview   Before: "I could use a hash map to store frequencies of each candle height." After: "Sorting the list allows me to identify the maximum height in O(N log N) time, then counting occurrences takes O(N), resulting in an overall O(N log N) time complexity for the problem constraints."
// Pitfalls    (1) Sorting the list modifies the original input order, which might be unexpected if the list is reused elsewhere.  (2) Using O(N log N) time complexity is less efficient than a single-pass O(N) approach using a running maximum and counter.
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
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
        candles.sort(null);
        int count =0;
        for(int element: candles){
            if(element== candles.get(candles.size()-1)){
                count++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
