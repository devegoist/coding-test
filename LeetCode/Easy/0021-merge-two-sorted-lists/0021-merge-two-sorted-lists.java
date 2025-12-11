/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();

        if (list1 != null) {
            while (true) {
                list.add(list1.val);
                if (list1.next == null) {
                    break;
                }
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            while (true) {
                list.add(list2.val);
                if (list2.next == null) {
                    break;
                }
                list2 = list2.next;
            }
        }

        list.sort((a, b) -> b - a);

        ListNode result = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result = new ListNode(list.get(i));
            } else {
                result = new ListNode(list.get(i), result);
            }
        }

        return result;
    }
}