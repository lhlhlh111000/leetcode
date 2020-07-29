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
}
