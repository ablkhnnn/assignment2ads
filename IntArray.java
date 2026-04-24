public class IntArray {

    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public IntArray() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public IntArray(int capacity) {
        data = new int[capacity > 0 ? capacity : DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int i) {
        checkIndex(i);
        return data[i];
    }

    public void set(int i, int value) {
        checkIndex(i);
        data[i] = value;
    }

    public void add(int value) {
        ensureCapacity();
        data[size++] = value;
    }

    public void add(int i, int value) {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException("Index: " + i);
        ensureCapacity();
        for (int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }
        data[i] = value;
        size++;
    }

    public int remove(int i) {
        checkIndex(i);
        int removed = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return removed;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) result[i] = data[i];
        return result;
    }

    public void clear() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
    }

    private void ensureCapacity() {
        if (size == data.length) {
            resize(data.length * 2);
        }
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;
    }

    public static class ArrayIntersection {

        public static IntArray intersect(int[] A, int[] B) {
            IntArray result = new IntArray();
            for (int a : A) {
                boolean inB = false;
                for (int b : B) {
                    if (a == b) { inB = true; break; }
                }
                if (inB && !result.contains(a)) {
                    result.add(a);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            int[] A = {1, 2, 2, 3, 4};
            int[] B = {2, 3, 3, 5};
            IntArray inter = intersect(A, B);
            System.out.println("Intersection: " + inter);
        }
    }

    public static void main(String[] args) {
        IntArray arr = new IntArray();
        for (int i = 0; i < 10; i++) arr.add(i * 10);
        System.out.println("Array: " + arr);
        arr.add(2, 99);
        System.out.println("After insert 99 at index 2: " + arr);
        System.out.println("Removed index 2: " + arr.remove(2));
        System.out.println("After remove: " + arr);
        System.out.println("Contains 50? " + arr.contains(50));
        System.out.println("Index of 70: " + arr.indexOf(70));
    }
}
