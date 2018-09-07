package com.leetcode.problems;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String str) {
        String s = str.substring(0, str.length());
        int result = 0, index = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        while (index < s.length()) {
            int repeatIndex = sb.toString().indexOf(chars[index]);
            if (repeatIndex < 0) {
                sb.append(chars[index]);
                index++;
                continue;
            }

            if (result < sb.toString().length()) {
                result = sb.toString().length();
            }

            String sub = sb.toString() + chars[index];


            index = s.indexOf(sub) + repeatIndex + 1;//findNextNonRepeatChar(s, s.indexOf(sub) + repeatIndex + 1);
            s = s.substring(index, s.length()-1);
            chars = s.toCharArray();
            index=0;
            sb.setLength(0);

        }

        return result < sb.toString().length() ? sb.toString().length() : result;
    }

    private String removeConsecutiveChars(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                sb.append(chars[i]);
            }

        }

        return sb.toString();
    }

    private int findNextNonRepeatChar(String s, int start) {
        char[] chars = s.toCharArray();
        for (int i = start; i < s.length(); i++) {
            if (i < s.length() - 1 && chars[i] != chars[i + 1]) {
                return i;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating instance = new LongestSubstringWithoutRepeating();
        System.out.println("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq: " + instance.lengthOfLongestSubstring("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq"));

        /* System.out.println("aab: "+ instance.lengthOfLongestSubstring("aab"));
         System.out.println("satyajit: " + instance.lengthOfLongestSubstring("satyajit"));
         System.out.println("keya: " +instance.lengthOfLongestSubstring("keya"));
        System.out.println("kuhu: " + instance.lengthOfLongestSubstring("kuhu"));
        System.out.println("abcabcbb: "+instance.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbbb: " + instance.lengthOfLongestSubstring("bbbbbb"));
        System.out.println("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt: " + instance.lengthOfLongestSubstring("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt"));

*/
    }
}
