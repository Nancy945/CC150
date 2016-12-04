import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 余屌丝 on 2016/11/18.
 * <p>
 * 题目描述
 * <p>
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
 * 请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */

public class Ex4_4 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static void print(ListNode node) {
        ListNode pos = node;
        StringBuilder string = new StringBuilder();
        while (pos != null) {
            string.append(pos.val + "");
            pos = pos.next;
        }
        System.out.println(string);
    }

    public static void depthFirst(TreeNode node, int depIndex, int dep, ArrayList list) {

        depIndex++;

        if (depIndex == dep) {
            list.add(node.val);
        }

        if (node.left != null) {
            depthFirst(node.left, depIndex, dep, list);
        }

        if (node.right != null) {
            depthFirst(node.right, depIndex, dep, list);
        }
    }

    public static LinkedList<TreeNode> breadthSearch(TreeNode tree, int dep) {
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(tree);

        int depIndex = 1;
        while (current.size() > 0 && dep != depIndex) {
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();//换层

            for (TreeNode node : parents) {
                if (node.left != null)
                    current.add(node.left);

                if (node.right != null) {
                    current.add(node.right);
                }
            }

            depIndex++;
        }


        return current;

    }

    public static ListNode getTreeLevel2(TreeNode root, int dep) {
        LinkedList<TreeNode> ret = breadthSearch(root, dep);
        ListNode pos = null;
        ListNode head = null;

        for (TreeNode node : ret) {
            if (pos == null) {
                pos = new ListNode(node.val);
                head = pos;
            } else {
                pos.next = new ListNode(node.val);
                pos = pos.next;
            }
        }

        return head;
    }


    public static ListNode getTreeLevel(TreeNode root, int dep) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        depthFirst(root, 0, dep, list);
        ListNode pos = null;
        ListNode head = null;

        for (Integer i : list) {
            if (pos == null) {
                pos = new ListNode(i);
                head = pos;
            } else {
                pos.next = new ListNode(i);
                pos = pos.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(2);

        ListNode node = getTreeLevel2(tree, 1);
        print(node);
    }

}
