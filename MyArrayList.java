package Try;

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList() {
        array = new int[10];
        size = 0;
    }

    private void makeBigger() {
        if (size == array.length) {
            int[] temp = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = data[i];
            }
            array = temp;
        }
    }

    public static void addEnd(int num) {
        makeBigger();
        array[size] = num;
        size++;
        showAll();
    }

   public static void addAtStart(int num) {
        makeBigger();
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = num;
        size++;
        showAll();
    }

    public static void addAtIndex(int index, int num) {
        if (index < 0 || index > size) {
            System.out.println("Invalid position.");
            return;
        }

        makeBigger();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = num2;
        size++;
        showAll();
    }

    public static void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        showAll();
    }

    public static void get(int index2) {
        if (index2 < 0 || index2 >= size) {
            System.out.println("Invalid index");
            return;
        }
        System.out.println("Number at index " + index2 + ": " + array[index2]);
    }

    public int getSize() {
        System.out.println("Size: " + size);
    }

    public boolean search(int num3) {
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (array[i] == num3) {
                System.out.println("Found at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Number not found.");
        }

        showAll();
    }
    
     public void showAll() {
        if (size == 0){
            System.out.println("Array is empty.");
            return;
        }
         
        System.out.print("Items: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
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
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted:");
        showAll();
    }

    public void clear() {
        size = 0;
        System.out.println("All items are now cleared.");
    }


}

