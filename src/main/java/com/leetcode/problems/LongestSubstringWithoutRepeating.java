package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        String cloneS = s.substring(0, s.length());
        int result = 0, index = 0;
        StringBuilder sb = new StringBuilder();

        while (index < cloneS.length()) {
            int repeatIndex = sb.toString().indexOf(cloneS.charAt(index));
            if (repeatIndex < 0) {
                sb.append(cloneS.charAt(index));
                index++;
                continue;
            }

            result = Math.max(result, sb.toString().length());
            String sub = sb.toString() + cloneS.charAt(index);

            index = cloneS.indexOf(sub) + repeatIndex + 1;
            cloneS = cloneS.substring(index, cloneS.length());
            if (cloneS.length() <= result) {
                return result;
            }

            index = 0;
            sb.setLength(0);
        }

        return sb.toString().length();
    }

    public int lengthOfLongestSubstringLeetcodeSolution(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating instance = new LongestSubstringWithoutRepeating();

        //System.out.println("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq: " + instance.lengthOfLongestSubstringLeetcodeSolution("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq"));
        // System.out.println("aab: " + instance.lengthOfLongestSubstringLeetcodeSolution("aab"));

        String input = "mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt";
        long startTime = System.nanoTime();
        int answer = instance.lengthOfLongestSubstringLeetcodeSolution(input);
        long endTime = System.nanoTime();
        System.out.println(String.format("%s - %s - %s", input, answer, (endTime - startTime)));

        input = "mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt";
        startTime = System.nanoTime();
        answer = instance.lengthOfLongestSubstring(input);
        endTime = System.nanoTime();
        System.out.println(String.format("%s - %s - %s", input, answer, (endTime - startTime)));
        /*
        System.out.println("keya: " + instance.lengthOfLongestSubstringLeetcodeSolution("keya"));
        System.out.println("kuhu: " + instance.lengthOfLongestSubstringLeetcodeSolution("kuhu"));
        System.out.println("abcabcbb: " + instance.lengthOfLongestSubstringLeetcodeSolution("abcabcbb"));
        System.out.println("bbbbbb: " + instance.lengthOfLongestSubstringLeetcodeSolution("bbbbbb"));
        System.out.println("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt: " + instance.lengthOfLongestSubstringLeetcodeSolution("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt"));
*/

    }
}
