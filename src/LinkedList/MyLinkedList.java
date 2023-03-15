package LinkedList;

import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    //Step 1-1: Thiết lập Inner Class =>
    /*gồm 2 thuộc tính: "data" chứa dữ liệu của nó và "next" chứa liên kết với phần tử kế tiếp
     (nếu có, hoặc là null nếu không có)*/
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    //Step 1-2: Thiết lập Constructor
    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    //Step 2: Thiết lập add method => thêm phần tử vào vị trí thứ index trong Array
    public void add(int index, Object data) {
        //Gắn giá trị gốc ban đầu vào biến temp
        Node temp = head;
        //Biến được tạo ra để giữ phần dữ liệu đuôi sau phần index-1
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            //Vòng lặp for trả ra giá trị các Object nối tiếp
            /*i=0 =>        Node 1 => temp = head.next = object1 = {data1,next}
             *i=1 =>        Node 2 => temp = temp.next = head.next.next => object1.next = object2 = {data2,next}
             * ...
             *i=index-2 =>  Node n => temp = temp.next....next = head....next.next => objectIndex-2.next = objectIndex-1 = {dataNIndex-1,next}
             *i=index-1 =>    End*/
            temp = temp.next;
        }
        //Vòng lặp for dừng lại tại vị trí index -1 =>phần Object từ index về sau được gắn sao lưu vào holder
        holder = temp.next;
        //Vòng lặp for dừng lại khi kết thúc index-1 => temp = ObjectIndex-1 = {dataNIndex-1,next}
        /*Tại nút này dữ liệu data mới được tạo và chèn vào biến "next" của Object temp
        => temp.next = ObjectIndex = {dataIndex,next} với "dataIndex" = newData và "next" = null (mặc định)*/
        temp.next = new Node(data);
        //temp.next.next = "dataIndex.next" = null => được gán lại tham chiếu với phần "holder" đã sao lưu từ trước
        temp.next.next = holder;
        //Số node = độ dài của ArrayList được cập nhật thêmử
        numNodes++;
    }

    //Step 3: Thiết lập addFirst Method => thêm phần tử vào đầu Array
    public void addFirst(Object data) {
        //Biến temp được gán = head, tương đương với Object 1 = {data1,next}, với "next" có tham chiếu kế tiếp
        Node temp = head;
        //Biến head được tạo mới với data truyền vào và trở thành {data1,next}, với "data1" = newData và "next" = null (mặc định);
        head = new Node(data);
        //Head mới được gắn lại tham chiếu về temp, tức là temp = Object 1 = {data1, next} sẽ được biến đổi thành Object2
        head.next = temp;
        //Số node = độ dài của ArrayList được cập nhật thêm
        numNodes++;
    }

    //Step 4: Thiết lập get Method => phương thức get lấy phần tử trong Array.
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            //Vòng lặp for trả ra giá trị các Object nối tiếp
            /*i=0 =>    Node 1 => temp = head.next = object1 = {data1,next}
             *i=1 =>    Node 2 => temp = temp.next = head.next.next => object1.next = object2 = {data2,next}
             * ...
             *i=index-1 =>  Node n => temp = temp.next....next = head....next.next => objectIndex-1.next = objectIndex = {dataIndex,next}
             *i=index =>    End*/
            temp = temp.next;
        }
        return temp;
    }

    //Step 5: Thiết lập printList Method => phương thức in ra danh sách Array
    public void printList() {
        Node temp = head;
        while (temp != null) {
            //Điều kiện while là temp!=null, tức là tempI-1.next = null => liên kết cuối cùng không còn nữa
            /*Sau mỗi lần lặp biến temp tiếp tục dẫn sâu vào .next => truy xuất tới các phần tử kế tiếp*/
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
