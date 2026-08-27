// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/duplicate-word/problem?isFullScreen=true
// Problem     Java Regex 2 - Duplicate Words
// Difficulty  Medium
// Subdomain   Strings
// Platform    HackerRank
// Language    java8
// Status      Accepted
// Submitted   2026-08-27, 10:47 p.m.
// Technique   regex-backreference-replacement
// Time        O(N * M) where N is the number of sente…
// Space       O(M) for storing the regex match and th…
// Insight     The regex uses a backreference to identify repeated word sequences, while the replacement logic preserves the first captured group to ensure case-sensitive retention of the initial occurrence.
// Interview   Before: "How do I remove duplicate words while keeping the first instance?" After: "Use a regex with a backreference and case-insensitive flag, then replace the entire match with the first captured group. This approach runs in O(N * M) time, effectively handling repeated words regardless of case."
// Pitfalls    (1) Failing to use the word boundary anchor \b, which causes the regex to match substrings within words.  (2) Neglecting the case-insensitive flag in the Pattern compilation, which prevents detection of mixed-case duplicates like 'Ab aB'.  (3) Using replaceAll incorrectly by not capturing the first group, which would replace the entire duplicate sequence with an empty string or incorrect text.
// ──────────────────────────────────────────────────

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll("(?i)"+ m.group(), m.group(1));
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}
