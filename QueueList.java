public class QueueList {

    private final IntList list;

    public QueueList() {
        list = new IntList();
    }

    public void enqueue(int value) {
        list.addLast(value);
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }

    public boolean isEmpty() { return list.isEmpty(); }

    public int size() { return list.size(); }

    @Override
    public String toString() { return list.toString(); }

    public static class QueueStack {

        private final Stack.StackArray inbox;
        private final Stack.StackArray outbox;

        public QueueStack() {
            inbox  = new Stack.StackArray();
            outbox = new Stack.StackArray();
        }

        public void enqueue(int value) {
            inbox.push(value);
        }

        public int dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            transfer();
            return outbox.pop();
        }

        public int peek() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            transfer();
            return outbox.peek();
        }

        public boolean isEmpty() { return inbox.isEmpty() && outbox.isEmpty(); }

        public int size() { return inbox.size() + outbox.size(); }

        private void transfer() {
            if (outbox.isEmpty()) {
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== QueueList ===");
        QueueList ql = new QueueList();
        ql.enqueue(1); ql.enqueue(2); ql.enqueue(3);
        System.out.println("Queue: " + ql);
        System.out.println("peek:    " + ql.peek());
        System.out.println("dequeue: " + ql.dequeue());
        System.out.println("dequeue: " + ql.dequeue());
        System.out.println("Queue after dequeues: " + ql);

        System.out.println("\n=== QueueStack ===");
        QueueStack qs = new QueueStack();
        qs.enqueue(10); qs.enqueue(20); qs.enqueue(30);
        System.out.println("peek:    " + qs.peek());
        System.out.println("dequeue: " + qs.dequeue());
        System.out.println("dequeue: " + qs.dequeue());
        qs.enqueue(40);
        System.out.println("peek after enqueue(40): " + qs.peek());
        System.out.println("dequeue: " + qs.dequeue());
        System.out.println("dequeue: " + qs.dequeue());
        System.out.println("isEmpty: " + qs.isEmpty());
    }
}
