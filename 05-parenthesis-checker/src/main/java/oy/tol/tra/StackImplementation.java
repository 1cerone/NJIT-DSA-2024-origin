package oy.tol.tra;

import java.util.Arrays;

public class StackImplementation<E> implements StackInterface<E> {

    private Object[] itemArray;
    private int capacity;
    private int size = 0;
    private static final int DEFAULT_STACK_SIZE = 10;

    public StackImplementation() throws StackAllocationException {
        this(DEFAULT_STACK_SIZE);
    }

    public StackImplementation(int capacity) throws StackAllocationException {
        if (capacity < 2) {
            throw new StackAllocationException("Capacity must be at least 2.");
        }

        try {
            itemArray = new Object[capacity];
            this.capacity = capacity;
        } catch (Exception e) {
            throw new StackAllocationException("Failed to allocate stack memory.");
        }
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(E element) throws StackAllocationException, NullPointerException {
        if (size == capacity) {
            // If the stack is full, double its capacity.
            int newCapacity = capacity * 2;
            try {
                itemArray = Arrays.copyOf(itemArray, newCapacity);
                capacity = newCapacity;
            } catch (Exception e) {
                throw new StackAllocationException("Failed to reallocate stack memory.");
            }
        }

        if (element == null) {
            throw new NullPointerException("Cannot push null element onto the stack.");
        }

        itemArray[size++] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Cannot pop from an empty stack.");
        }

        E poppedElement = (E) itemArray[--size];
        itemArray[size] = null; // Help garbage collection

        return poppedElement;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Cannot peek into an empty stack.");
        }

        return (E) itemArray[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(itemArray, 0, size, null);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(itemArray[i].toString());
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
