package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *

 Given a list of strings, you could assemble these strings together into a loop. Among all the possible loops, you need to find the lexicographically biggest string after cutting and making one breakpoint of the loop, which will make a looped string into a regular one.

 So, to find the lexicographically biggest string, you need to experience two phases:

 Assemble all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
 Cut and make one breakpoint in any place of the loop, which will make a looped string into a regular string starting from the character at the cutting point.
 And your job is to find the lexicographically biggest one among all the regular strings.

 Example:
 Input: "abc", "xyz"
 Output: "zyxcba"
 Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
 where '-' represents the looped status.
 The answer string came from the third looped one,
 where you could cut from the middle and get "zyxcba".
 Note:
 The input strings will only contain lowercase letters.
 The total length of all the strings will not over 1000.

 *
 * @author mengchaowang
 *
 */
public class Q555 {

  public String splitLoopedString(String[] strs) {
    char max = 'a';
    List<Integer> groups = new ArrayList<Integer>();
    List<Integer> ids = new ArrayList<Integer>();
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs[i].length(); j++) {
        if (strs[i].charAt(j) > max) {
          groups = new ArrayList<Integer>();
          groups.add(i);
          ids = new ArrayList<Integer>();
          ids.add(j);
        } else if (strs[i].charAt(j) == max) {
          groups.add(i);
          ids.add(j);
        }
      }
    }
    String startString = "";
    int maxGroup = -1;
    int maxId = -1;
    boolean leftDirection = false;
    for (int i = 0; i < groups.size(); i++) {
      String groupStr = strs[groups.get(i)];
      int id = ids.get(i);
      String left = new StringBuilder(groupStr.substring(0, id + 1)).reverse().toString();
      String right = groupStr.substring(id);
      if (left.compareTo(startString) > 0) {
        maxGroup = groups.get(i);
        maxId = ids.get(i);
        leftDirection = true;
      }
      if (right.compareTo(startString) > 0) {
        maxGroup = groups.get(i);
        maxId = ids.get(i);
        leftDirection = false;
      }
    }

    StringBuilder re = new StringBuilder(startString);

    int nextLeftGroup = maxGroup == 0 ? strs.length - 1 : maxGroup - 1;
    int nextRightGroup = maxGroup == strs.length - 1 ? 0 : maxGroup + 1;

    String reverseLeft = new StringBuilder(strs[nextLeftGroup]).reverse().toString();
    String reverseRight = new StringBuilder(strs[nextRightGroup]).reverse().toString();
    String left = strs[nextLeftGroup];
    String right = strs[nextRightGroup];

    int direction = -1; // -1 means left, 1 means right;
    String next = "";
    if (reverseLeft.compareTo(reverseRight) >= 0 && reverseLeft.compareTo(left) >= 0
        && reverseLeft.compareTo(right) >= 0) {
      next = reverseLeft;
      direction = -1;
    }
    if (reverseRight.compareTo(reverseLeft) >= 0 && reverseRight.compareTo(left) >= 0
        && reverseRight.compareTo(right) >= 0) {
      next = reverseRight;
      direction = 1;
    }
    if (left.compareTo(reverseLeft) >= 0 && left.compareTo(reverseRight) >= 0
        && left.compareTo(right) >= 0) {
      next = left;
      direction = -1;
    }
    if (right.compareTo(reverseLeft) >= 0 && right.compareTo(reverseRight) >= 0
        && right.compareTo(left) >= 0) {
      next = right;
      direction = 1;
    }

    re.append(next);
    if (direction == -1) {
      // go left
      int third = nextLeftGroup - 1;
      if (third == 0) {
        third = strs.length - 1;
      }
      while (third != maxGroup) {
        String rThird = new StringBuilder(strs[third]).reverse().toString();
        re.append(strs[third].compareTo(rThird) >= 0 ? strs[third] : rThird);
        third--;
        if (third == 0) {
          third = strs.length - 1;
        }
      }
      if (leftDirection) {
        re.append(new StringBuilder(strs[maxGroup].substring(maxId)).reverse());
      } else {
        re.append(strs[maxGroup].substring(0, maxId));
      }
    } else {
      // go right
      int third = nextRightGroup + 1;
      if (third == strs.length) {
        third = 0;
      }
      while (third != maxGroup) {
        String rThird = new StringBuilder(strs[third]).reverse().toString();
        re.append(strs[third].compareTo(rThird) >= 0 ? strs[third] : rThird);
        third++;
        if (third == strs.length) {
          third = 0;
        }
      }
      if (leftDirection) {
        re.append(new StringBuilder(strs[maxGroup].substring(maxId)).reverse());
      } else {
        re.append(strs[maxGroup].substring(0, maxId));
      }
    }
    return re.toString();

  }
}
