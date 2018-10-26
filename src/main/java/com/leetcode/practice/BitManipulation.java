package com.leetcode.practice;

/**
 * Created by satyajit on 10/26/18.
 */
public class BitManipulation {

  public static void main(String[] args) {
    BitManipulation instance = new BitManipulation();
    int num = 5;//0b00000111;
    //int pos = 1;//0b00000010;

    System.out.println(String.format("%s:%8s", num, Integer.toBinaryString(num)).replace(' ', '0'));
    //System.out.println(String.format("%s:%8s", pos, Integer.toBinaryString(pos)).replace(' ', '0'));

    int set = instance.set(num, 1);
    System.out
        .println(String.format("SET[%s]:%8s", num, Integer.toBinaryString(set)).replace(' ', '0'));

    int clear = instance.clear(num, 0);
    System.out.println(
        String.format("CLEAR[%s]:%8s", num, Integer.toBinaryString(clear)).replace(' ', '0'));

    int flip = instance.flip(num, 1);
    System.out.println(
        String.format("FLIP[%s]:%8s", num, Integer.toBinaryString(flip)).replace(' ', '0'));

    boolean isSet = instance.isSet(num, 0);
    System.out.println(String.format("IS_SET[%s]:%s", num, isSet));
  }

  public int set(int number, int position) {
    return (number | (1 << position));
  }

  public int clear(int number, int position) {
    return number & ~(1 << position);
  }

  public int flip(int number, int position) {
    return number ^ (1 << position);
  }

  public boolean isSet(int number, int position) {
    //return (number & (1 << position)) != 0;//1st method
    return (number >> position & 1) != 0;//2nd method
  }

}
