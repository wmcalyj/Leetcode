package com.leetcode;

import java.util.Stack;

/**
 * 
  
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Show Company Tags
Show Tags
Show Similar Problems
 
  
 * 
 * @author mengchaowang
 *
 */
public class Q020 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push('(');
				break;
			case '[':
				stack.push('[');
				break;
			case '{':
				stack.push('{');
				break;
			case ')':
				if (stack.isEmpty() || '(' != stack.pop()) {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || '[' != stack.pop()) {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || '{' != stack.pop()) {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}
}
