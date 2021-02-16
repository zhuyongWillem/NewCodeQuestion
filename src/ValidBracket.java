import java.util.HashMap;
import java.util.Stack;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/10  9:14
 */
public class ValidBracket {
    public boolean isValid (String s) {
        // write code here
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(!stack.isEmpty() && hashMap.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static int toNum(ListNode head){
        int num = 0, len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        int bit = 0;
        while(cur != null && bit < len){
            num += cur.val * Math.pow(10, bit);
            bit++;
            cur = cur.next;
        }
        return num;
    }
    public static ListNode addTwoNumbers (ListNode f1, ListNode f2) {
        if(f1 == null){
            return f2;
        }
        if(f2 == null){
            return f1;
        }
        int ans = toNum(f1) + toNum(f2);
        ListNode newhead = f1;
        while (ans != 0){
            int res = ans % 10;
            ans /= 10;
            f1.next = new ListNode(res);
            f1 = f1.next;
        }
        return newhead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);
        ListNode cur = addTwoNumbers(l1, l2);
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
