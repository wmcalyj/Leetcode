package com.leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengchaowang on 6/10/17.
 * <p>
 * <p>
 * <p>
 * <p>
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 * <p>
 * The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 * <p>
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 * <p>
 * Example:
 * <p>
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * <p>
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 */
public class Q604 {

  Queue<Character> chars;
  Queue<Integer> nums;
  int currentCount = 0;

  public Q604(String compressedString) {
    chars = new LinkedList<>();
    nums = new LinkedList<>();
    currentCount = 0;
    int num = 0;
    for (int i = 0; i < compressedString.length(); i++) {
      if (!Character.isDigit(compressedString.charAt(i))) {
        if (num != 0) {
          nums.offer(num);
          num = 0;
        }
        chars.offer(compressedString.charAt(i));

      } else {
        if (num == 0) {
          num = Integer.parseInt("" + compressedString.charAt(i));
        } else {
          num = 10 * num + Integer.parseInt("" + compressedString.charAt(i));
        }
      }
    }
    nums.offer(num);
  }

  public char next() {
    if (chars.isEmpty() || nums.isEmpty()) {
      return ' ';
    }
    if (currentCount == nums.peek()) {
      nums.poll();
      chars.poll();
      if (nums.isEmpty() || chars.isEmpty()) {
        return ' ';
      }
      currentCount = 1;
      return chars.peek();
    } else {
      currentCount++;
      return chars.peek();
    }
  }

  public boolean hasNext() {
    if (chars.size() == 1 && currentCount == nums.peek()) {
      return false;
    }
    return !chars.isEmpty() && !nums.isEmpty() && currentCount <= nums.peek();
  }

  public static void main(String[] args) {
    String[] tests = {"L1e2t1C1o1d1e1", "x6"};
    Q604[] sis = new Q604[tests.length];
    int i = 0;
    for (String test : tests) {
      sis[i++] = new Q604(test);
    }
    System.out.println(sis[0].next());
    System.out.println(sis[0].next());
    System.out.println(sis[0].next());
    System.out.println(sis[0].next());
    System.out.println(sis[0].next());
    System.out.println(sis[0].next());
    System.out.println(sis[0].hasNext());
    System.out.println(sis[0].next());
    System.out.println(sis[0].hasNext());

    System.out.println(sis[1].next());
    System.out.println(sis[1].next());
    System.out.println(sis[1].next());
    System.out.println(sis[1].hasNext());
    System.out.println(sis[1].next());
    System.out.println(sis[1].next());
    System.out.println(sis[1].next());
    System.out.println(sis[1].next());
    System.out.println(sis[1].hasNext());
  }
}
