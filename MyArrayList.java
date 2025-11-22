package Try;

public class MyArrayList {
    private static int[] array;
    private static int size;

    public MyArrayList() {
        array = new int[10];
        size = 0;
    }

    private static void makeBigger() {
        if (size == array.length) {
            int[] temp = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public static void addEnd(int num) {
        makeBigger();
        array[size] = num;
        size++;
    }

   public static void addStart(int num) {
        makeBigger();
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = num;
        size++;
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

        array[index] = num;
        size++;
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
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return -1;
        }
        return array[index];
    }

    public int getSize() {
        return size;
    }

     public void showAll() {
        if (size == 0){
            System.out.println("Array is empty.");
        }
         
        System.out.print("Items: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
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







