package com.chapter4;

/**
 * 排序专题
 * 复杂度为O(nlogn);
 * 1.归并排序
 * 2.快速排序
 * 3.桶排
 * 4.希尔排序
 * 复杂度为O(n*n)
 * 1.冒泡排序
 * 2.选择排序
 * 3.插入排序
 * @author caihanbin
 *
 */
public class Sort {
	public static void main(String[] args){
		int[] A=new int[]{2,1,4,5,3};
		mergeSort(A,4);
		
	}
	/**
	 * 归并排序
	 * @param A
	 * @param n
	 * @return
	 */
	 public static int[] mergeSort(int[] A, int n) {
		 sort(A,0,n-1);
		 return A;
	  }
	 
	 public static void sort(int[] A,int low,int high){
		 if(low<high){
			 int mid=(low+high)/2;
			 sort(A,low,mid);
			 sort(A,mid+1,high);
			 merge(A,low,mid,high);
		 }
	 }

	private static void merge(int[] A, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int[] temp=new int[high-low+1];
		int p=low;
		int q=mid+1;
		int k=0;
		while(p<=mid&&q<=high){
			if(A[p]<A[q]){
				temp[k++]=A[p++];
			}else{
				temp[k++]=A[q++];
			}
		}
		while(p<=mid){
			temp[k++]=A[p++];
		}
		while(q<=high){
			temp[k++]=A[q++];
		}
		for(int i=0;i<temp.length;i++){
			A[low+i]=temp[i];
		}
		
	}
	/**
	 * 快速排序
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] quickSort(int[] A, int n) {
        // write code here
		return null;
    }
	/**
	 * 堆排序
	 * @param A
	 * @param n
	 * @return
	 */
	 public int[] heapSort(int[] A, int n) {
	        // write code here
		return null; 
	  }
	 /**
	  * 希尔排序
	  * @param A
	  * @param n
	  * @return
	  */
	 public int[] shellSort(int[] A, int n) {
	        // write code here
		 return null;
	  }

}
