package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q281Lock {
	List<Integer> list;
	int current = 0;

	public Q281Lock(List<Integer> v1, List<Integer> v2) {
		list = new ArrayList<Integer>();
		int i = 0;
		while (true) {
			if (i < v1.size() || i < v2.size()) {
				if (i < v1.size()) {
					list.add(v1.get(i));
				}
				if (i < v2.size()) {
					list.add(v2.get(i));
				}
			} else {
				break;
			}
			i++;
		}
	}

	public int next() {
		return list.get(current++);
	}

	public boolean hasNext() {
		if (current < list.size()) {
			return true;
		}
		return false;
	}
}
