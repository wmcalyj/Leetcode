//package com.leetcode;
//// @formatter:off
//
//import java.util.ArrayList;
//import java.util.List; /**
// * Created by mengchaowang on 7/13/17.
//
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// */
//
//// @formatter:on
//public class Q077 {
//
//  public List<List<Integer>> combine(int n, int k) {
//    List<Integer> base = new ArrayList<>(k);
//    for (int i = 1; i <= k; i++) {
//      base.add(i);
//    }
//    List<List<Integer>> re = new ArrayList<>();
//    formAnswer(re, base, n, k, k - 1);
//
//  }
//
//  private void formAnswer(List<List<Integer>> re, List<Integer> base, int n, int k, int idx) {
//    if (idx < 0) {
//      return;
//    } else {
//      int newVal = base.get(idx) + 1;
//      if (newVal == n) {
//        createNewBase(base, idx - 1, n, k);
//      }
//      base.set(idx, base.get(idx) + 1);
//      formAnswer(re, base, n, k, idx);
//    }
//  }
//
//  private void createNewBase(List<Integer> base, int idx, int n, int k) {
//    int val = base.get(idx);
//    for (int i = idx; i < base.size(); i++) {
//      base.set(i, ++val);
//    }
//  }
//}
