// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true
// Problem     Staircase
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-05, 06:59 p.m.
// Technique   string-repeat-loop
// Time        O(n^2)
// Space       O(n)
// Insight     The algorithm iterates from one to n, printing a line composed of n minus i spaces followed by i hash symbols to ensure right-alignment.
// Interview   Before: "How would you construct the right-aligned staircase?" After: "I use a loop from 1 to n, repeating spaces and hashes to build each line. This runs in O(n^2) time because each of the n lines requires O(n) operations to construct and print."
// Pitfalls    (1) Incorrectly calculating the number of spaces as n minus i plus one instead of n minus i.  (2) Using a loop range starting at zero instead of one, which would result in an extra line of spaces.  (3) Failing to account for the right-alignment requirement by printing hashes before spaces.
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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
        String space =" ";
        String hash = "#";
        for(int i=1; i<=n; i++){
            System.out.println(space.repeat(n - i) + hash.repeat(i));
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
