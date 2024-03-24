package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<T> implements QueueInterface<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    private int head;
    private int tail;

    public QueueImplementation(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        array = new Object[initialCapacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    public QueueImplementation() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if (element == null) {
            throw new NullPointerException("Cannot enqueue null element");
        }
        if (size == array.length) {
            reallocate();
        }
        array[tail] = element;
        tail = (tail + 1) % array.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        @SuppressWarnings("unchecked")
        T element = (T) array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return element;
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        @SuppressWarnings("unchecked")
        T element = (T) array[head];
        return element;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    private void reallocate() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(array[(head + i) % array.length]);
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }


}

