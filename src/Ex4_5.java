/**
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 * Created by Nancy on 2016/11/19.
 */
public class Ex4_5 {


    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean checkBST(TreeNode root) {
        return checkBST(root, new IntNum(Integer.MIN_VALUE));
//        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private class IntNum {
        int val;

        IntNum(int val) {
            this.val = val;
        }
    }

    /**
     * <方法1>
     首先我们想到的是二叉树中序遍历后的结果是有序的，根据这个结果，我们可以中序遍历二叉树，
     并把遍历结果存放在一个数组里面，然后判断这个数组大小是否是有序数组，如果是有序数组，则是二叉查找树，否则就不是。
     这个方法的时间复杂度是O(N)，但是空间复杂度比较高，需要浪费O（N）的存储空间。
     */

    /**
     * <方法2>
     * 其实在<方法1>的基础上，我们可以在中序遍历的同时，比较大小，每次记录下上次遍历过的元素的值，如果当前元素的值大于上次遍历元素的值，则接着遍历，否则返回false，因为这个记录是一个址传递，所以需要用到引用形参进行传递。
     * 这个方法的时间复杂度与<方法1>的时间复杂度相同，只是空间复杂度只需要一个元素O(1)。
     */
    private boolean checkBST(TreeNode root, IntNum last) {
        if (root == null)
            return true;
        if (!checkBST(root.left, last))
            return false;
        if (root.val < last.val)
            return false;
        //直接这样写是错误的，因为last始终是这个函数传进来时候的last，并没有改变
//        last = root.val;
        //要这样写才行:
        last.val = root.val;

        if (!checkBST(root.right, last))
            return false;
        return true;
    }

    /**
     * <方法3>
     * 可以根据二叉查找树的定义来判断，二叉树的定义，所有左子树的节点小于根节点，所有右子树的节点大于根节点，
     * 并且左右子树也是二叉查找树。所以在递归的过程中，
     * 我们只需要传递两个参数（当前根节点对应的二叉树的所有节点的最大值和最小值），
     * 同时不断的更新这两个参数，如果当前节点的值不在这两个数范围中，则直接返回false，否则接着递归便可。
     */
    private boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);

    }
}
