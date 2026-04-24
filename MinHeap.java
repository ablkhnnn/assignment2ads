public class MinHeap {

    private final IntArray data;
    private int heapSize;

    public MinHeap() {
        data = new IntArray();
        data.add(0);
        heapSize = 0;
    }

    public MinHeap(int[] arr) {
        data = new IntArray(arr.length + 1);
        data.add(0);
        for (int v : arr) data.add(v);
        heapSize = arr.length;
        for (int i = heapSize / 2; i >= 1; i--) siftDown(i);
    }

    public int size() { return heapSize; }

    public boolean isEmpty() { return heapSize == 0; }

    public void insert(int value) {
        if (heapSize + 1 < data.size()) {
            data.set(heapSize + 1, value);
        } else {
            data.add(value);
        }
        heapSize++;
        siftUp(heapSize);
    }

    public int min() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return data.get(1);
    }

    public int extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        int minimum = data.get(1);
        data.set(1, data.get(heapSize));
        heapSize--;
        if (heapSize > 0) siftDown(1);
        return minimum;
    }

    private void siftUp(int i) {
        while (i > 1) {
            int parent = i / 2;
            if (data.get(i) < data.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left  = 2 * i;
            int right = 2 * i + 1;
            int smallest = i;
            if (left  <= heapSize && data.get(left)  < data.get(smallest)) smallest = left;
            if (right <= heapSize && data.get(right) < data.get(smallest)) smallest = right;
            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MinHeap[");
        for (int i = 1; i <= heapSize; i++) {
            sb.append(data.get(i));
            if (i < heapSize) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void sortDescending(int[] arr) {
        if (arr == null || arr.length == 0) return;
        MinHeap heap = new MinHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.extractMin();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MinHeap operations ===");
        MinHeap heap = new MinHeap();
        int[] vals = {5, 3, 8, 1, 4, 2, 7};
        for (int v : vals) heap.insert(v);
        System.out.println("Heap after inserts: " + heap);
        System.out.println("min(): " + heap.min());

        System.out.print("Extracted in order: ");
        while (!heap.isEmpty()) System.out.print(heap.extractMin() + " ");
        System.out.println();

        System.out.println("\n=== Heapify constructor ===");
        int[] arr2 = {9, 4, 6, 2, 8, 1, 5};
        MinHeap heap2 = new MinHeap(arr2);
        System.out.println("Heapified: " + heap2);
        System.out.println("min(): " + heap2.min());

        System.out.println("\n=== sortDescending ===");
        int[] toSort = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        sortDescending(toSort);
        System.out.print("Sorted descending: ");
        for (int v : toSort) System.out.print(v + " ");
        System.out.println();
    }
}
