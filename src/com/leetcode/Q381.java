package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/**
 * 
 * 
  
 Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom(); 
  
 * 
 * @author mengchaowang
 *
 */
public class Q381 {
	/** Initialize your data structure here. */
	Map<Integer, Stack<Integer>> valToIdx = new HashMap<>();
	List<Integer> vals = new ArrayList<>();

	public Q381() {

	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		int idx = vals.size();
		vals.add(val);
		boolean newVal = true;

		if (valToIdx.containsKey(val)) {
			newVal = false;
		}
		Stack<Integer> idxes = valToIdx.containsKey(val) ? valToIdx.get(val) : new Stack<Integer>();
		idxes.push(idx);
		valToIdx.put(val, idxes);
		return newVal;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if (!valToIdx.containsKey(val)) {
			return false;
		}
		Stack<Integer> idxes = valToIdx.get(val);
		int idx = idxes.pop();
		if (idxes.isEmpty()) {
			valToIdx.remove(val);
		}
		vals.set(idx, vals.get(0));
		vals.remove(0);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		Random r = new Random();
		return vals.get(r.nextInt(vals.size()));
	}
}
