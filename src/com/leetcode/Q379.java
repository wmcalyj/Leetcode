package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 
  
 Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2); 
  
 * 
 * @author mengchaowang
 *
 */

// 646 ms
public class Q379 {

	Queue<Integer> currentAvailable;
	Set<Integer> used;
	int max;
	int assignedSize;
	int current;

	/** Initialize your data structure here
	@param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public Q379(int maxNumbers) {
		currentAvailable = new LinkedList<Integer>();
		used = new HashSet<Integer>();
		this.max = maxNumbers;
		this.assignedSize = 0;
		this.current = 0;
	}

	/** Provide a number which is not assigned to anyone.
	@return - Return an available number. Return -1 if none is available. */
	public int get() {
		if (assignedSize >= max) {
			return -1;
		}
		assignedSize++;
		if (currentAvailable.isEmpty()) {
			while (used.contains(current)) {
				current++;
				if (current >= max) {
					current = 0;
				}
			}
			used.add(current);
			return current;
		} else {
			Integer newNumber = currentAvailable.poll();
			used.add(newNumber);
			return newNumber;
		}
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return !used.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (used.contains(number)) {
			used.remove(number);
			currentAvailable.offer(number);
			assignedSize--;
		}
	}

	public static void main(String[] args) {
		Q379 q = new Q379(3);
		System.out.println(q.check(2));
		System.out.println(q.get());
		System.out.println(q.get());
	}
}
