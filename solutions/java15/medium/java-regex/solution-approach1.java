// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
// Problem     Java Regex
// Difficulty  Medium
// Subdomain   Strings
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-26, 10:28 p.m.
// Technique   regex-pattern-matching-split
// Time        O(N)
// Space       O(1)
// Insight     The implementation validates an IP address by splitting the input string into four segments and verifying each segment against a regex pattern that enforces the 0-255 range constraint.
// Interview   Before: "How would you validate an IP address format?" After: "I split the string by dots and verify each segment matches the 0-255 range using regex, ensuring O(N) time complexity where N is the string length."
// Pitfalls    (1) Failing to account for the exact four-segment requirement, which causes the code to return false for strings with more or fewer than three dots.  (2) Incorrectly handling the regex range, as the pattern must explicitly cover 0-199, 200-249, and 250-255 to satisfy the 0-255 constraint.  (3) Overlooking that the split method requires escaping the dot character, as a literal dot in regex matches any character.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class Solution {

    private static boolean MyRegex (String pattern){
        if(pattern==null){
            return false;
        }
        
        List<String> list = Arrays.asList(pattern.split("\\."));
        
        if(list == null || list.size()!=4){
            return false;
        }
        
        String regex = "^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";
        
        
        for(int i =0; i< list.size(); i++){
            
            if (!Pattern.matches(regex, list.get(i))) {
                return false; // Fast fail if any part is invalid
            }
        }
        
        
        return true;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String input = scan.nextLine();
            System.out.println(Solution.MyRegex(input));
        }
        scan.close();
    }
}

