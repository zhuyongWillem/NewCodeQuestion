import java.util.ArrayList;
import java.util.Arrays;


/**
 * description:
 * author: 朱勇
 * time: 2021/2/5  12:30
 */
public class SmallK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        if(input.length < k || k <= 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }
}
