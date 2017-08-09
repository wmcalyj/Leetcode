package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

 Subscribe to see which companies asked this question.

 *
 * @author mengchaowang
 *
 */
public class Q535 {

  Map<String, String> urlMap = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String hash = "" + longUrl.hashCode();
    String shortUrl = "tinyurl.com/" + hash;
    urlMap.put(shortUrl, longUrl);
    return shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return urlMap.get(shortUrl);
  }

  public static void main(String[] args) {
    Q535 q = new Q535();
    String shortUrl = q.encode("https://leetcode.com/problems/design-tinyurl");
    System.out.println(shortUrl);
    System.out.println(q.decode(shortUrl));
  }

  // Your Codec object will be instantiated and called as such:
  // Codec codec = new Codec();
  // codec.decode(codec.encode(url));
}
