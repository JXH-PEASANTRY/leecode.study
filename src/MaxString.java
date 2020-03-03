import java.util.*;

/**
 * @author jiangxinhua
 * @date 2020/3/2
 */
public class MaxString {
//  给定字符串"abcabcbb"，最长不重复子串为"abc"，长度为3；
//  给定字符串"bbbbb"，最长不重复子串为"b"，长度为1；
//  给定字符串"pwwkew"，最长不重复子串为"wke"或"kew"，长度为3，注意子串必须要连续，"pwke"不符合要求。

  public static void main(String[] args) {
    String star = "pwwkewA";
    three(star);
  }

  public static boolean isUnique(String string, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      Character character = string.charAt(i);
      if (set.contains(character)) {
        return false;
      }
      set.add(character);
    }
    return true;
  }

  public static void two(String str) {
    int len = str.length();
    Map<Character, Integer> map = new HashMap<>();
    int maxlen = 0;
    for (int j=0,i=0;j<len;j++){
      if(map.containsKey(str.charAt(j))){
        i = Math.max(map.get(str.charAt(j)), i);
      }
      maxlen = Math.max(maxlen, j - i + 1);
      map.put(str.charAt(j), j + 1);
    }

    System.out.println(maxlen);
  }

  //错误
  public static void three(String s) {
    int start = 0, end = 0, maxLen=0,len=s.length();
    Set<Character> set = new HashSet<>();
    while (start<len && end<len){
      if (set.contains(s.charAt(end))){
        set.remove(s.charAt(start));
        start = end;
      }
      set.add(s.charAt(end));
      maxLen = Math.max(maxLen, (end-start)+1);
      end++;
    }
    maxLen = Math.max(maxLen, (end-start)+1);
    System.out.println(maxLen);

  }


}
