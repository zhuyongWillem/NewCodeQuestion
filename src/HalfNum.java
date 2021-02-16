import java.util.HashMap;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/13  16:35
 */
public class HalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : array){
            if(!hashMap.containsKey(num)){
                hashMap.put(num, 1);
            }else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        for(int num : array){
            if(hashMap.get(num) > array.length / 2){
                return num;
            }
        }
        return 0;
    }
}
