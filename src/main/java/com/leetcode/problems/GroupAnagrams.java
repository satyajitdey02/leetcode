package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> results = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String hash = hash(str);
      List<String> stringList = new ArrayList<>();
      if (map.containsKey(hash)) {
        stringList = map.get(hash);
      }
      stringList.add(str);
      map.put(hash, stringList);
    }

    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      results.add(entry.getValue());
    }

    return results;
  }

  private String hash(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);

    return new String(chars);
  }

  public static void main(String[] args) {
    GroupAnagrams instance = new GroupAnagrams();
    System.out.println(instance.groupAnagrams(
        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

}
