package com.leetcode.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mengchaowang on 7/1/17.

 You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

 Design a log storage system to implement the following functions:

 void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.


 int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

 Example 1:
 put(1, "2017:01:01:23:59:59");
 put(2, "2017:01:01:22:59:59");
 put(3, "2016:01:01:00:00:00");
 retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
 retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.

 Note:
 There will be at most 300 operations of Put or Retrieve.
 Year ranges from [2000,2017]. Hour ranges from [00,23].
 Output for Retrieve has no order required.

 */
public class Q635 {

  List<String[]> logs;

  public Q635() {
    logs = new ArrayList<>();
  }

  public void put(int id, String timestamp) {
    logs.add(new String[]{timestamp, "" + id});

  }

  public List<Integer> retrieve(String s, String e, String gra) {
    String[] boundries = formBoundries(gra, s, e);
    List<Integer> re = new ArrayList<>();
    logs.sort(Comparator.comparing(o -> o[0]));
    for (int i = 0; i < logs.size(); i++) {
      String[] current = logs.get(i);
      if (boundries[0].compareTo(current[0]) <= 0 && boundries[1].compareTo(current[0]) >= 0) {
        re.add(Integer.parseInt(current[1]));
      }
      if (boundries[1].compareTo(current[0]) < 0) {
        break;
      }
    }
    return re;
  }

  private String[] formBoundries(String gra, String s, String e) {
    switch (gra) {
      case "Year":
        return new String[]{s.substring(0, 5) + "00:00:00:00:00",
            e.substring(0, 5) + "12:31:23:59:59"};
      case "Month":
        return new String[]{s.substring(0, 8) + "00:00:00:00",
            e.substring(0, 8) + "31:23:59:59"};
      case "Day":
        return new String[]{s.substring(0, 11) + "00:00:00",
            e.substring(0, 11) + "23:59:59"};
      case "Hour":
        return new String[]{s.substring(0, 14) + "00:00",
            e.substring(0, 14) + "59:59"};
      case "Minute":
        return new String[]{s.substring(0, 17) + "00",
            e.substring(0, 17) + "59"};
      default:
        return new String[]{s, e};
    }
  }
}
