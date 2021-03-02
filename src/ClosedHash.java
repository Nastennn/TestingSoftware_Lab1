import java.util.ArrayList;

public class ClosedHash {

    private static final int SIZE_OF_ARRAY = 29;


    static ArrayList<String> array = new ArrayList();

    public ClosedHash() {
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            array.add(i, null);
        }
    }

    public void insert(String str) throws Exception {
        int index = getIndex(str);

        if (array.get(index) == null) {
            array.set(index, str);
            return;
        }

        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            if (array.get(i) == null) {
                array.set(i, str);
                break;
            }

            if (i == SIZE_OF_ARRAY - 1) {
                System.out.println("Место в массиве закончилось, невозможно добавить элемент.");
                throw new Exception("Closed Hash is full");
            }
        }
    }

    public int delete(String str) {
        int deletedCount = 0;
        int index = getIndex(str);
        String element = array.get(index);
        if (element != null) {
            array.set(index, null);
            deletedCount += 1;
        } else {
            for (int i = 0; i < SIZE_OF_ARRAY; i++) {
                if (str.equals(array.get(i))) {
                    array.set(index, null);
                    deletedCount += 1;
                    break;
                }
            }
        }
        return deletedCount;
    }

    public String find(String str) {
        int index = getIndex(str);
        return array.get(index);
    }

    public int getHash(String str) {
        return str.hashCode();
    }

    public int getIndex(String str) {
        int hash = getHash(str);
        return Math.abs(hash) % SIZE_OF_ARRAY;
    }

    public void clear() {
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            array.add(i, null);
        }
    }
}
