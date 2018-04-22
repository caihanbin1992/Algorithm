package com.chapter4;

import java.util.Arrays;

/**
 * 排序专题
 * 复杂度为O(n*n);1.冒泡 2.选择 3.插入排序
 * 复杂度为O(nlogn); 1.归并排序 2.快速排序 3.堆排 4.希尔排序
 * 复杂度为O(n);1.计数排序 2.基数排序
 * @author caihanbin
 *
 */
public class Sort {
	public static void main(String[] args){
		int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81,99};
		//quick_sort(A,0,9);
		int max=getMaxNumLen(A);
		int[] arr=shellSort(A,max);
		System.out.println(max+" "+Arrays.toString(arr));
	}
	 /**
	   * 插入排序
	   * @param A
	   * @param length
	   */
	public static void insertSort(int[] A,int length){
		
		for(int i=1;i<length;i++){
			int key=A[i];
			int j=i-1;	
			while(j>=0&&key<A[j]){
				A[j+1]=A[j];
				j--;
				A[j+1]=key;
			}
			
		}
		
		
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
	 public static int[] shellSort(int[] A, int n) {
	   
	     int feet=A.length/2;
	     int index=0;
	     while(feet>0){
	    	 for(int i=feet;i<A.length;i++){
	    		 index=i;
	    		 while(index-feet>=0){
	    			 
	    			 if(A[index-feet]>A[index]){
	    				swap(A,index-feet,index);
	    				index-=feet;
	    			 }else{
	    				 break;
	    			 }
	    		 }
	    		 
	    		 
	    	 }
	    	 
	    	 feet/=2;
	    	 
	     }
	     
		 return A;
	  }
	 
	 /**
	  * 计数排序 
	  * @param A
	  * @param n
	  * @return
	  */
	 
	 public static int[] countingSort(int[] A, int n) {
		 int min=A[0];
		 int max=A[0];
		 for(int i=1;i<A.length;i++){
			 min=Math.min(A[i],min);
			 max=Math.max(A[i],max);
		 }
		 //统计每一个格子对应多少个数字
		 int[] countArr=new int[max-min+1];
		 for(int i=0;i<A.length;i++){
			 countArr[A[i]-min]++;
		 }
		 int index=0;
		 for(int i=0;i<countArr.length;i++){
			 while(countArr[i]-->0){
				 A[index++]=i+min;
			 }
		 }
		 return A;
	    
	    }
	 
	 /**
	  * 基数排序
	  * @param A
	  * @param n
	  * @return
	  */
	 public static int[] radixSort(int[] A, int d) {
		 int n=1;
		 int k=0;
		 int length=A.length;
		 int[][] bucket=new int[10][length];
		 int[] order=new int[10];
		 while(n<d){
			 for(int num:A){
				 int digit=(num/n)%10;
				 bucket[digit][order[digit]]=num;
				 order[digit]++;
			 }
			 for(int i=0;i<10;i++){
				 if(order[i]!=0){
					 for(int j=0;j<order[i];j++){
						 A[k]=bucket[i][j];
						 k++;
					 }
					 
					 
				 }
				 order[i]=0;
			 }
			 n*=10;
			 k=0;
			 
		 }
		 return A; 
	    }
	 	//获取数组最大数位
		public static int getMaxNumLen(int[] A){
			int max=A[0];
			for(int i=1;i<A.length;i++){
				if(A[i]>max){
					max=A[i];
				}
			}
			int temp=1;
			while(true){
				temp*=10;
				if(max/temp==0){
					break;
				}
				
			}
			
			return temp;
		}
 
	 
	 public static void swap(int[] A,int n,int m){
		 int temp=A[n];
		 A[n]=A[m];
		 A[m]=temp;
	 }

}
