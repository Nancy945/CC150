import java.util.ArrayDeque;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 * Created by Nancy on 2016/11/16.
 */
public class Ex2_7 {


    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 评价：不好，方法比较笨。
     * 想遍历一遍取得长度，然后new一个int数组，存储前一半的元素.
     * 然后从中间到最后一次把节点的值与数组中比较。
     */
    public boolean isPalindrome(ListNode pHead) {
        int[] vals;
        ListNode pTemp = pHead;
        int Length = 1;
        while (pTemp.next != null) {
            pTemp = pTemp.next;
            Length++;
        }

        vals = new int[Length / 2];

        for (int i = 0; i < Length / 2; i++) {
            vals[i] = pHead.val;
            pHead = pHead.next;
        }
        if (Length % 2 != 0) pHead = pHead.next;

        for (int i = 0; i < Length / 2; i++) {
            if (pHead.val != vals[Length / 2 - 1 - i]) {
                return false;
            } else {
                pHead = pHead.next;
            }

        }

        return true;

    }

    /**
     * 单链表可以使用快慢指针快速获得中间元素。
     */
    public boolean isPalindrome1(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        /**
         * 将链表的前半部分元素装入栈中，当快速runner
         *（移动的速度是慢速runner的两倍）
         * 到底链表尾部时，则慢速runner已经处于链表中间位置；
         * 中间：奇数是中间，偶数是向后半个
         */
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数个时，跳过中间元素
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            //如果两者不相同，则该链表不是回文串
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }


    public static void main(String[] args) {

        Ex2_7 o = new Ex2_7();
        ListNode p1 = o.new ListNode(1);
        ListNode p2 = o.new ListNode(2);
        ListNode p3 = o.new ListNode(3);
        ListNode p4 = o.new ListNode(2);
        ListNode p5 = o.new ListNode(1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        System.out.println(o.isPalindrome(p1));
    }

}
