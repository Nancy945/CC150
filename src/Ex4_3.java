
public class Ex4_3 {
     /** 高度最小的BST
	 * @param vals
	 * @return
      */
    private int buildMinimalBST(int[] vals){
	//return (int)Math.ceil(Math.log10(vals.length)/Math.log10(2));
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
