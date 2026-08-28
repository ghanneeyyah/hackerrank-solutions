// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/valid-username-checker/problem?isFullScreen=true
// Problem     Valid Username Regular Expression
// Difficulty  Easy
// Subdomain   Strings
// Platform    HackerRank
// Language    java8
// Status      Accepted
// Submitted   2026-08-28, 10:35 p.m.
// Technique   regular-expression-pattern-matching
// Time        O(N)
// Space       O(1)
// Insight     The regular expression enforces a mandatory alphabetic start followed by seven to twenty-nine alphanumeric or underscore characters to satisfy the length constraint of eight to thirty characters.
// Interview   Before: "I would manually check the length and iterate through each character to validate the set." After: "Using a regex pattern with anchors ensures O(N) validation time, where N is the username length, correctly enforcing the 8-30 character range and the alphabetic start requirement."
// Pitfalls    (1) Failing to use the \A anchor allows partial matches that violate the start-of-string requirement.  (2) Using {8,30} instead of [a-zA-Z][a-zA-Z0-9_]{7,29} incorrectly allows non-alphabetic characters at the first position.  (3) Omitting the $ anchor permits trailing invalid characters that exceed the maximum length constraint.
// ──────────────────────────────────────────────────


class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression ="\\A[a-zA-Z][a-zA-Z0-9_]{7,29}$";
    //public static final String regularExpression = null;
}

