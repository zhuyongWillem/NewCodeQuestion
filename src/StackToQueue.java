import java.util.Stack;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/5  15:45
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();
    }
    public void merge(int A[], int m, int B[], int n) {
        int[] help = new int[m + n];
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < m && p2 < n) {
            if (A[p1] <= B[p2]) {
                help[p3] = A[p1];
                p3++;
                p1++;
            } else {
                help[p3] = B[p2];
                p2++;
                p3++;
            }
        }
        while (p1 < m){
            help[p3] = A[p1];
            p3++;
            p1++;
        }
        while (p2 < n){
            help[p3] = B[p2];
            p3++;
            p2++;
        }
        for(int i = 0; i < m + n; i++){
            A[i] = help[i];
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        slow = head;
        while (true){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }
        return slow;
    }
}
