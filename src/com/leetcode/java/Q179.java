package com.leetcode.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 *

 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 *
 * @author mengchaowang
 *
 */
public class Q179 {

  public String largestNumber(int[] nums) {
    String[] numStrs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numStrs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(numStrs, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int i = 0;
        int j = Math.min(o1.length(), o2.length());
        for (; i < j; i++) {
          if (o1.charAt(i) != o2.charAt(i)) {
            return o2.charAt(i) - o1.charAt(i);
          }
        }
        while (i < o1.length()) {
          j = 0;
          while (i < o1.length() - 1 && o2.charAt(j) == o1.charAt(i)) {
            i++;
            j++;
            if (j == o2.length()) {
              j = 0;
            }
          }
          while (j < o2.length() - 1 && o2.charAt(j) == o1.charAt(i)) {
            j++;
          }
          return o2.charAt(j) - o1.charAt(i);
        }
        while (i < o2.length()) {
          j = 0;
          while (i < o2.length() - 1 && o2.charAt(i) == o1.charAt(j)) {
            i++;
            j++;
            if (j == o1.length()) {
              j = 0;
            }
          }
          while (j < o1.length() - 1 && o1.charAt(j) == o2.charAt(i)) {
            j++;
          }
          return o2.charAt(i) - o1.charAt(j);
        }
        return 0;
      }
    });
    if (numStrs[0].equals("0")) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numStrs.length; i++) {
      sb.append(numStrs[i]);
    }
    if (sb.length() == 0) {
      sb.append("0");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Q179 q = new Q179();
    int[][] cases = {
        // { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 },
        // { 121, 12 },
        // { 3, 30, 34, 5, 9 },
        // { 133, 13300 },
        // { 128, 12 },
        // { 0, 0 },
        // { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247 },
        // { 4704, 6306, 9385, 7536, 3462, 4798, 5422, 5529, 8070, 6241,
        // 9094, 7846, 663, 6221, 216, 6758, 8353,
        // 3650, 3836, 8183, 3516, 5909, 6744, 1548, 5712, 2281, 3664,
        // 7100, 6698, 7321, 4980, 8937, 3163,
        // 5784, 3298, 9890, 1090, 7605, 1380, 1147, 1495, 3699, 9448,
        // 5208, 9456, 3846, 3567, 6856, 2000,
        // 3575, 7205, 2697, 5972, 7471, 1763, 1143, 1417, 6038, 2313,
        // 6554, 9026, 8107, 9827, 7982, 9685,
        // 3905, 8939, 1048, 282, 7423, 6327, 2970, 4453, 5460, 3399,
        // 9533, 914, 3932, 192, 3084, 6806,
        // 273, 4283, 2060, 5682, 2, 2362, 4812, 7032, 810, 2465, 6511,
        // 213, 2362, 3021, 2745, 3636, 6265,
        // 1518, 8398 },
        {9051, 5526, 2264, 5041, 1630, 5906, 6787, 8382, 4662, 4532, 6804, 4710, 4542, 2116, 7219,
            8701, 8308,
            957, 8775, 4822, 396, 8995, 8597, 2304, 8902, 830, 8591, 5828, 9642, 7100, 3976, 5565,
            5490,
            1613, 5731, 8052, 8985, 2623, 6325, 3723, 5224, 8274, 4787, 6310, 3393, 78, 3288, 7584,
            7440,
            5752, 351, 4555, 7265, 9959, 3866, 9854, 2709, 5817, 7272, 43, 1014, 7527, 3946, 4289,
            1272,
            5213, 710, 1603, 2436, 8823, 5228, 2581, 771, 3700, 2109, 5638, 3402, 3910, 871, 5441,
            6861,
            9556, 1089, 4088, 2788, 9632, 6822, 6145, 5137, 236, 683, 2869, 9525, 8161, 8374, 2439,
            6028,
            7813, 6406, 7519}};

    String output = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048";
    String expected = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048";
    for (int[] c : cases) {
      System.out.println(q.largestNumber(c));
    }
    if (output.length() != expected.length()) {
      System.out.println("Length not equal");
    }
    for (int i = 0; i < output.length(); i++) {
      if (output.charAt(i) != expected.charAt(i)) {
        System.out.println("Char not the same at position: " + i + " - output: " + output.charAt(i)
            + ", expected: " + expected.charAt(i));
      }
    }
  }
  // 837483083088274
  // 837483088308274
}
