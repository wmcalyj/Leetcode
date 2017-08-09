package com.leetcode.java;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 *

 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 * @author mengchaowang
 *
 */
public class Q323Lock {

  // 478 ms
  public int countComponents(int n, int[][] edges) {
    // Weighted Union Find with Path Compression
    int[] sets = new int[n];
    // Initialize, each node is itself's parent
    for (int i = 0; i < n; i++) {
      sets[i] = i;
    }
    for (int i = 0; i < edges.length; i++) {
      unite(sets, edges[i][0], edges[i][1]);
    }

    Set<Integer> uniqueSets = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      uniqueSets.add(root(sets, sets[i]));
    }
    return uniqueSets.size();
  }

  private void unite(int[] sets, int i, int j) {
    if (!find(sets, i, j)) {
      int parenti = root(sets, i);
      int parentj = root(sets, j);
      sets[parenti] = parentj;
    }
  }

  public int root(int[] sets, int i) {
    while (sets[i] != i) {
      sets[i] = sets[sets[i]];
      i = sets[i];
    }
    return i;
  }

  private boolean find(int[] sets, int i, int j) {
    return root(sets, i) == root(sets, j);
  }

  public int countComponents2(int n, int[][] edges) {
    Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
    // Initialize
    for (int i = 0; i < n; i++) {
      Set<Integer> s = new HashSet<Integer>();
      s.add(i);
      sets.add(s);
    }
    for (int i = 0; i < edges.length; i++) {
      Set<Integer> s1 = null;

      Set<Integer> s2 = null;

      for (Set<Integer> s : sets) {
        if (s.contains(edges[i][0])) {
          s1 = s;
        }
        if (s.contains(edges[i][1])) {
          s2 = s;
        }
        if (s1 != null && s2 != null) {
          break;
        }
      }
      if (s1 != null && s2 != null) {
        sets.remove(s1);
        sets.remove(s2);
        s1.addAll(s2);
        sets.add(s1);
      }
    }

    return sets.size();
  }

  public static void print(Map<Integer, Set<Integer>> map) {
    System.out.println("Start: -------------------------");
    for (Entry<Integer, Set<Integer>> set : map.entrySet()) {
      System.out.print("Key: " + set.getKey() + ", values: [");
      for (Integer i : set.getValue()) {
        System.out.print(i + ",");
      }
      System.out.println("]");
    }
    System.out.println("End: -------------------------");
  }

  public static void print2(Set<Set<Integer>> sets) {
    System.out.println("Start: -------------------------");
    for (Set<Integer> set : sets) {
      System.out.print("[");
      for (Integer i : set) {
        System.out.print(i + ",");
      }
      System.out.println("]");
    }
    System.out.println("End: -------------------------");
  }

  public static void main(String[] args) {
    Q323Lock q = new Q323Lock();
    int[] ns = {5, 4};
    int[][][] edges = {{{0, 1}, {1, 2}, {3, 4}}, {{2, 3}, {1, 2}, {1, 3}}};

    for (int i = 0; i < edges.length; i++) {
      System.out.println("Result: " + q.countComponents(ns[i], edges[i]));
    }
  }
}
