package com.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 
 
  Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();
 
  
 * @author mengchaowang
 *
 */
public class Q380 {
	Set<Integer> set;
	Integer total;
	Random r;

	public Q380() {
		set = new HashSet<Integer>();
		total = 0;
		r = new Random(System.currentTimeMillis());
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (set.add(val)) {
			total++;
			return true;
		} else {
			return false;
		}
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (set.contains(val)) {
			set.remove(val);
			total--;
			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Iterator<Integer> iter = set.iterator();
		int total = 1;
		Integer val = iter.next();
		while (iter.hasNext()) {
			int rand = r.nextInt(++total);
			if (rand == 0) {
				val = iter.next();
			} else {
				iter.next();
			}
		}
		return val;
	}

	public static void main(String[] args) {
		Q380 q = new Q380();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
		System.out.println(q.getRandom());
	}
}
