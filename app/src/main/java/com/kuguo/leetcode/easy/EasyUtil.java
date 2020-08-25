package com.kuguo.leetcode.easy;

import com.kuguo.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    public static int removeDuplicates(int[] nums) {
        if(null == nums || nums.length <= 0) {
            return 0;
        }

        int i=0;
        for(int j=1; j<nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static int removeElement(int[] nums, int val) {
        if(null == nums || 0 == nums.length) {
            return 0;
        }

        int j=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static int strStr(String haystack, String needle) {
        if(null == needle || needle.length() <= 0) {
            return 0;
        }

        int hLength = haystack.length();
        int nLength = needle.length();
        for(int i=0; i<hLength-nLength+1; i++) {
            if(haystack.substring(i, i+nLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length <= 0) {
            return 0;
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    public static String countAndSay(int n) {
        String start = "1";
        for(int i=1; i<n; i++) {
            start = a(start);
        }

        return start;
    }

    private static String a(String str) {
        String result = "";
        int count = 1;
        String s = String.valueOf(str.charAt(0));
        for(int i=1; i<str.length(); i++) {
            if(s.equals(String.valueOf(str.charAt(i)))) {
                count++;
            }else {
                result = result + count + s;
                count = 1;
                s = String.valueOf(str.charAt(i));
            }
        }

        result = result + count + s;
        return result;
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num : nums) {
            if(sum + num > num) {
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static int lengthOfLastWord(String s) {
        if(null == s || s.length() <= 0) {
            return 0;
        }

        String[] words = s.split(" ");
        if(words.length <= 0) {
            return 0;
        }

        return words[words.length - 1].length();
    }

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length - 1; i>=0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static String addBinary(String a, String b) {
        if(null == a || a.length() <= 0) {
            return b;
        }
        if(null == b || b.length() <= 0) {
            return a;
        }

        int diff = a.length() - b.length();
        if(diff > 0) {
            for(int i=0; i<Math.abs(diff); i++) {
                b = "0" + b;
            }
        }else {
            for(int i=0; i<Math.abs(diff); i++) {
                a = "0" + a;
            }
        }

        int length = a.length();
        int i = length - 1;
        boolean isAdd = false;
        String result = "";
        while (i >= 0) {
            int aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bInt = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = aInt + bInt;
            if(isAdd) {
                sum += 1;
                isAdd = false;
            }
            if(sum >= 2) {
                isAdd = true;
            }
            result = sum%2 + result;
            i--;
        }

        if(isAdd) {
            result = "1" + result;
        }
        return result;
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1;
        long right = x/2;
        while (left < right){
            //注意这一行代码
            long mid = (right + left)/2 + 1;
            if(mid > x/mid) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return(int) left;
    }

    public static int climbStairs(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i=2; i<=n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }

        return ans[n];
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ans = head;
        while (null != ans && null != ans.next) {
            if(ans.val == ans.next.val) {
                ans.next = ans.next.next;
            }else {
                ans = ans.next;
            }
        }

        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q) {
            return true;
        }
        if(null == p || null == q) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(null == root) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private static boolean isSame(TreeNode p, TreeNode q) {
        if(null == p && null == q) {
            return true;
        }

        if(null == p || null == q) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }

    public static int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();//使用有序列表
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(0, list);
        }
        return ans;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums || nums.length <= 0) {
            return null;
        }

        int mid = nums.length/2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        ans.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return ans;
    }

    public static boolean isBalanced(TreeNode root) {
        if(null == root) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }

        if(null == root.left && null == root.right) {
            return 1;
        }

        int ml = minDepth(root.left);
        int mr = minDepth(root.right);

        if(null == root.right || null == root.left) {
            return ml + mr + 1;
        }

        return Math.min(ml, mr) + 1;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(null == root) {
            return false;
        }
        if(sum == root.val
                && null == root.left && null == root.right) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public static List<List<Integer>> generate(int numRows) {
        if(0 == numRows) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> items = new ArrayList<>();
            for(int j=0; j<i; j++) {
                if(j <= 0 || j >= i - 1) {
                    items.add(1);
                }else {
                    items.add(ans.get(i - 2).get(j - 1) + ans.get(i -2).get(j));
                }
            }
            ans.add(items);
        }

        return ans;
    }

    public static List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                ans = Math.max(prices[j] - prices[i], ans);
            }
        }

        return ans;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
