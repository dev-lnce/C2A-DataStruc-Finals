package Try;

public class MyStack {
    private int[] data;
    private int top;
    private int capacity;

    public MyStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new int[this.capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            capacity *= 2;
            int[] biggerArray = new int[capacity];
            for (int i = 0; i <= top; i++) {
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
        top++;
        data[top] = value;
    }

    public String listAll() {
        if (top == -1) {
            return "Stack: [] (Empty)";
        }
        String output = "Stack: [";
        for (int i = 0; i <= top; i++) {
            output += data[i];
            if (i < top) {
                output += ", ";
            }
        }
        output += "] <-- TOP";
        return output;
    }

    public boolean search(int value) {
        for (int i = 0; i <= top; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i <= top - 1; i++) {
            for (int j = 0; j <= top - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void clear() {
        top = -1;
    }
}
