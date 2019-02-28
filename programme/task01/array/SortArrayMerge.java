package net.smartleon.knowledgeplant;

public class SortArrayMerge {
    public static void main(String[] args) {
        // 定义升序数组
        int[] a = { 1, 4, 6, 7, 8 };
        int[] b = { 2, 3, 5, 6, 9, 10 };
        sort(a, b);
    }

    public static void sort(int[] a, int[] b) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (int j : b) {
            System.out.print(j + ",");
        }
        // 获取数组长度
        int len_a = a.length;
        int len_b = b.length;
        System.out.println("len_a:" + len_a + ",len_b:" + len_b);
        int[] result = new int[len_a + len_b];
        int i, j, k;
        i = j = k = 0;
        while (i < len_a && j < len_b) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        // 处理数组剩余的值，插入结果数组中
        while(i < len_a) {
            result[k++] = a[i++];
        }
        while (j < len_b) {
            result[k++] = b[j++];
        }
        for (int p : result) {
            System.out.print(p + ",");
        }
    }
}
