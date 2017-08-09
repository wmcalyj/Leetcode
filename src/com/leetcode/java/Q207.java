//package com.leetcode;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.Stack;
//
///**
// *
// *
//
// There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//
//click to show more hints.
//
//Hints:
//This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
//Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
//Topological sort could also be done via BFS.
//
// *
// * @author mengchaowang
// *
// */
//public class Q207 {
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		int a = 1;
//		if (System.out.println("b") == null) {
//			System.out.println("a");
//		} else {
//			System.out.println("b");
//		}
//		if (prerequisites.length == 0) {
//			return true;
//		}
//		Set<Integer> visited = new HashSet<Integer>();
//		Stack<Integer> stack = new Stack<Integer>();
//		for (int k = 0; k < numCourses; k++) {
//			if (visited.contains(k))
//				continue;
//			int[] vertex = new int[numCourses];
//			for (int i = 0; i < prerequisites.length; i++) {
//				if (prerequisites[i][0] == -1 || prerequisites[i][1] == -1) {
//					// This edge has been deleted
//					continue;
//				}
//				// If there is prerequisites, not good for start
//				vertex[prerequisites[i][1]] = -1;
//				prerequisites[i][0] = -1;
//				prerequisites[i][1] = -1;
//			}
//
//			for (int i = 0; i < numCourses; i++) {
//				if (vertex[i] == 0) {
//					stack.push(i);
//					visited.add(i);
//				}
//			}
//		}
//		return visited.size() == numCourses;
//	}
//
//	public static void main(String[] args) {
//		Q207 q = new Q207();
//		int[] ks = { 2, 2, 3, 2 };
//		int[][][] prerequisites = { { { 1, 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 2 }, { 2, 1 } },
//				{ { 0, 1 } } };
//		for (int i = 0; i < prerequisites.length; i++) {
//			System.out.println(q.canFinish(ks[i], prerequisites[i]));
//		}
//	}
//}
