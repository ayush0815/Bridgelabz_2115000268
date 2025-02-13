import java.util.LinkedList;
class MyHashMap {
    private static final int SIZE = 1000;  // Fixed size for the array
    private LinkedList<Entry>[] map;  // Array of linked lists for separate chaining
    // Node to store key-value pairs
    private static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;  // Simple hash function
    }

    public void put(int key, int value) {
        int index = getHash(key);

        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }
        for (Entry entry : map[index]) {
            if (entry.key == key) {  // Key already exists, update value
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry(key, value));  // Insert new key-value pair
    }

    public int get(int key) {
        int index = getHash(key);

        if (map[index] != null) {
            for (Entry entry : map[index]) {
                if (entry.key == key) {
                    return entry.value;  // Found key, return value
                }
            }
        }
        return -1;  // Key not found
    }
    public void remove(int key) {
        int index = getHash(key);

        if (map[index] != null) {
            for (Entry entry : map[index]) {
                if (entry.key == key) {
                    map[index].remove(entry);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1));  // Output: 10
        System.out.println(hashMap.get(3));  // Output: -1
        hashMap.put(2, 30);
        System.out.println(hashMap.get(2));  // Output: 30
        hashMap.remove(2);
        System.out.println(hashMap.get(2));  // Output: -1
    }
}
