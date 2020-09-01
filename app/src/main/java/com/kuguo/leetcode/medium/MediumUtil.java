package com.kuguo.leetcode.medium;

import com.kuguo.leetcode.easy.ListNode;

/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author cqt
 * @version 2020/9/1
 */
class MediumUtil {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();

        if(null == l1 && null == l2) {
            return null;
        }

        if(null == l1) {
            l1 = new ListNode(0);
        }
        if(null == l2) {
            l2 = new ListNode(0);
        }

        ans.val = l1.val + l2.val;
        boolean isNeedNext = false;
        if(ans.val >= 10) {
            ans.val = ans.val%10;
            isNeedNext = true;
        }

        if(isNeedNext) {
            if(null == l1.next && null == l2.next) {
                l1.next = new ListNode(1);
            }else if(null != l1.next) {
                l1.next.val += 1;
            }else {
                l2.next.val += 1;
            }
        }
        ans.next = addTwoNumbers(l1.next, l2.next);

        return ans;
    }
}