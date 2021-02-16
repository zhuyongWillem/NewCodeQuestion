/**
 * description:
 * author: 朱勇
 * time: 2021/2/10  9:03
 */
public class ReverseStr {
    public String solve (String str) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
