/**
 * description:
 * author: 朱勇
 * time: 2021/2/8  21:50
 */
public class UpperBound {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) >> 1;
            if(a[mid] == v){
                high = mid - 1;
            }else if(a[mid] > v){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low < 0){
            return n + 1;
        }
        return low;
    }
}
