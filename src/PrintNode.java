import java.util.ArrayList;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/5  11:54
 */
public class PrintNode {
    ArrayList<Integer> res1 = new ArrayList<>();
    public void pre(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        res1.add(root.val);
        pre(root.left);
        pre(root.right);
    }
    ArrayList<Integer> res2 = new ArrayList<>();
    public void in(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        in(root.left);
        res2.add(root.val);
        in(root.right);
    }
    ArrayList<Integer> res3 = new ArrayList<>();
    public void last(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        last(root.left);
        res3.add(root.val);
        last(root.right);
    }
    public int[][] threeOrders (TreeNode root) {
        // write code here
        pre(root);
        in(root);
        last(root);
        int n = res1.size();
        int[][] ans = new int[3][n];
        for(int i = 0; i < n; i++){
            ans[0][i] = res1.get(i);
        }
        for(int i = 0; i < n; i++){
            ans[1][i] = res2.get(i);
        }
        for(int i = 0; i < n; i++){
            ans[2][i] = res3.get(i);
        }
        return ans;
    }
}
