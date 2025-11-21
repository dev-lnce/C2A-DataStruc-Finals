package Try;

public class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList() {
        data = new int[10];
        size = 0;
    }

    private void grow() {
        if (size == data.length) {
            int[] biggerArray = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
    }

    public void addEnd(int value) {
        grow();
        data[size] = value;
        size++;
    }

    public void addStart(int value) {
        grow();
        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = value;
        size++;
    }

    public void addAtIndex(int index, int value) {
        if (index < 0 || index > size) {
            return;
        }
        grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public String listAll() {
        if (size == 0) {
            return "Array List: [] (Empty)";
        }
        String output = "Array List: [";
        for (int i = 0; i < size; i++) {
            output += data[i];
            if (i < size - 1) {
                output += ", ";
            }
        }
        output += "]";
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