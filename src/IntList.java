public class IntList {
    private Node head;
    private int size;

    public IntList(){
        head = null;
    }

    /// Returns the number of items in the list.
    public int size(){
        return 0;
    }

    /// Returns true if the list has no items.
    boolean isEmpty(){
        return false;
    }

    /// Inserts the specified item at the beginning of this list.
    public void addFirst(int item){
    }

    /// Appends the specified item to the end of this list.
    public void addLast(int item){
    }

    /// Inserts the specified item at the specified position in this list.
    void add(int index, int item){

    }

    /// Returns the item at the specified position in this list.
    public int get(int index){
        return index;
    }

    /// Returns the first item in this list.
    public int getFirst(){
        return 0;
    }

    /// Returns the last item in this list.
    public int getLast(){
        return 0;
    }

    /// Replaces the item at the specified position in this list with the specified item.
    public int set(int index, int item){
        return 0;
    }

    /// Returns the index of the first occurrence of the specified item in this list, or -1 if this list does not contain the item.
    public int indexOf(int item){
        return -1;
    }

    /// Removes the item at the specified position in this list.
    public int remove(int index){
        return 0;
    }

    /// Removes the first occurrence of the specified item from this list, if it is present.
    public boolean removeItem(int item){
        return false;
    }

    /// Removes and returns the first item from this list.
    public int removeFirst(){
        return 0;
    }

    /// Reverses the list in place.
    public void reverse(){
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Internal class that represent a list node.
    static class Node {
        int value;
        Node next;
        Node() {}
        Node(int value) { this.value = value; }
        Node(int value, Node next) { this.value = value; this.next = next; }
    }

    /// main method to test the class.
    static void main() {
        IntList list = new IntList();
        list.addLast(5);
        System.out.println(list);
    }
}
