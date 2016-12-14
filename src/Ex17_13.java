/**
 * 有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
 * 其可以用来表示二叉查找树(其中left指针表示左儿子，right指针表示右儿子)。
 * 请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
 * 给定二叉查找树的根结点指针root，请返回转换成的链表的头指针。
 */
public class Ex17_13 {
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

    private ListNode head=new ListNode(-1);
    private ListNode q=head;
    public ListNode treeToList(TreeNode root) {//中序遍历
        if(root!=null){
            treeToList(root.left);
            q.next=new ListNode(root.val);
            q=q.next;
            treeToList(root.right);
        }
        return head.next;
    }
}
