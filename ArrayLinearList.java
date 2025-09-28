import java.util.Arrays;

public class ArrayLinearList {
    private Object[] element;
    private int size;

    public ArrayLinearList(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("initialCapacity must be >= 1");
        element = new Object[initialCapacity];
    }

    public ArrayLinearList() {
        this(10); // default initial capacity
    }

    /**
     * Shifts the elements of the linear list right by k positions.
     *
     * @param k The number of positions to shift.
     */
   public void rightShift(int k)
    {// Shift elements right by k.
    // make sure k is nonnegative
    if (k < 0)
        throw new IllegalArgumentException("Shift amount must be >= 0");

    // make sure we have enough space
    if (size + k > element.length)
    {// get larger array
        Object [] newArray = new Object [size + k];
        for (int i = 0; i < size; i++)
            newArray[i] = element[i];
        element = newArray;
    }

    // shift elements from right to left
    for (int i = size - 1; i >= 0; i--)
        element[i+k] = element[i];

    // zero fill at left end
    for (int i = 0; i < k; i++)
        element[i] = null;

    size += k;  // new size
    }

    // Example usage (not part of the class, for demonstration)
    public static void main(String[] args) {
        ArrayLinearList list = new ArrayLinearList(6);
        list.element[0] = 1;
        list.element[1] = 2;
        list.element[2] = 3;
        list.element[3] = 4;
        list.element[4] = 5;
        list.element[5] = 6;
        list.size = 6;

        System.out.println("Original List: " + Arrays.toString(list.element)); // Use Arrays.toString for Object[]
        list.rightShift(3);
        System.out.println("Shifted List: " + Arrays.toString(list.element));
        System.out.println("New Size: " + list.size);
    }
}
