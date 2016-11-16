
/**
 * 
 * @author 余屌丝
 *  题目描述
 *	有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
 *	请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，
 *	将图像顺时针旋转90度。给定一个NxN的矩阵，和矩阵的阶数N,请返回
 *	旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 *
 */
public class Ex1_6 {
    private static int[][] transformImage(int[][] mat, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                mat[i][j] = mat[i][j] ^ mat[j][i];
                mat[j][i] = mat[i][j] ^ mat[j][i];
                mat[i][j] = mat[i][j] ^ mat[j][i];
            }
        }

        for (int i = 0; i < n/2; i++) {//先循环列
            for (int j = 0; j < n; j++) { //行
                mat[j][i] = mat[j][i] ^ mat[j][n - 1 - i];
                mat[j][n - 1 - i] = mat[j][i] ^ mat[j][n - 1 - i];
                mat[j][i] = mat[j][i] ^ mat[j][n - 1 - i];
            }
        }
        return mat;
    }
	
	
	
	public int[][] transformImage2(int[][] mat, int n) {
        // write code here
        for(int layer = 0;layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i < last; i++){
            	//偏移量
                int offset = i - first;
                int top = mat[first][i];
                //left -> top
                mat[first][i] = mat[last - offset][first];
                //bottom -> left
                mat[last-offset][first] = mat[last][last-offset];
                //right -> bottom
                mat[last][last-offset] = mat[i][last];
                //top -> right
                mat[i][last] = top;
            }
        }
        return mat;
    }

}