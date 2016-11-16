/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * Created by Nancy on 2016/11/16.
 */
public class Ex2_3 {


    //ListNode类由题目提供
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //因为没有办法访问上一个节点，所以之间将本节点内容改为next的内容,再让next指向next的next。
    public class Remove {
        public boolean removeNode(ListNode pNode) {
            // write code here
            if (pNode.next == null) {
                return false;
            } else {
                pNode.val = pNode.next.val;
                pNode.next = pNode.next.next;
                return true;
            }

        }
    }
}
