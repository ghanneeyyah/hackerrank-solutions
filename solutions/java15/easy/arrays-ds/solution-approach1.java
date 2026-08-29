// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/arrays-ds/problem?isFullScreen=true
// Problem     Arrays - DS
// Difficulty  Easy
// Subdomain   Arrays
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-29, 11:39 p.m.
// Technique   reverse-iteration-list-copy
// Time        O(n)
// Space       O(n)
// Insight     The implementation constructs a new list by traversing the input list from the last index down to zero.
// Interview   Before: "I could swap elements in-place to save space." After: "This approach uses O(n) space to create a new list, which is acceptable given the constraints, and runs in O(n) time by iterating backwards through the input list."
// Pitfalls    (1) Accessing index a.size() instead of a.size() - 1 causes an IndexOutOfBoundsException.  (2) Failing to include the zero index in the loop condition i >= 0 results in an incomplete reversal.
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
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
    // Write your code here
        List<Integer> newA = new ArrayList<>();
        
        for(int i = a.size()-1; i>= 0; i--){
            newA.add(a.get(i));
        }
        return newA;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> res = Result.reverseArray(arr);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
