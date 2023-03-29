package com.hzb.sort;

/**
 * @Description 不同排序算法
 * 从大到小
 * @Author haozhenbo
 * @Date 2020-01-16 14:33
 * @Version 1.0
 */
public class Sort {

    public static void main(String[] args) {
        /*int[] array = {3,2,1};
        new Sort().bubbleSort(array);*/
        int[] array1 = {3,2,1};
        new Sort().bubbleSort2(array1);

        //选择排序
//        最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
        int[] array = {3,7,9,8,5,2,1};
//        new Sort().sectionSort(array);

        new Sort().insertionSort(array);

        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }


    }

    private void insertionSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0&&current < array[preIndex]) {
                //后移
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex +1 ] = current;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }


    }

    /**
     * 选择排序
     * @param array
     */
    public void sectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for(int j = i+1; j< length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        for (int i =0;i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public void bubbleSort2(int[] array) {
        int n =0;
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            for(int j = 0; j < length - 1 -i; j++) {
                n++;
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("比较相邻的元素遍历次数      --- " + n);
        for (int i =0;i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    private void bubbleSort(int[] array) {
        int n =0;
        int length = array.length;
        for(int i = 0;i < length; i++) {
            for(int j = i+1; j< length; j++) {
                n++;
                if(array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println("用一个数比较后面的数遍历次数-- " + n);
        for (int i =0;i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    private void swap(int[] array, int a, int b) {
        if(array[a] > array[b]) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
}
