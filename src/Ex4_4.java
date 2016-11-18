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

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        return null;
    }
}
