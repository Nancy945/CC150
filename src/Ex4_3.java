/**
对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
*/

	/**
	 * 高度最小的BST
	 * @param vals
	 * @return
	 */
public class EX4_3{
	private static int buildMinimalBST(int[] vals){
//		return (int)Math.ceil(Math.log10(vals.length)/Math.log10(2));
		
		if (vals.length < 1)
			return 0;
		int height = 1;
		int size = vals.length;
		while (size > 1) {
			height++;
			size >>= 1;
		}
		return height;
	}
	
}