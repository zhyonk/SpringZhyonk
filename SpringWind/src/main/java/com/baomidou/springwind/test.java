package com.baomidou.springwind;

public class test {
    public static void main(String[] args){
        int arr[] = {1,5,8,4,6,22,1000,12,3};
        for(int i = 1;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int a: arr) {
            print(a);
        }
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

}
