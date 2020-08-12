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

    @Test
    public void searchInsert() {
        Assert.assertEquals(EasyUtil.searchInsert(new int[]{1,3,5,6}, 5), 2);
    }

    @Test
    public void countAndSay() {
        Assert.assertEquals(EasyUtil.countAndSay(1), "1");
        Assert.assertEquals(EasyUtil.countAndSay(2), "11");
        Assert.assertEquals(EasyUtil.countAndSay(3), "21");
        Assert.assertEquals(EasyUtil.countAndSay(4), "1211");
        Assert.assertEquals(EasyUtil.countAndSay(5), "111221");
    }

    @Test
    public void maxSubArray() {
        Assert.assertEquals(EasyUtil.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}),  6);
    }

    @Test
    public void lengthOfLastWord() {
        Assert.assertEquals(EasyUtil.lengthOfLastWord("Hello World"), 5);
    }

    @Test
    public void plusOne() {
        Assert.assertArrayEquals(EasyUtil.plusOne(new int[]{1,2,3}), new int[]{1,2,4});
        Assert.assertArrayEquals(EasyUtil.plusOne(new int[]{9,9,9}), new int[]{1,0,0,0});
        Assert.assertArrayEquals(EasyUtil.plusOne(new int[]{7,3,9}), new int[]{7,4,0});
    }

    @Test
    public void addBinary() {
        Assert.assertEquals(EasyUtil.addBinary("11", "1"), "100");
        Assert.assertEquals(EasyUtil.addBinary("1010", "1011"), "10101");
    }

    @Test
    public void mySqrt() {
        Assert.assertEquals(EasyUtil.mySqrt(8), 2);
        Assert.assertEquals(EasyUtil.mySqrt(5), 2);
    }

    @Test
    public void climbStairs() {
        Assert.assertEquals(EasyUtil.climbStairs(3), 3);
    }
}