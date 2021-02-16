import java.util.Stack;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/16  13:21
 */
public class AddIntList {
    public ListNode reverseIteration(ListNode head, ListNode end){
        ListNode cur = head, pre = null, nxt = head;
        while (cur != end){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = head1;
        while (cur != null){
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = head2;
        while (cur != null){
            stack2.push(cur.val);
            cur = cur.next;
        }
        int carry = 0;
        ListNode head3 = new ListNode(0);
        ListNode cur2 = head3;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int x = 0, y = 0;
            if(!stack1.isEmpty()){
                x = stack1.pop();
            }
            if(!stack2.isEmpty()){
                y = stack2.pop();
            }
            int sum = x + y + carry;
            int num = sum % 10;
            carry = sum / 10;
            cur2.next = new ListNode(num);
            cur2 = cur2.next;
        }
        return reverseIteration(head3.next, null);
    }
}
