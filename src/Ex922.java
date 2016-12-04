import java.util.Queue;

public class Ex922 {
    public static void main(String[] srgs) {
        System.out.println();
    }

    public int countWays(int[][] map, int x, int y) {
        // write code here
        int[][] res = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)//上一个数
                    up = res[i - 1][j] % 1000000007;
                if (j > 0)//左一个数
                    left = res[i][j - 1] % 1000000007;
                if (map[i][j] == 1) {//障碍
                    res[i][j] = 0;
                    continue;
                } else if (i == 0 && j == 0) {//初始化第一个值
                    res[i][j] = 1;
                } else {//当前数
                    res[i][j] = (up + left) % 1000000007;
                }
            }
        }
        return res[x - 1][y - 1];
    }

    public int countWays1(int[][] map, int x, int y) {
        // write code here
        int[] temp=new int[y];
        for(int i=0;i<y;i++){
            if(map[0][i]==1)
                temp[i]=1;
            else{
                temp[i]=0;
                break;
            }

        }
        for(int i=1;i<x;i++){
            if(map[i][0]!=1)
                temp[0]=0;
            for(int j=1;j<y;j++){
                if(map[i][j]==1)
                    temp[j]=(temp[j-1]+temp[j])%1000000007;
                else{
                    temp[j]=0;
                }
            }
        }
        return temp[y-1];
    }
}
