package LinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        //Tạo ra Object đầu tiên: heap = Object1 = {data1,next}, "next" = null, tương đương với mảng 1 phần tử Node
        MyLinkedList ll = new MyLinkedList(10);
        //Chèn 3 phần tử vào đầu mảng => tạo ra Linked List với 4 Node
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        //Thêm 3 phần tử vào giữa mảng => tạo ra Linked List với 7 Node
        ll.add(4, 9);
        ll.add(4, 9);
        ll.add(3, 2);
        //In ra 7 Node hiện có
        ll.printList();
    }
}
