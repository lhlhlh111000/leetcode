package com.kuguo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author cqt
 * @version 2020/7/29
 */
public class EasyUtil {

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int tmp = x;
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }

        return (int)n == tmp;
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            String value = String.valueOf(chars[i]);
            if("I".equals(value)) {
                nums[i] = 1;
            }else if("V".equals(value)) {
                nums[i] = 5;
            }else if("X".equals(value)) {
                nums[i] = 10;
            }else if("L".equals(value)) {
                nums[i] = 50;
            }else if("C".equals(value)) {
                nums[i] = 100;
            }else if("D".equals(value)) {
                nums[i] = 500;
            }else if("M".equals(value)) {
                nums[i] = 1000;
            }
        }
        int result = 0;
        int index = 0;
        while (index < nums.length) {
            int first = nums[index];
            int next = 0;
            if(index + 1 < nums.length) {
                next = nums[index + 1];
            }
            if(next > first) {
                result += next - first;
                index += 2;
            }else {
                result += first;
                index++;
            }
        }

        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length <= 0) {
            return "";
        }

        String ans = strs[0];
        for(int i=1; i<strs.length; i++) {
            int j=0;
            for(; j<ans.length() && j<strs[i].length(); j++) {
                if(ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

    public static boolean isValid(String s) {
        if(null == s || s.isEmpty()) {
            return true;
        }

        Map<String, String> dict = new HashMap<>();
        dict.put("{", "}");
        dict.put("(", ")");
        dict.put("[", "]");
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i, i+1);
            if("{".equals(str) || "(".equals(str) || "[".equals(str)) {
                stack.push(str);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                String pre = stack.pop();
                if(!str.equals(dict.get(pre))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
