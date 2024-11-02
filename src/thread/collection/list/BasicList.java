package thread.collection.list;

import static util.ThreadUtils.sleep;

import java.util.Arrays;

public class BasicList implements SimpleList{
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public BasicList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void add(Object e) { // add methods are not atomic!
        elementData[size] = e;
        sleep(100); // 멀티스레드 문제를 쉽게 확인하는 코드
        size++; // ++ operation is not atomic either!
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + ", size= " + size +
             ", capcaity= " + elementData.length;
    }
}