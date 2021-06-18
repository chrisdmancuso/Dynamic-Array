//Custom Dynamic Array Class
//Includes methods to insert, delete, print to console, and more
public class DynamicArray {

    //Internal Fields
    private int[] items;
    private int count;

    //Method to initialize an array of the passed length
    public DynamicArray(int length) {
        items = new int[length];
    }

    //Method to dynamically insert an element at the end of the array
    public void insert(int item) {
        if(items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    //Method to replace an element at a given index
    public void replaceAt(int index, int item) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int[] newItems = new int[count * 2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
            if (i == index) {
                newItems[i] = item;
            }
        }
        items = newItems;
    }

    //Method to delete last item
    public void deleteLast() {
        removeAt(count - 1);
    }

    //Method to remove an element at a given index
    public void removeAt(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    //Method to return the index of an element found within the array
    public int indexOf(int item) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if(items[i] == item) {
                index = i;
            }
        }
        return index;
    }

    //Method to return a value at a given index
    public int returnValueAtIndex(int index) {
        return items[index];
    }

    //Method to print array to console
    public void print() {
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.print("[" + items[i] + ",");
            } else if (i == count - 1) {
                System.out.print(items[i] + "]");
            } else {
                System.out.print(items[i] + ",");
            }
        }
        System.out.println();
    }

    //Method to print an element at a specified index to console
    public void printAtIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            System.out.format("\nElement at %d is %d\n", index, items[index]);
        }
    }
}
