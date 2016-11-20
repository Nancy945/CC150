/*
编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
*/

import java.util.*;
 
/*
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}*/
public class EX2_4 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null)
            return pHead;
             
        ListNode sma = new ListNode(0),big = new ListNode(0),s = sma,b = big;
         
        while (pHead.next != null) {
            if (pHead.val < x) {
                s.next = new ListNode(pHead.val);
                s = s.next;
            } else {
                b.next = new ListNode(pHead.val);
                b = b.next;
            }
            pHead = pHead.next;
        }
        if (pHead.val < x) {
            s.next = new ListNode(pHead.val);
            s = s.next;
        } else {
            b.next = new ListNode(pHead.val);
            b = b.next;
        }
        s.next = big.next;
        return sma.next;
    }
}