import java.util.HashMap;
import java.util.Scanner;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/10  15:33
 */
public class SmallRed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '<' && string.charAt(i - 1) != '(' && string.charAt(i - 1) != ')'){
                sb.deleteCharAt(sb.capacity() - 1);
            } else {
                sb.append(string.charAt(i));
            }
        }
        System.out.print(sb.toString());
    }
}
