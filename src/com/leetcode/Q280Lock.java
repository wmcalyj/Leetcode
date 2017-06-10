package com.leetcode;

/**
 * Given an unsorted array nums, reorder it in-place such that
 *  nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *  For example, given nums = [3, 5, 2, 1, 6, 4], 
 *  one possible answer is [1, 6, 2, 5, 3, 4].
 *  
 * @author mengchaowang
 *
 */

// Solution:
// https://leetcode.com/articles/wiggle-sort/#approach-1-sorting-accepted

public class Q280Lock {
	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				// Smallest
				getSmallest(nums, i);
			} else {
				getLargest(nums, i);
			}
		}
	}

	private void getLargest(int[] nums, int index) {
		int maxVal = nums[index], maxIndex = index;
		for (int i = index; i < nums.length; i++) {
			if (nums[i] > maxVal) {
				maxVal = nums[i];
				maxIndex = i;
			}
		}
		swap(nums, index, maxIndex);

	}

	private void getSmallest(int[] nums, int index) {
		int minVal = nums[index], minIndex = index;
		for (int i = index; i < nums.length; i++) {
			if (nums[i] < minVal) {
				minVal = nums[i];
				minIndex = i;
			}
		}
		swap(nums, index, minIndex);

	}

	private void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}
}

/**
 * 

Approach #1 (Sorting) [Accepted]

The obvious solution is to just sort the array first, then swap elements pair-wise starting from the second element. For example:

   [1, 2, 3, 4, 5, 6]
       ↑  ↑  ↑  ↑
       swap  swap

=> [1, 3, 2, 5, 4, 6]
public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length - 1; i += 2) {
        swap(nums, i, i + 1);
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
Complexity analysis

Time complexity : O(n \log n)O(nlogn). The entire algorithm is dominated by the sorting step, which costs O(n \log n)O(nlogn) time to sort nn elements.

Space complexity : O(1)O(1). Space depends on the sorting implementation which, usually, costs O(1)O(1) auxiliary space if heapsort is used.




Intuitively, we should be able to reorder it in one-pass. As we iterate through the array, we compare the current element to its next element and if the order is incorrect, we swap them.

public void wiggleSort(int[] nums) {
    boolean less = true;
    for (int i = 0; i < nums.length - 1; i++) {
        if (less) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        } else {
            if (nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
        less = !less;
    }
}
We could shorten the code further by compacting the condition to a single line. Also observe the boolean value of less actually depends on whether the index is even or odd.

public void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
        if (((i % 2 == 0) && nums[i] > nums[i + 1])
                || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
            swap(nums, i, i + 1);
        }
    }
}
Here is another amazing solution by @StefanPochmann who came up with originally here.

public void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
        if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
            swap(nums, i, i + 1);
        }
    }
}
Complexity analysis

Time complexity : O(n)O(n). In the worst case we swap at most n \over 2
​2
​
​n
​​  times. An example input is [2,1,3,1,4,1].

Space complexity : O(1)O(1).

 */
