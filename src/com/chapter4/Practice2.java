package com.chapter4;


public class Practice2 {
	
	public static void main(String[] args){
		int[] p=new int[]{1,5,8,9,10};
		int result=bottom_up_cut_rod(p,5);
		System.out.println(result);
		
	}
	
	/**
	 * 自顶向下递归实现
	 * @param p
	 * @param n
	 * @return
	 */
	public static int cut_rod(int[] p,int n){
		if(n==0) 
			return 0;
		int q=0;
		for(int i=0;i<n;i++){
			q=q>p[i]+cut_rod(p, n-1-i)?q:p[i]+cut_rod(p, n-1-i);
		}
		return q;
		
	}

	
	/**
	 * 带备忘的自顶向下法
	 * @param p
	 * @param n
	 * @return
	 */
	public static int memorized_cut_rod(int[] p,int n){
		int[] arr=new int[n+1];
		for(int i=0;i<arr.length;i++){
			arr[i]=-1;
		}
		return memorized_cut_rod_aux(p,n,arr);
	}

	private static int memorized_cut_rod_aux(int[] p, int n, int[] arr) {
		if(arr[n]>=0){
			return arr[n];
		}
		int q=0;
		if(n==0){
			q=0;
		}else{
			q=-1;
			for(int i=0;i<n;i++){
				q=q>p[i]+memorized_cut_rod_aux(p,n-i-1,arr)?q:
					p[i]+memorized_cut_rod_aux(p,n-i-1,arr);
			}
			
		}
		arr[n]=q;
		return q;
		
	}
	/**
	 * 自底而上动态规划
	 * @param p
	 * @param n
	 * @return
	 */
	public static int bottom_up_cut_rod(int[] p,int n){
		
		int[] s=new int[n+1];
		int[] dp=new int[n+1];
		//初始化第一项
		dp[0]=0;
		//计算dp表
		for(int i=1;i<dp.length;i++){
			int q=-1;
			for(int j=0;j<i;j++){
				//q=q>p[j]+dp[i-j-1]?q:p[j]+dp[i-j-1];
				if(q<p[j]+dp[i-j-1]){
					q=p[j]+dp[i-j-1];
					s[i]=j;
				}
			}
			dp[i]=q;
		}
		//返回最后一项
		return dp[n];
	}

}
