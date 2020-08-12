
public class Ex2_AddTwoNumber {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        listNode1.list();
        System.out.println();
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.list();
        System.out.println();
        ListNode result = addTwoNumbers(listNode1, listNode2);
        result.list();
    }

    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode list1 = listNode1;
        ListNode list2 = listNode2;
        ListNode archive = new ListNode(0);
        ListNode temp = archive;
        boolean flag = false;
        while (list1 != null || list2 != null) {
            int values1 = list1 != null ? list1.val : 0;
            int values2 = list2 != null ? list2.val : 0;
            int sum = flag ? (values1 + values2 + 1) : (values1 + values2);
            if (sum >= 10) {
                sum %= 10;
                flag = true;
            } else {
                flag = false;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        if (flag) {
            temp.next = new ListNode(1);
        }
        return archive.next;
    }

    public static ListNode addTwoNumbers2(ListNode listNode1, ListNode listNode2) {
        ListNode list1 = listNode1;
        ListNode list2 = listNode2;
        ListNode archive = new ListNode(0);
        ListNode temp = archive;
        int current = 0;
        while (list1 != null || list2 != null || current != 0) {
            int values1 = list1 != null ? list1.val : 0;
            int values2 = list2 != null ? list2.val : 0;
            int sum = values1 + values2 + current;
            current = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        return archive.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void list() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}