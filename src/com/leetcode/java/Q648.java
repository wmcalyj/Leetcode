package com.leetcode.java;
// @formatter:off

import java.util.List; /**
 * Created by mengchaowang on 7/22/17.

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000

 */

// @formatter:on
public class Q648 {

  public String replaceWords(List<String> dict, String sentence) {
    dict.sort((o1, o2) -> {
      if (o1.equals(o2)) {
        return o1.length() - o2.length();
      } else {
        return o1.compareTo(o2);
      }
    });

    String[] strs = sentence.split("\\s+");
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < dict.size(); j++) {
        if (strs[i].startsWith(dict.get(j))) {
          strs[i] = dict.get(j);
          break;
        }
      }
    }
    StringBuilder re = new StringBuilder();
    for (int i = 0; i < strs.length - 1; i++) {
      re.append(strs[i]).append(" ");
    }
    re.append(strs[strs.length - 1]);
    return re.toString();

  }
}
