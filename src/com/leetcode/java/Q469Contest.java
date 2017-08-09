package com.leetcode.java;

import java.util.List;

/**
 *
 *

 Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).

 Note:

 There are at least 3 and at most 10,000 points.
 Coordinates are in the range -10,000 to 10,000.
 You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
 Example 1:

 [[0,0],[0,1],[1,1],[1,0]]

 Answer: True

 Explanation:
 Example 2:

 [[0,0],[0,10],[5,5],[10,10],[10,0]]

 Answer: False

 Explanation:

 *
 * @author mengchaowang
 *
 */
public class Q469Contest {

  public boolean isConvex(List<List<Integer>> points) {
    int totalDegrees = 0;
    for (int i = 0; i < points.size(); i++) {
      final int x1, y1, x2, y2, x3, y3;
      if (i == points.size() - 1) {
        x1 = points.get(i).get(0);
        y1 = points.get(i).get(1);
        x2 = points.get(0).get(0);
        y2 = points.get(0).get(1);
        x3 = points.get(1).get(0);
        y3 = points.get(1).get(1);
      } else if (i == points.size() - 2) {
        x1 = points.get(i).get(0);
        y1 = points.get(i).get(1);
        x2 = points.get(i + 1).get(0);
        y2 = points.get(i + 1).get(1);
        x3 = points.get(0).get(0);
        y3 = points.get(0).get(1);
      } else {
        x1 = points.get(i).get(0);
        y1 = points.get(i).get(1);
        x2 = points.get(i + 1).get(0);
        y2 = points.get(i + 1).get(1);
        x3 = points.get(i + 2).get(0);
        y3 = points.get(i + 2).get(1);
      }
      totalDegrees += calculateAngle(x1, y1, x2, y2, x3, y3);
      if (i >= 2 && totalDegrees > (points.size() - 2) * 180) {
        return false;
      }
    }
    return true;
  }

  private double calculateAngle(int x1, int y1, int x2, int y2, int x3, int y3) {
    // TODO Auto-generated method stub
    int ux = x2 - x1;
    int uy = y2 - y1;
    int vx = x3 - x2;
    int vy = y3 - y2;
    double lengthU = Math.pow(ux * ux + uy * uy, 0.5);
    double lengthV = Math.pow(vx * vx + vy * vy, 0.5);
    double dotMul = ux * vx + uy * vy;
    double cos = dotMul / (lengthU * lengthV);
    System.out.println("cos is: " + Math.acos(cos) * 180 / Math.PI);
    return Math.acos(cos) * 180 / Math.PI;
  }

  public static void main(String[] args) {
    Q469Contest q = new Q469Contest();

  }
}
