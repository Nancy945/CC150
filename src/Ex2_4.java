/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *  给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Ex2_4 {

    //ListNode类由题目提供
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode t = pHead,sma = new ListNode(0),big = new ListNode(0),s = sma,b = big;
        while (t.next != null) {
            if (t.val < x) {
                s.next = new ListNode(t.val);
                s = s.next;
            } else {
                b.next = new ListNode(t.val);
                b = b.next;
            }
            t = t.next;
        }
        if (t.val < x) {
            s.next = new ListNode(t.val);
            s = s.next;
        } else {
            b.next = new ListNode(t.val);
            b = b.next;
        }
        s.next = big.next;
        return sma.next;
    }
}
