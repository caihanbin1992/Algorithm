package com.chapter4;

import java.util.Arrays;

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
		int[] A=new int[]{2,1,4,5,3,3,1,2,9,4};
		//quick_sort(A,0,9);
		heapSort(A,9);
		System.out.println(Arrays.toString(A));
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
		quick_sort(A,0,n-1);
		return A;
    }
	public static void quick_sort(int[] A,int p,int r){
		if(p<r){
			int q=partition(A,p,r);
			quick_sort(A,p,q-1);
			quick_sort(A,q+1,r);
		}
	}
	public static int partition(int[] A,int p,int r){
		int x=A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(A[j]<=x){
				i=i+1;
				swap(A,i,j);
			}
		}
		swap(A,i+1,r);
		return i+1;
	}
	/**
	 * 堆排序
	 * @param A
	 * @param n
	 * @return
	 */
	 public static int[] heapSort(int[] A, int n) {
		 build_max_heap(A);
		 for(int i=A.length-1;i>=0;i--){
			 swap(A,0,i);
			 max_heapify(A,0,i-1);
		 }
	        // write code here
		return A; 
	  }
	 //建堆
	 public static void build_max_heap(int[] A){
		 for(int i=A.length/2-1;i>=0;i--){
			 max_heapify(A,i,A.length-1);
		 }
	 }
	 //维护堆
	 private static void max_heapify(int[] A, int i, int end) {
		// TODO Auto-generated method stub
		int l=2*i+1;
		int r=2*i+2;
		int largest=0;
		if(l<=end&&A[l]>A[i]){
			largest=l;
		}else{
			largest=i;
		}
		if(r<=end&&A[r]>A[largest]){
			largest=r;
		}
		if(largest!=i){
			swap(A,i,largest);
			max_heapify(A,largest,end);
		}
		
		
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
	 
	 
	 
	 
	 public static void swap(int[] A,int n,int m){
		 int temp=A[n];
		 A[n]=A[m];
		 A[m]=temp;
	 }

}
