import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/16  20:59
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = (Math.min(m, n) + 1) / 2;
        int i = 0;
        while (i < count) {
            for (int j = i; j <= n - 1 - i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i + 1; j <= m - 1 - i; j++) {
                res.add(matrix[j][n - 1 - i]);
            }
            for (int j = n - 2 - i; j >= i && (m - 1 - i != i); j--) {
                res.add(matrix[m - 1 - i][j]);
            }
            for (int j = m - 2 - i; j >= i + 1 && (n - 1 - i != i); j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;//获取行列长度
        travel(matrix, result, 0, n - 1, 0, m - 1);//设置左右上下边界，遍历逐个添加
        return result;
    }
    private void travel(int[][] matrix, List<Integer> result, int left, int right, int low, int high) {
        if(left<right&&low<high) {//有环的操作
            for (int i = left; i <= right; i++) result.add(matrix[low][i]);
            for (int i = low + 1; i <= high; i++) result.add(matrix[i][right]);
            for (int i = right - 1; i >= left; i--) result.add(matrix[high][i]);
            for (int i = high - 1; i > low; i--) result.add(matrix[i][left]);
            travel(matrix, result, left + 1, right - 1, low + 1, high - 1);//缩小边界，递归
        }
        if(low>high||left>right) return;//有边界相互超出的情况，说明已经结束
        if(low==high) {//上下边界重合，已经无环，自左向右扫描剩余部分
            for(int i=left;i<=right;i++) result.add(matrix[low][i]);
            return;
        }
        if(left==right){//左右边界重合，只剩中间列的中间的剩余部分，自顶向下扫描并添加剩余部分
            for(int i=low;i<=high;i++) result.add(matrix[i][left]);
            return;
        }
    }
}
