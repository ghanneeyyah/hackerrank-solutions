// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
// Problem     Java Regex
// Difficulty  Medium
// Subdomain   Strings
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-26, 10:28 p.m.
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

