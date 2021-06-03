
public class middle {
  static Node create() {
    Node head = new Node();
    head.value = 1;
    Node temp = head;
    for(int i = 2;i<=15;i++) {
      Node t = new Node(i);
      temp.next = t;
      temp = t;
    }
    return head;
  }

  public static void main(String []args) {
    Node head = create();
    Node.printLL(head);
    Node temp = head;
    if(head != null) {
      while(temp != null && temp.next != null) {
        head = head.next;
        temp = temp.next.next;
        System.out.println(head.value+", "+temp.value);
      }
    }
    System.out.println(head.value);
  }
}
