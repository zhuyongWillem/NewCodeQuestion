import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/12  17:22
 */
public class minNumDisappear {
    public int minNumberdisappered (int[] arr) {
        // write code here
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            linkedList.add(arr[i]);
        }
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            if(!linkedList.contains(i)){
                return i;
            }
        }
        return 0;
    }
    public String solve (String s, String t) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0){
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();
    }
    public int search (int[] A, int target) {
        // write code here
        int left = 0;
        int right = A.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] > A[left]){
                if(A[mid] > target && A[left] < target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(A[mid] < target && A[right] > target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
