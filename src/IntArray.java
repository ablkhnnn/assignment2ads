/// A resizable array of integers.
/// It grows internally when items are added and shrinks when items are removed.
public class IntArray {
    /// Internal int[] representation of IntArray.
    private int[] array;
    /// Number of elements in the array.
    private int size;

    ///  Initializes the array with a default size and capacity (e.g. size is 0 and capacity is 4).
    public IntArray(){
        array = new int[4];
        size = 0;
    }

    /// Initializes the array by adding the items from an int[] array.
    public IntArray(int []items){
        this();
    }

    // Getter for size.
    public int size() {
        return size;
    }

    ///  Returns the item at the index position in the array.
    public int get(int index){
        return index;
    }

    ///  Updates the item at index position and returns the old item.
    public int set(int index, int item){
        return index;
    }

    ///  Adds a new item to the array at the end position.
    public void add(int item){
    }

    ///  Inserts a new item to the array at the index position.
    public void addAt(int index, int item){
    }

    /// Removes the item at index i and returns it.
    public int remove(int index){
        return index;
    }

    /// Removes the first item and returns it.
    public int removeFirst(){ return 0; }

    /// Removes the last item and returns it.
    public int removeLast(){ return 0; }

    /// Removes the first occurrence of an item and returns whether the item was found.
    public boolean removeItem(int item){
        return false;
    }

    /// Returns the index of the first occurrence of an item or -1.
    public int indexOf(int item){
        return -1;
    }

    /// Returns true if there are no elements in the array.
    public boolean isEmpty(){
        return false;
    }

    /// Returns a string representation of the array, e.g. an array that contains 1,2 and 3 would look as "[1, 2, 3]".
    @Override
    public String toString() {
        return super.toString();
    }

    ///  main method to test the class.
    static void main(String[] args) {
        IntArray a = new IntArray();
        a.add(5);
        System.out.println(a.size());
        System.out.println(a.get(0));
        System.out.println(a);
    }
}
