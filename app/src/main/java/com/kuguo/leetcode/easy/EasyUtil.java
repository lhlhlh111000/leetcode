package com.kuguo.leetcode.easy;

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
}
