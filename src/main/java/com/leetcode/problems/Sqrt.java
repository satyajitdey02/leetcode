package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by satyajit on 10/31/18.
 */
public class Sqrt {

  public static void main(String[] args) {
    Sqrt instance = new Sqrt();
    System.out.println(instance.mySqrt(1024));

  }

  public int mySqrt(int x) {
    Map<String, Integer> map = new TreeMap<String, Integer>() {
      {
        put("0", 0);
        put("1", 1);
        put("4", 2);
        put("9", 3);
        put("16", 4);
        put("25", 5);
        put("36", 6);
        put("49", 7);
        put("64", 8);
        put("81", 9);
      }
    };

    if (map.containsKey(x + "")) {
      return map.get(x + "");
    }

    char[] chars = String.valueOf(x).toCharArray();
    List<Integer> msc = new ArrayList<>();
    List<Integer> nms = new ArrayList<>();
    for (int i = chars.length - 1; i >= 0; i = i - 2) {
      if (i == chars.length - 1) {
        for (String s : map.keySet()) {
          if (s.endsWith(chars[i] + "")) {
            msc.add(map.get(s));
          }
        }
      } else {

        int pair = i - 1 < 0 ? Integer.parseInt(chars[i] + "")
            : Integer.parseInt(chars[i - 1] + "" + chars[i]);
        if (map.containsKey(String.valueOf(pair))) {
          nms.add(map.get(String.valueOf(pair)));
        } else {
          int prev = 0;
          for (String s : map.keySet()) {
            int val = Integer.parseInt(s);
            if (pair > val) {
              prev = val;
            } else {
              nms.add(map.get(prev+""));
              break;
            }
          }
        }
      }
    }


    StringBuilder lowestApprox = new StringBuilder();
    StringBuilder highestApprox = new StringBuilder();


    //StringBuilder middleApprox = new StringBuilder();
    for (Integer num : nms) {
      lowestApprox.append(num);
      //highestApprox.append(num);
      //middleApprox.append(num);
    }


    if (msc.size() == 0) {
      msc.add(9);
    }

    int prevRes = Integer.parseInt(lowestApprox.toString()+msc.get(0));
    if(msc.size()>1) {
      for(int i = msc.get(0);i<=msc.get(1);i++) {
        int nnn = Integer.parseInt(lowestApprox.toString()+i);
        if(nnn*nnn == x) {
          return nnn;
        } else if(nnn*nnn > x) {
          return prevRes;
        } else {
          prevRes = nnn;
        }
      }
    } else {
      for(int i = 0;i<=msc.get(0);i++) {
        int nnn = Integer.parseInt(lowestApprox.toString()+i);
        if(nnn*nnn == x) {
          return nnn;
        } else if(nnn*nnn > x) {
          return prevRes;
        } else {
          prevRes = nnn;
        }
      }
    }

    return prevRes;

    /*lowestApprox.append(msc.get(0));
    //middleApprox.append(5);
    if (msc.size() > 1) {
      highestApprox.append(msc.get(1));
    } else {

    }

    int middle = Integer.parseInt(middleApprox.toString());
    if (middle * middle <= x) {
      return middle;
    }

    return (middle * middle) > x ? Integer.parseInt(lowestApprox.toString())
        : Integer.parseInt(highestApprox.toString());*/
  }

}
