package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note: n and k are non-negative integers.
 *
 * @author mengchaowang
 *
 */
public class Q276Lock {

  static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

  public class Node {

    int ways;
    Node left, right;

    public Node(int ways, Node left, Node right) {
      this.ways = ways;
      this.right = right;
      this.left = left;
    }

    public Node(int ways) {
      this.ways = ways;
      this.right = null;
      this.left = null;
    }

    public Node(int ways, Node parent) {
      this.ways = ways;
      this.right = null;
      this.left = null;
    }
  }

  public int numWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    Node root = new Node(k);
    int sum = root.ways;
    if (n > 1) {
      return generateTree(root, k, n, false);
    } else {
      return sum;
    }

  }

  public int numWays2(int n, int k) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return k;
    }
    int diffColorCounts = k * (k - 1);
    int sameColorCounts = k;
    for (int i = 2; i < n; i++) {
      int temp = diffColorCounts;
      diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
      sameColorCounts = temp;
    }
    return diffColorCounts + sameColorCounts;

  }

  public int numWays3(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    int[] ways = new int[n + 1];
    ways[0] = 0;

    ways[1] = k;

    ways[2] = k * k;

    for (int i = 3; i <= n; i++) {
      // Current is different then previous
      int diff = ways[i - 1] * (k - 1);
      // Current is the same as previous
      // That means previous cannot be the same as the one before previous
      int same = ways[i - 2] * (k - 1);
      ways[i] = diff + same;
    }
    return ways[n];
  }

  public int numWays4(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    int prev = k;
    int current = k * k;
    for (int i = 3; i <= n; i++) {
      int diff = current * (k - 1);
      int same = prev * (k - 1);
      prev = current;
      current = diff + same;
    }
    return current;
  }

  public int generateTree(Node node, int k, int n, boolean same) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (node == null) {
      return 0;
    }
    if (n <= 0) {
      return 0;
    }
    int sum = node.ways;
    // Different as parent;
    node.left = new Node(k - 1, node);
    if (!same) {
      // Same as parent;
      node.right = new Node(1, node);
    }
    if (n > 1) {
      int leftSub = generateTree(node.left, k, n - 1, false);
      int rightSub = generateTree(node.right, k, n - 1, true);
      cache.put(n, sum * (leftSub + rightSub));
      return sum * (leftSub + rightSub);
    }
    cache.put(n, sum);
    return sum;
  }

  public static void main(String[] args) {
    Q276Lock q = new Q276Lock();
    int i = 0;
    int k = 3;
    System.out.println(q.numWays4(3, 3));

    while (i <= 10) {
      System.out.println(q.numWays4(i++, k));
      cache.clear();
    }
    i = 2;
    k = 1;
    while (i <= 3) {
      System.out.println(q.numWays4(i++, k));
      cache.clear();
    }
    System.out.println(q.numWays4(43, 2));
    cache.clear();

  }
}
