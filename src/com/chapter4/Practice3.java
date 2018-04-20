package com.chapter4;

/**
 * ÅÅÐò×¨Ìâ
 * @author caihanbin
 *
 */
public class Practice3 {
	public static void main(String[] args){
		int[] A=new int[]{2,1,4,5,3};
		mergeSort(A,4);
		
	}
	
	 public static int[] mergeSort(int[] A, int n) {
		 sort(A,0,n-1);
		 return A;
	        // write code here
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
	
	

}
