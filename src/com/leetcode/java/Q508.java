package com.leetcode.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 *

 Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 *
 * @author mengchaowang
 *
 */
public class Q508 {

  private class ValFreq {

    public int val, count;

    public ValFreq(int val, int count) {
      this.val = val;
      this.count = count;
    }
  }

  // Value, Count
  Map<Integer, Integer> re = new HashMap<Integer, Integer>();

  public int[] findFrequentTreeSum(TreeNode root) {
    getSumForThisRoot(root);
    return findAnswers();
  }

  private int[] findAnswers() {
    ValFreq[] res = new ValFreq[re.size()];
    int i = 0;
    for (Entry<Integer, Integer> entry : re.entrySet()) {
      res[i] = new ValFreq(entry.getKey(), entry.getValue());
      i++;
    }

    Arrays.sort(res, new Comparator<ValFreq>() {
      @Override
      public int compare(ValFreq o1, ValFreq o2) {
        return o2.count - o1.count;
      }
    });
    if (res == null || res.length == 0) {
      return new int[0];
    }
    int highest = res[0].count;
    int j = 1;
    for (; j < res.length; j++) {
      if (res[j].count < highest) {
        break;
      }
    }
    int[] re = new int[j];
    for (int k = 0; k < j; k++) {
      re[k] = res[k].val;
    }
    return re;

  }

  private int getSumForThisRoot(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      int val = root.val;
      putInMap(val);
      return val;
    }
    int left = 0;
    if (root.left != null) {
      left = getSumForThisRoot(root.left);

    }
    int right = 0;
    if (root.right != null) {
      right = getSumForThisRoot(root.right);
    }
    int current = left + right + root.val;
    putInMap(current);
    return current;
  }

  private void putInMap(int val) {
    int count = re.containsKey(val) ? re.get(val) + 1 : 1;
    re.put(val, count);
  }

}
