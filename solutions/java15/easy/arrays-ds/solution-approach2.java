// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/arrays-ds/problem?isFullScreen=true
// Problem     Arrays - DS
// Difficulty  Easy
// Subdomain   Arrays
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-29, 11:52 p.m.
// Technique   two-pointers-in-place-swap
// Time        O(n)
// Space       O(1)
// Insight     The algorithm maintains two pointers at the start and end of the list, swapping elements and moving toward the center until they meet or cross.
// Interview   Before: "I would create a new list and copy elements in reverse order." After: "I can perform an in-place reversal using two pointers to swap elements, achieving O(n) time and O(1) auxiliary space, which is optimal for an array of size N."
// Pitfalls    (1) Using an incorrect loop condition like left <= right would cause an unnecessary swap of the middle element when the list size is odd.  (2) Failing to use a temporary variable during the swap operation results in data loss for the element at the left index.
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
        int left = 0;
        int right = a.size()-1;
        while(left<right){
            int temp = a.get(left);
            a.set(left, a.get(right));
            a.set(right, temp);
            left++;
            right --;
        }
        
        return a;
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
