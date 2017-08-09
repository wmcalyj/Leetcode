package com.leetcode.java;

import java.util.Stack;

/**
 *

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 * @author mengchaowang
 *
 */
public class Q150 {

  public int evalRPN(String[] tokens) {
    if (tokens.length == 0) {
      return 0;
    }
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      switch (token) {
        case "+": {
          int second = Integer.valueOf(stack.pop());
          int first = Integer.valueOf(stack.pop());
          stack.push("" + (first + second));
          break;
        }
        case "-": {
          int second = Integer.valueOf(stack.pop());
          int first = Integer.valueOf(stack.pop());
          stack.push("" + (first - second));
          break;
        }
        case "*": {
          int second = Integer.valueOf(stack.pop());
          int first = Integer.valueOf(stack.pop());
          stack.push("" + (first * second));
          break;
        }
        case "/": {
          int second = Integer.valueOf(stack.pop());
          int first = Integer.valueOf(stack.pop());
          stack.push("" + (first / second));
          break;
        }
        default:
          stack.push(tokens[i]);
      }
    }
    return Integer.valueOf(stack.pop());
  }
}
