// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/merge-and-sort-intervals/problem?isFullScreen=true
// Problem     Merge and Sort Intervals
// Difficulty  Medium
// Subdomain   Software Engineer Prep Kit
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-25, 01:58 p.m.
// Technique   sorting-and-linear-scan
// Time        O(N log N)
// Space       O(N)
// Insight     The algorithm maintains a reference to the last merged interval and updates its end time if the current interval overlaps, or appends the current interval if it starts after the last one ends.
// Interview   Before: "I would use a nested loop to compare every interval against every other interval." After: "Sorting by start time allows a single linear pass to merge intervals in O(N log N) time, which is optimal given the 100,000 interval constraint."
// Pitfalls    (1) Failing to handle the empty list case, which causes an IndexOutOfBoundsException when accessing the first element.  (2) Using integer subtraction in the comparator, which can cause overflow if start times are large negative and positive values.  (3) Modifying the original list elements directly, which may lead to unexpected side effects if the input list is reused elsewhere.
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
     * Complete the 'mergeHighDefinitionIntervals' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY intervals as parameter.
     */

    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
    // Write your code here
        List<List<Integer>> newIntervals = new ArrayList<>();
        
        
        if (intervals==null|| intervals.isEmpty()) {
            return new ArrayList<>();
        }
        intervals.sort((a,b)-> a.get(0) - b.get(0));
        List<Integer> lastMerged = intervals.get(0);
        
        newIntervals.add(lastMerged);
        for (Integer i=1; i < intervals.size(); i++) {
            List<Integer> currentRow = intervals.get(i);
            
            if ( currentRow.get(0) <= lastMerged.get(1)) {
                lastMerged.set(1, Math.max(lastMerged.get(1), currentRow.get(1)) );
                
            }
            else{
                lastMerged = currentRow;
                newIntervals.add(lastMerged);
            }
        
            
        }
        
        return newIntervals;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int intervalsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int intervalsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> intervals = new ArrayList<>();

        IntStream.range(0, intervalsRows).forEach(i -> {
            try {
                intervals.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.mergeHighDefinitionIntervals(intervals);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .collect(toList())
            .forEach(System.out::println);

        bufferedReader.close();
    }
}
