package com.leetcode;

/**
 * 
  
 Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q526 {
	int totalCount = 0;

	public int countArrangement(int N) {
		int[] array = new int[N];
		for (int i = 1; i <= N; i++) {
			array[i - 1] = i;
		}
		int pos = 1;
		for (int i = 1; i <= N; i++) {
			if (i % pos == 0 || pos % i == 0) {
				array[i - 1] = -1;
				loopThrough(array, pos + 1, N);
				array[i - 1] = i;
			}
		}
		return totalCount;
	}

	private void loopThrough(int[] array, int pos, final int N) {
		if (pos > N) {
			totalCount++;
		}
		for (int i = 1; i <= N; i++) {
			if (array[i - 1] != -1 && (array[i - 1] % pos == 0 || pos % array[i - 1] == 0)) {
				array[i - 1] = -1;
				loopThrough(array, pos + 1, N);
				array[i - 1] = i;
			}
		}
	}
}
