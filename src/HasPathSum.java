/**
 * description:
 * author: 朱勇
 * time: 2021/2/12  16:53
 */
public class HasPathSum {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null){
            return false;
        }
        if(sum == 0 && root.right == null && root.left == null){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
