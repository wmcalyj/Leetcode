package com.leetcode.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 *

 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0

 *
 *
 * @author mengchaowang
 *
 */
public class Q318 {


  public int maxProduct(String[] words) {
    int re = 0;
    Arrays.sort(words, Comparator.comparingInt(String::length));
    Integer[] charInts = preprocess(words);

    for (int i = words.length - 1; i > 0; i--) {
      int countI = words[i].length();
      if (countI * (words[i - 1].length()) <= re) {
        return re;
      }
      for (int j = i - 1; j >= 0; j--) {
        int countJ = words[j].length();

        if ((charInts[i] & charInts[j]) == 0) {
          re = Math.max(re, countI * countJ);
          break;
        }
      }
    }
    return re;
  }

  private Integer[] preprocess(String[] words) {
    Integer[] re = new Integer[words.length];
    int count = 0;
    for (String word : words) {
      int[] ints = new int[26];
      word.chars().distinct().mapToObj(i -> (char) i)
          .forEach(character -> ints[character - 'a'] = 1);
      int num = 0;
      for (int i = 0; i < 26; i++) {
        num += Math.pow(2, i) * ints[i];
      }
      re[count++] = num;
    }
    return re;
  }

  public void testPreprocess(String[] testPreprocess) {
    Arrays.stream(preprocess(testPreprocess)).forEach(System.out::println);
  }

  public static void main(String[] args) {
    Q318 q = new Q318();
    String[] ab = {"a", "b"};
    q.testPreprocess(ab);
  }
}
