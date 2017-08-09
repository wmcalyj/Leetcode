package com.leetcode.java;

/**
 *

 Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.

 Note:

 A word cannot be split into two lines.
 The order of words in the sentence must remain unchanged.
 Two consecutive words in a line must be separated by a single space.
 Total words in the sentence won't exceed 100.
 Length of each word won't exceed 10.
 1 ≤ rows, cols ≤ 20,000.
 Example 1:

 Input:
 rows = 2, cols = 8, sentence = ["hello", "world"]

 Output:
 1

 Explanation:
 hello---
 world---

 The character '-' signifies an empty space on the screen.
 Example 2:

 Input:
 rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

 Output:
 2

 Explanation:
 a-bcd-
 e-a---
 bcd-e-

 The character '-' signifies an empty space on the screen.
 Example 3:

 Input:
 rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

 Output:
 1

 Explanation:
 I-had
 apple
 pie-I
 had--

 The character '-' signifies an empty space on the screen.


 * @author mengchaowang
 *
 */
public class Q418Contest {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    int[] lengths = new int[sentence.length];
    for (int i = 0; i < lengths.length; i++) {
      lengths[i] = sentence[i].length();
    }
    if (sentence == null || sentence.length == 0 || rows == 0 || cols == 0) {
      return 0;
    }
    int rowIdx = 0, colIdx = 0, wordIdx = 0;
    int total = 0;
    while (rowIdx < rows) {
      while (cols - colIdx >= lengths[wordIdx]) {
        colIdx += lengths[wordIdx];
        wordIdx++;
        if (wordIdx == sentence.length) {
          wordIdx = 0;
          total++;
        }
        colIdx++;
      }
      rowIdx++;
      colIdx = 0;
    }
    return total;
  }

  public static void main(String[] args) {
    String[][] sentence = {{"hello", "world"}, {"a", "bcd", "e"}, {"I", "had", "apple", "pie"},
        {"f", "p", "a"}, {"a", "b", "e"}};
    int[] rows = {2, 3, 4, 8, 20000};
    int[] cols = {8, 6, 5, 7, 20000};
    Q418Contest q = new Q418Contest();
    for (int i = 0; i < sentence.length; i++) {
      System.out.println(q.wordsTyping(sentence[i], rows[i], cols[i]));
    }
  }
}
