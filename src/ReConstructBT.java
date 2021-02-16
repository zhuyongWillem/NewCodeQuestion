import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/4  14:44
 */
public class ReConstructBT {
    public TreeNode solution(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> index){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int inRoot = index.get(pre[preStart]);
        int leftSize = inRoot - inStart;
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = solution(pre, preStart + 1, preStart + leftSize, in, inStart, inRoot - 1, index);
        root.right = solution(pre, preStart + leftSize + 1, preEnd, in, inRoot + 1, inEnd, index);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            indexMap.put(in[i], i);
        }
        TreeNode ans = solution(pre, 0, pre.length - 1, in, 0, in.length - 1, indexMap);
        return ans;
    }
}
