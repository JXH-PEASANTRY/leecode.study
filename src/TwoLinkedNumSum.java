/**
 * @author jiangxinhua
 * @date 2020/3/2
 */
public class TwoLinkedNumSum {

  /**
   * 给定两个链表分别代表两个非负整数，链表的每个结点分别分别存储整数的每位数字，且是逆序存储。求解这两个整数的和并以链表的形式返回计算的结果。
   * 例如：
   *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
   *   输出：7 -> 0 -> 8
   *
   * @param args
   */
  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(2);
    listNode1.add(4);
    listNode1.add(9);
    listNode1.print();
    ListNode listNode2 = new ListNode(5);
    listNode2.add(6);
    listNode2.add(4);
    System.out.println();
    listNode2.print();
    ListNode listNode = addSum(listNode1, listNode2);
    System.out.println();
    listNode.print();

  }


  public static ListNode addSum(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode listNode = new ListNode(0);
    while (l1 != null || l2 != null) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      listNode.add(sum % 10);
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry > 0) {
      listNode.add(carry);
    }

    return listNode.next;
  }


  public static class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
      val = x;
    }

    public void add(int newVal) {
      ListNode newNode = new ListNode(newVal);
      if (this.next == null) {
        this.next = newNode;
      } else {
        this.next.add(newVal);
      }

    }

    public void print() {
      System.out.print(this.val);
      if (this.next != null) {
        System.out.print("->");
        this.next.print();
      }


    }


  }


}
