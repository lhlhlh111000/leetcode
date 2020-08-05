package com.kuguo.leetcode;

import com.kuguo.leetcode.easy.EasyUtil;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(EasyUtil.isPalindrome(121));
    }

    @Test
    public void romanToInt() {
        Assert.assertEquals(EasyUtil.romanToInt("III"), 3);
        Assert.assertEquals(EasyUtil.romanToInt("IV"), 4);
        Assert.assertEquals(EasyUtil.romanToInt("IX"), 9);
        Assert.assertEquals(EasyUtil.romanToInt("LVIII"), 58);
        Assert.assertEquals(EasyUtil.romanToInt("MCMXCIV"), 1994);
    }

    @Test
    public void longestCommonPrefix() {
        Assert.assertEquals(EasyUtil.longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl");
    }

    @Test
    public void isValid() {
        Assert.assertTrue(EasyUtil.isValid("()"));
        Assert.assertTrue(EasyUtil.isValid("()[]{}"));
        Assert.assertFalse(EasyUtil.isValid("(]"));
        Assert.assertFalse(EasyUtil.isValid("([)]"));
        Assert.assertTrue(EasyUtil.isValid("{[]}"));
    }

    @Test
    public void mergeTwoLists() {

    }

    @Test
    public void removeDuplicates() {
        Assert.assertEquals(EasyUtil.removeDuplicates(new int[]{1,1,2}), 2);
        Assert.assertEquals(EasyUtil.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}), 5);
    }

    @Test
    public void strStr() {
        Assert.assertEquals(EasyUtil.strStr("hello", "ll"), 2);
        Assert.assertEquals(EasyUtil.strStr("aaaaa", "bba"), -1);
    }
}