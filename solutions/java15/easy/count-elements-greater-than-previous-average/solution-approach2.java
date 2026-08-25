// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-elements-greater-than-previous-average/problem?isFullScreen=true
// Problem     Count Elements Greater Than Previous Average
// Difficulty  Easy
// Subdomain   Software Engineer Prep Kit
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-25, 12:27 p.m.
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
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
    // Write your code here
        if(responseTimes==null|| responseTimes.size() <2){
            return 0;
        }
        
        int regressionCount = 0;
        
        long runningTime = responseTimes.get(0);
        
        for (int index = 1; index < responseTimes.size(); index++){
            int currentDay = responseTimes.get(index);
            
            if ((long)currentDay*index > runningTime){
                regressionCount++;
            }
            runningTime +=currentDay;
        }
        
        return regressionCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countResponseTimeRegressions(responseTimes);

        System.out.println(result);

        bufferedReader.close();
    }
}
