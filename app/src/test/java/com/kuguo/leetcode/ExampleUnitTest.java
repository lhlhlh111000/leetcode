package com.kuguo.leetcode;

import com.kuguo.leetcode.easy.EasyUtil;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
}