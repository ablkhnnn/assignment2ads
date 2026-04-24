public class Stack {

    public static class StackArray {

        private final IntArray data;

        public StackArray() {
            data = new IntArray();
        }

        public void push(int value) {
            data.add(value);
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return data.remove(data.size() - 1);
        }

        public int peek() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return data.get(data.size() - 1);
        }

        public boolean isEmpty() { return data.isEmpty(); }

        public int size() { return data.size(); }

        @Override
        public String toString() { return data.toString(); }
    }

    public static class StackQueue {

        private QueueList q1;
        private QueueList q2;

        public StackQueue() {
            q1 = new QueueList();
            q2 = new QueueList();
        }

        public void push(int value) {
            q2.enqueue(value);
            while (!q1.isEmpty()) {
                q2.enqueue(q1.dequeue());
            }
            QueueList temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return q1.dequeue();
        }

        public int peek() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return q1.peek();
        }

        public boolean isEmpty() { return q1.isEmpty(); }

        public int size() { return q1.size(); }

        @Override
        public String toString() { return q1.toString(); }
    }

    public static void main(String[] args) {
        System.out.println("=== StackArray ===");
        StackArray sa = new StackArray();
        sa.push(1); sa.push(2); sa.push(3);
        System.out.println("Stack: " + sa);
        System.out.println("peek: " + sa.peek());
        System.out.println("pop:  " + sa.pop());
        System.out.println("pop:  " + sa.pop());
        System.out.println("Stack after pops: " + sa);

        System.out.println("\n=== StackQueue ===");
        StackQueue sq = new StackQueue();
        sq.push(10); sq.push(20); sq.push(30);
        System.out.println("Stack: " + sq);
        System.out.println("peek: " + sq.peek());
        System.out.println("pop:  " + sq.pop());
        System.out.println("pop:  " + sq.pop());
        System.out.println("Stack after pops: " + sq);
    }
}
