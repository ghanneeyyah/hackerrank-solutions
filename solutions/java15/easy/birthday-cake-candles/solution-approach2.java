// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
// Problem     Birthday Cake Candles
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 07:31 p.m.
// Technique   sorting-and-linear-scan
// Time        O(n log n)
// Space       O(1)
// Insight     The algorithm identifies the maximum candle height by sorting the list and then counts occurrences of that maximum value through a single linear pass.
// Interview   Before: "I could use a hash map to store frequencies of each height." After: "Sorting the list allows finding the maximum in O(n log n) time, followed by a linear scan to count occurrences, which is efficient given the constraints on n."
// Pitfalls    (1) Sorting the list modifies the original input order, which might be undesirable if the list is needed later.  (2) Using Collections.max() after sorting is redundant as the last element of the sorted list is already the maximum.
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
        int max = Collections.max(candles);
        int count =0;
        for(int element: candles){
            if(element== max){
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
