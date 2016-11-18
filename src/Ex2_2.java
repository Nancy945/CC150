import java.util.HashMap;

/**
 * Created by 余屌丝 on 2016/11/18.
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Ex2_2 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //34ms 692k
    public ListNode FindKthToTail1(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode listNode = head;
        int i = 0;
        while (listNode != null) {
            map.put(i, listNode);

            listNode = listNode.next;
            i++;
        }

        return map.get(map.size() - k);
    }


    /**
     * 38ms 528k
     * 代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，
     * 到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
