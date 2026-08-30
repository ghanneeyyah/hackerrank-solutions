// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/solve-me-first/problem?isFullScreen=true
// Problem     Solve Me First
// Difficulty  Easy
// Subdomain   Warmup
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-30, 11:16 a.m.
// Technique   arithmetic-summation
// Time        O(1)
// Space       O(1)
// Insight     The function computes the sum of two integers by applying the addition operator to the provided input parameters.
// Interview   Before: "How would you implement a basic addition function?" After: "The implementation uses the addition operator to return the sum in O(1) time and O(1) space, handling the integer inputs directly as specified in the problem constraints."
// Pitfalls    (1) Integer overflow may occur if the sum of a and b exceeds the maximum value representable by a 32-bit signed integer.
// ──────────────────────────────────────────────────

import java.util.*;

public class Solution {

    static int solveMeFirst(int a, int b) {
      // Hint: Type return a+b; below 
      return a+b;
	}

  
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        in.close();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
	}
}
