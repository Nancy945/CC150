/**
 * Created by 余屌丝 on 2016/11/18.
 * 题目描述
 * 有两个用链表表示的整数，每个结点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 */

import java.util.*;


public class Ex2_5 {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode ret = null;

        ListNode pos = null;
        int carried = 0; //进位

        while (a != null || b != null) {

            int valA = 0;
            if (a != null) {
                valA = a.val;
                a = a.next;
            }
            int valB = 0;
            if (b != null) {
                valB = b.val;
                b = b.next;
            }

            int result = valA + valB + carried;
            int val = result % 10;//个位
            carried = result / 10;//进位
            ListNode newNode = new ListNode(val);

            if (pos == null) {
                pos = newNode;
                ret = pos;//保存头节点
            } else {
                pos.next = newNode;
                pos = pos.next;
            }
        }

        //最后一位进位
        if (carried != 0) {
            //移到尾部,移动两个
            pos.next = new ListNode(carried);
        }

        return ret;
    }

    //思路一样，更简洁
    public ListNode plusAB2(ListNode a, ListNode b) {
        // write code here
        ListNode resultHead = new ListNode(-1);
        ListNode resultCurrent = resultHead;
        int addToNextDigit = 0;
        while (a != null || b != null || addToNextDigit != 0) {
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;

            int sum = aVal + bVal + addToNextDigit;
            int nodeDigit = sum % 10;
            addToNextDigit = sum / 10;

            resultCurrent.next = new ListNode(nodeDigit);
            resultCurrent = resultCurrent.next;

            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return resultHead.next;
    }


    static void print(ListNode a) {
        StringBuilder sb = new StringBuilder();
        while (a != null) {
            sb.append(a.val + " ");
            a = a.next;

        }
        System.out.println(sb);
        System.out.println();
    }

    public static void main(String[] args) {
        Ex2_5 obj = new Ex2_5();
        ListNode a = obj.new ListNode(0);
        ListNode b = obj.new ListNode(0);
        a.next = obj.new ListNode(1);
        a.next.next = obj.new ListNode(1);

        print(obj.plusAB(a, b));

    }

}
