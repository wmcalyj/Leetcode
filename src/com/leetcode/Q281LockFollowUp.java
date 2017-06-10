package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q281LockFollowUp {
	List<Integer> list;
	int current = 0;

	public Q281LockFollowUp(List<Integer>... vs) {
		list = new ArrayList<Integer>();
		int maxLength = 0;
		int count = 0;
		while (true) {
			for (int i = 0; i < vs.length; i++) {
				if (count < vs[i].size()) {
					if (vs[i].size() > maxLength) {
						maxLength = vs[i].size();
					}
					list.add(vs[i].get(count));
				}
			}
			count++;
			if (count >= maxLength) {
				break;
			}
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

	public static void main(String[] args) {
		Integer[] a1 = { 1, 2, 3 };
		Integer[] a2 = { 4, 5, 6, 7 };
		Integer[] a3 = { 8, 9 };
		Q281LockFollowUp q = new Q281LockFollowUp(Arrays.asList(a1), Arrays.asList(a2), Arrays.asList(a3));
		while (q.hasNext()) {
			System.out.println(q.next());
		}
	}
}
