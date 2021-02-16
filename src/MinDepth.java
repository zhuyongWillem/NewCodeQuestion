import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/3  15:22
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (! queue.isEmpty()){
            int nums = queue.size();
            for(int i = 0; i < nums; i++){
                TreeNode cur = queue.poll();
                if(cur.right == null && cur.left == null){
                    return depth;
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
