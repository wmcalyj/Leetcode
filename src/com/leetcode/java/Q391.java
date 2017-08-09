package com.leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 *

 Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

 Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


 Example 1:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [3,2,4,4],
 [1,3,2,4],
 [2,3,3,4]
 ]

 Return true. All 5 rectangles together form an exact cover of a rectangular region.

 Example 2:

 rectangles = [
 [1,1,2,3],
 [1,3,2,4],
 [3,1,4,2],
 [3,2,4,4]
 ]

 Return false. Because there is a gap between the two rectangular regions.

 Example 3:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [3,2,4,4]
 ]

 Return false. Because there is a gap in the top center.

 Example 4:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [2,2,4,4]
 ]

 Return false. Because two of the rectangles overlap with each other.

 *
 * @author mengchaowang
 *
 */
public class Q391 {

  public class Pos {

    int x, y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean lessEqualThen(Pos p2) {
      return p2.x >= this.x && p2.y >= this.y;
    }

    public boolean greaterEqualThan(Pos p2) {
      return p2.x <= this.x && p2.y <= this.y;
    }

    public boolean lessThen(Pos p2) {
      return p2.x > this.x && p2.y > this.y;
    }

    public boolean greaterThan(Pos p2) {
      return p2.x < this.x && p2.y < this.y;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Pos)) {
        return false;
      }
      return (this.x == ((Pos) o).x && this.y == ((Pos) o).y);

    }

  }

  public class Rectangle {

    Pos lowLeft, topRight;

    public Rectangle(int[] pos) {
      this.lowLeft = new Pos(pos[0], pos[1]);
      this.topRight = new Pos(pos[2], pos[3]);
    }

    public Rectangle(Pos lowLeft, Pos topRight) {
      this.lowLeft = lowLeft;
      this.topRight = topRight;
    }

    public int getArea() {
      if (lowLeft == null || topRight == null) {
        return 0;
      } else {
        return (topRight.y - lowLeft.y) * (topRight.x - lowLeft.x);
      }
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Rectangle)) {
        return false;
      }
      return (this.lowLeft.equals(((Rectangle) o).lowLeft) && this.topRight
          .equals(((Rectangle) o).topRight));
    }

    public boolean encounter(Rectangle r) {
      int x1 = this.lowLeft.x;
      int y1 = this.lowLeft.y;
      int x2 = this.topRight.x;
      int y2 = this.topRight.y;
      int x3 = r.lowLeft.x;
      int y3 = r.lowLeft.y;
      int x4 = r.topRight.x;
      int y4 = r.topRight.y;
      if (x3 > x1 && x3 < x2 && y3 > y1 && y3 < y2) {
        return true;
      }
      if (x4 > x1 && x4 < x2 && y4 > y1 && y4 < y2) {
        return true;
      }
      if (x3 == x1) {
        if (y3 > y1 && y3 < y2) {
          return true;
        }
      }
      if (x4 == x2) {
        if (y4 > y1 && y4 < y2) {
          return true;
        }
      }
      if (y3 == y1) {
        if (x3 > x1 && x3 < x2) {
          return true;
        }
      }
      if (y4 == y2) {
        if (x4 > x1 && x4 < x2) {
          return true;
        }
      }
      return false;

    }
  }

  public boolean isRectangleCover(int[][] rectangles) {
    Set<Rectangle> recs = new HashSet<Rectangle>();
    Pos min = null, max = null;
    int area = 0;
    for (int i = 0; i < rectangles.length; i++) {
      Rectangle tmp = new Rectangle(rectangles[i]);
      for (Rectangle rec : recs) {
        if (rec.encounter(tmp)) {
          return false;
        }
      }
      if (!recs.add(tmp)) {
        return false;
      }
      if (min == null && max == null) {
        min = tmp.lowLeft;
        max = tmp.topRight;
      } else {
        if (tmp.lowLeft.lessEqualThen(min)) {
          min = tmp.lowLeft;
        }
        if (tmp.topRight.greaterEqualThan(max)) {
          max = tmp.topRight;
        }
      }
      // System.out.println("Area: " + rs[i].getArea());
      area += tmp.getArea();
    }
    // System.out.println("Min X: " + min.x + ", Min Y: " + min.y);
    // System.out.println("Max X: " + max.x + ", Max Y: " + max.y);
    int shouldBe = (new Rectangle(min, max)).getArea();
    return area == shouldBe;

  }

  public static void main(String[] args) {
    Q391 q = new Q391();
    int[][][] rectangles = {{{0, 0, 4, 1}, {7, 0, 8, 2}, {6, 2, 8, 3}, {5, 1, 6, 3}, {4, 0, 5, 1},
        {6, 0, 7, 2}, {4, 2, 5, 3}, {2, 1, 4, 3}, {0, 1, 2, 2}, {0, 2, 2, 3}, {4, 1, 5, 2},
        {5, 0, 6, 1}}, {{0, 0, 1, 1}, {0, 1, 3, 2}, {1, 0, 2, 2}}};

    for (int i = 0; i < rectangles.length; i++) {
      System.out.println(q.isRectangleCover(rectangles[i]));
    }
  }
}
