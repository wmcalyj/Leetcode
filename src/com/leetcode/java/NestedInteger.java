package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

  Integer val = null;
  List<NestedInteger> nestedList = null;

  // Constructor initializes an empty nested list.
  public NestedInteger() {
  }

  // Constructor initializes a single integer.
  public NestedInteger(int value) {
    this.val = value;
  }

  // @return true if this NestedInteger holds a single integer, rather than a
  // nested list.
  public boolean isInteger() {
    return nestedList == null && val != null;
  }

  ;

  // @return the single integer that this NestedInteger holds, if it holds a
  // single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger() {
    return this.val;
  }

  // Set this NestedInteger to hold a single integer.
  public void setInteger(int value) {
    this.val = value;
  }

  // Set this NestedInteger to hold a nested list and adds a nested integer to
  // it.
  public void add(NestedInteger ni) {
    if (this.nestedList == null) {
      this.nestedList = new ArrayList<>();
    }
    nestedList.add(ni);
  }

  // @return the nested list that this NestedInteger holds, if it holds a
  // nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList() {
    return this.nestedList;
  }
}
