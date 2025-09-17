package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.NoSuchElementException;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null");
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size <= MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("The storage is full...");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null");
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        throw new NoSuchElementException("There is no such element...");
    }

    @Override
    public int size() {
        return size;
    }
}
