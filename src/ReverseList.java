import java.util.Stack;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/5  11:12
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode help = dummy;
        while (!stack.isEmpty()){
            help.next = stack.pop();
            help = help.next;
        }
        help.next = null;
        return dummy.next;
    }
    public ListNode reverseRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
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
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null) return head;
        ListNode a = head, b = head;
        for(int i = 0; i < k; i++){
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverseIteration(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
