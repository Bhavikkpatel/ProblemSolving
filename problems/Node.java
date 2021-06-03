public class Node {
  int value;
  String data;
  Node next;
  Node() {}
  Node(int value) {
    this.value = value;
  }
  Node(String data) {
    this.data = data;
  }

  static void printLL(Node head) {
    Node temp = head;
    while(temp !=null) {
      System.out.print(temp.value+" ");
      temp = temp.next;
    }
    System.out.println();
  }

}
