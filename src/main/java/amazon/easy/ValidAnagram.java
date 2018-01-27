package amazon.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/27.
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {


        int[] alphabets = new int[26];

        for(int i=0;i<s.length();i++){
            alphabets[s.charAt(i)-'a']++;
        }

        for(int j=0;j<t.length();j++){
            alphabets[t.charAt(j)-'a']--;
        }

        for(int i=0;i<alphabets.length;i++){
            if(alphabets[i]!=0){
                return false;
            }
        }
        return true;







    }

}
