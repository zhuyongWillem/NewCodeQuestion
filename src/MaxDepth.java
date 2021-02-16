import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/12  10:42
 */
public class MaxDepth {
    public int maxDepth (TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
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
