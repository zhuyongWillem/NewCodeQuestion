/**
 * description:
 * author: 朱勇
 * time: 2021/2/9  20:58
 */
public class ReverseK {
    public ListNode reverse(ListNode begin, ListNode end){
        ListNode pre = null, cur = begin, nxt = begin;
        while (cur != end){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null){
            return head;
        }
        ListNode a = head, b = head;
        for(int i = 0; i < k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newhead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newhead;
    }
}
