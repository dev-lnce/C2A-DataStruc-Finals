package Try;

public class MyQueue {
    private int[] data;
    private int size;
    private int capacity;

    public MyQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new int[this.capacity];
        this.size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            capacity *= 2;
            int[] biggerArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
        data[size] = value;
        size++;
    }

    public String listAll() {
        if (size == 0) {
            return "Queue: [] (Empty)";
        }
        String output = "Queue: [ (FRONT) ";
        for (int i = 0; i < size; i++) {
            output += data[i];
            if (i < size - 1) {
                output += ", ";
            }
        }
        output += " (REAR) ]";
        return output;
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void clear() {
        size = 0;
    }
}
