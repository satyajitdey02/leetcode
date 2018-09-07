package com.leetcode.problems;

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
            if(cloneS.length() <= result) {
                return result;
            }

            index=0;
            sb.setLength(0);

        }

        return result < sb.toString().length() ? sb.toString().length() : result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating instance = new LongestSubstringWithoutRepeating();
        System.out.println("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq: " + instance.lengthOfLongestSubstring("gpaazszqlcxvfoaaxzagwsemzszjukeczgfbzetkisiq"));

        System.out.println("aab: "+ instance.lengthOfLongestSubstring("aab"));
         System.out.println("satyajit: " + instance.lengthOfLongestSubstring("satyajit"));
         System.out.println("keya: " +instance.lengthOfLongestSubstring("keya"));
        System.out.println("kuhu: " + instance.lengthOfLongestSubstring("kuhu"));
        System.out.println("abcabcbb: "+instance.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbbb: " + instance.lengthOfLongestSubstring("bbbbbb"));
        System.out.println("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt: " + instance.lengthOfLongestSubstring("mpesjbcxgdfucjbrazpzpzdrlnepyiikzoeirghxkmsoytgyuxxjycdmqhbqrjasyhapnkpzyjowewuztt"));


    }
}
