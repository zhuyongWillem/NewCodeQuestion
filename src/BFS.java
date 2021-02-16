import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/5  11:40
 */
public class BFS {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
