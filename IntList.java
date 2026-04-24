public class IntList {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public IntList() {
        head = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        size++;
    }

    public void add(int value) { addLast(value); }

    public void add(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) { addFirst(value); return; }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) cur = cur.next;
        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.data;
    }

    public void set(int index, int value) {
        checkIndex(index);
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        cur.data = value;
    }

    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        if (head.next == null) {
            int val = head.data;
            head = null;
            size--;
            return val;
        }
        Node cur = head;
        while (cur.next.next != null) cur = cur.next;
        int val = cur.next.data;
        cur.next = null;
        size--;
        return val;
    }

    public int peekFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    public int peekLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        return cur.data;
    }

    public boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == value) return true;
            cur = cur.next;
        }
        return false;
    }

    public void reverse() {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public void clear() { head = null; size = 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        for (int i = 1; i <= 5; i++) list.add(i);
        System.out.println("List:     " + list);
        list.reverse();
        System.out.println("Reversed: " + list);
        System.out.println("Size: " + list.size());
        list.addFirst(99);
        System.out.println("After addFirst(99): " + list);
        list.removeLast();
        System.out.println("After removeLast: " + list);
    }
}
