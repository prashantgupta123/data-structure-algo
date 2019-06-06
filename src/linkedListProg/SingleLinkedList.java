package linkedListProg;

public class SingleLinkedList {

    private Node head;

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(2);
        singleLinkedList.appendInEnd(3);
        singleLinkedList.push(1);
        singleLinkedList.insertAfter(4, singleLinkedList.getHead().getNext());
        singleLinkedList.insertAfterValue(5, 3);
        singleLinkedList.insertBeforeValue(6, 5);
        singleLinkedList.deleteNode(5);
        singleLinkedList.printList();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.setNext(head);
        head = new_node;
    }

    private void appendInEnd(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            new_node.setNext(head);
            head = new_node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(new_node);
        }
    }

    private void insertAfter(int new_data, Node prev_node) {
        Node new_node = new Node(new_data);
        if (prev_node == null) {
            System.out.println("Previous Node is Null");
        } else if (head == null) {
            new_node.setNext(head);
            head = new_node;
        } else {
            new_node.setNext(prev_node.getNext());
            prev_node.setNext(new_node);
        }
    }

    private void insertAfterValue(int new_data, int value) {
        Node new_node = new Node(new_data);
        if (value == 0) {
            System.out.println("Value is Null");
        } else if (head == null) {
            new_node.setNext(head);
            head = new_node;
        } else {
            Node prev_node = head;
            while (prev_node.getNext() != null && prev_node.getData() != value) {
                prev_node = prev_node.getNext();
            }
            new_node.setNext(prev_node.getNext());
            prev_node.setNext(new_node);
        }
    }

    private void insertBeforeValue(int new_data, int value) {
        Node new_node = new Node(new_data);
        if (value == 0) {
            System.out.println("Value is Null");
        } else if (head == null) {
            new_node.setNext(head);
            head = new_node;
        } else {
            if (head.getData() == value) {
                new_node.setNext(head);
                head = new_node;
            } else {
                Node prev_node = head;
                while (prev_node.getNext() != null && prev_node.getNext().getData() != value) {
                    prev_node = prev_node.getNext();
                }
                new_node.setNext(prev_node.getNext());
                prev_node.setNext(new_node);
            }
        }
    }

    private void deleteNode(int value) {
        if (value == 0) {
            System.out.println("Value is Null");
        } else if (head == null) {
            System.out.println("List is Null");
        } else {
            if (head.getData() == value) {
                head = head.getNext();
            } else {
                Node prev_node = head;
                while (prev_node.getNext() != null && prev_node.getNext().getData() != value) {
                    prev_node = prev_node.getNext();
                }
                if (prev_node.getNext() != null) {
                    prev_node.setNext(prev_node.getNext().getNext());
                }
            }
        }
    }

    private void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.getData() + " ");
            tnode = tnode.getNext();
        }
    }

}
