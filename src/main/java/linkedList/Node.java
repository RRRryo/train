package linkedList;

/**
 * Created by a542901 on 15/06/2018.
 */
public class Node {
    public int value;
    //public Node prev;
    public Node nxt;

    public Node(int value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void checkIfCircle(){
        Node node = new Node(1);
        node.nxt = new Node(2);
        node.nxt.nxt = new Node(3);
        node.nxt.nxt.nxt = new Node(4);
        //node.nxt.nxt.nxt.nxt = node.nxt;
        node.nxt.nxt.nxt.nxt = new Node(4);

        //??????tmp1,tmp2
        Node tmp1 = node;
        Node tmp2 = node.nxt;
        while(tmp2!=null){

            if(tmp1 == tmp2){
                System.out.println("there is circle");
                return;
            }
            else {
                tmp1 = tmp1.nxt;  //????????1??????2???
                tmp2 = tmp2.nxt.nxt;
            }
        }
        System.out.println("no circle");
    }

    public static Node reverse2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// ????
        Node cur = head.nxt;// ????
        Node tmp;// ????????????????????????
        while (cur != null) {// ?????null????????
            tmp = cur.nxt;
            cur.nxt = pre;// ????????

            // ??????
            pre = cur;
            cur = tmp;
        }
        // ????????????????null???????????????????
        head.nxt = null;

        return pre;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.nxt = new Node(2);
        node.nxt.nxt = new Node(3);
        node.nxt.nxt.nxt = new Node(4);
        node.nxt.nxt.nxt.nxt = new Node(5);

        Node firstNode = node;

        while (node!=null) {
            System.out.print(node.value + " ");
            node = node.nxt;
        }
        System.out.print("\n");


        Node currentNode= firstNode.nxt;
        Node prevNode = firstNode;
        Node tmp;

        while (currentNode !=null){
            tmp = currentNode.nxt;
            currentNode.nxt = prevNode;
            prevNode = currentNode;
            currentNode = tmp;
        }
        firstNode.nxt = null;

        while (prevNode!=null) {
            System.out.print(prevNode.value + " ");
            prevNode = prevNode.nxt;
        }
        System.out.print("\n");

    }
}
