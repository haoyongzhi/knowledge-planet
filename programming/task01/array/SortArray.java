package net.smartleon.knowledgeplant;

public class SortArray {
    private long[] arr;
    //表示有效数据的长度
    private int elements;

    public SortArray() {
        arr = new long[50];
    }

    public SortArray(int maxsize) {
        arr = new long[maxsize];
    }

    /**
     * 添加数据 比如在2，4，5，6中插入3
     */
    public void insert(long value) {
        int i;
        for(i = 0; i < elements; i++) {
            if(arr[i] > value) {
                break;
            }
        }

        for(int j = elements; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elements++;
    }

    /**
     * 显示数据
     */
    public void display() {
        System.out.print("[");
        for(int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 查找数据（线性查找，从头到尾查）
     */
    public int search(long value) {
        int i;
        for(i = 0; i < elements; i++) {
            if(value == arr[i]) {
                break;
            }
        }

        if(i == elements) {
            return -1;
        } else {
            return i;
        }

    }

    /**
     * 二分法查找数据（前提是数组是有序的，先和中间数对比，若arr[middle] > value，说明该数据在左边，否则右边），左右查找
     */
    public int binarySearch(long value) {
        int middle = 0;
        int low = 0;//左边最小数索引
        int pow = elements;

        while(true) {
            middle = (pow + low) / 2;//中间数索引
            if(arr[middle] == value) {
                return middle;
            } else if(low > pow) {
                return -1;
            } else {
                if(arr[middle] > value) {
                    pow = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }


    /**
     * 查找数据，根据索引来查
     */
    public long get(int index) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    /**
     * 删除数据
     */
    public void delete(int index) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for(int i = index; i < elements; i++) {
                arr[index] = arr[index + 1];
            }
            elements--;
        }
    }

    /**
     * 更新数据
     */
    public void change(int index, int newvalue) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = newvalue;
        }
    }
}