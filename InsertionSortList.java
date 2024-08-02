//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode curr = head;

        while(curr != null) {
            ListNode prev = temp;
            ListNode nextNode = curr.next;

            while(prev.next!=null && prev.next.val<curr.val) {
                prev = prev.next;
            }

            curr.next=prev.next;
            prev.next=curr;
            curr=nextNode;
        }

        return temp.next;
    }
}
