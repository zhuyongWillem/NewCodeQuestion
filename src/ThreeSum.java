import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/12  11:04
 */
public class ThreeSum {
    //有序两数之和
    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int start, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int begin = start, end = num.length - 1;
        while (begin < end){
            int sum = num[begin] + num[end];
            int left = num[begin];
            int right = num[end];
            if(sum == target){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(left);
                ans.add(right);
                res.add(ans);
                while (begin < end && num[begin] == left){
                    begin++;
                }
                while (begin < end && num[end] == right){
                    end--;
                }
            }else if(sum > target){
                end--;
            }else {
                begin++;
            }
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            ArrayList<ArrayList<Integer>> tuples = twoSum(num, i + 1, -num[i]);
            for(ArrayList<Integer> tuple : tuples){
                tuple.add(num[i]);
                Collections.sort(tuple);
                res.add(tuple);
            }
            while (i < num.length - 1 && num[i] == num[i + 1]){
                i++;
            }
        }
        return res;
    }
}
