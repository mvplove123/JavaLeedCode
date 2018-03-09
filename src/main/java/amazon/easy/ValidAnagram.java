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
        //对子串每一个字符进行次数累加计数
        for(int i=0;i<s.length();i++){
            alphabets[s.charAt(i)-'a']++;
        }
        //对目标串进行次数累减计数
        for(int j=0;j<t.length();j++){
            alphabets[t.charAt(j)-'a']--;
        }
        //循环，判断是否有非0次的，如果有则不包含，没有则包含
        for(int i=0;i<alphabets.length;i++){
            if(alphabets[i]!=0){
                return false;
            }
        }
        return true;







    }

}
