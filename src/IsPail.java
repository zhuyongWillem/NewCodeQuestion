import java.util.Stack;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/12  10:51
 */
public class IsPail {
    public boolean isPail (ListNode head) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
