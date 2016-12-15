/**
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，
 * 在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。
 * 请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
 * 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，
 * 值为1代表该格子有建筑，0代表没有建筑。同时给定矩阵的大小n和m(n和m均小于等于100)，
 * 请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
public class nt01 {
    public static void main(String[] args) {

    }

    //向右、下走最快
    public int floodFill(int[][] map, int n, int m) {
        if (map[0][0] == 1) {
            return -1;
        }
        for (int i = 1; i < n; i++) {//初始化第一列
            if (map[i][0] == 1 || map[i - 1][0] == Integer.MAX_VALUE) {
                map[i][0] = Integer.MAX_VALUE;
            } else {
                map[i][0] = map[i - 1][0] + 1;
            }
        }
        for (int j = 1; j < m; j++) {//初始化第一行
            if (map[0][j] == 1 || map[0][j-1] == Integer.MAX_VALUE) {
                map[0][j] = Integer.MAX_VALUE;
            } else {
                map[0][j] = map[0][j-1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == 1 || map[i - 1][j] == Integer.MAX_VALUE && map[i][j - 1] == Integer.MAX_VALUE) {
                    map[i][j] = Integer.MAX_VALUE;
                } else {
                    map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + 1;
                }
            }
        }
        return map[n-1][m-1];
    }

    private int floodFill1(int[][] map, int n, int m) {
        return m+n-2;
    }
}
