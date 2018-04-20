package com.chapter4;

import java.util.Arrays;

/**
 * dynamic programming topics
 * 总结问题如下：
 * 1.找零钱问题
 * 2.台阶问题
 * 3.矩阵最短路径问题
 * 4.LIS问题
 * 5.LCS问题
 * 6.背包问题
 * 7.最优编辑问题
 * @author caihanbin
 *
 */
public class Practice1 { 
	
	public static void main(String[] args){
//		String A="ABCCDA";
//		String B="BCCABA";
		//int result=lcs_length(A,B);
		//System.out.println(result);
		int[] arr=new int[]{2,3,4,8,9,1,2,3,4};
		int a=find_max_subArray1(arr);
		System.out.println(a);
	}
	
	/**
	 * 找零钱问题
	 * @param penny
	 * @param n
	 * @param aim
	 * @return
	 */
	 public int countWays(int[] penny, int n, int aim) {
		 int[][] dp=new int[n][aim+1];
		 for(int i=0;i<n;i++){
			 dp[i][0]=1;
		 }
		 for(int i=1;i<=aim;i++){
			 if(i%penny[0]==0){
				 dp[0][i]=1;
			 }
		 }
		 for(int i=1;i<n;i++){
			 for(int j=1;j<aim+1;j++){
				 if(j-penny[i]>=0){
					 dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]];
				 }else{
					 dp[i][j]=dp[i-1][j];
				 }
			 }
		 }
		 return dp[n-1][aim];
	 }
	/**
	 * 求解连续最大递增子数列 LIS
	 * @param A
	 */
	public static int find_max_subArray(int[] A){
		int n=A.length;
		int[] dp=new int[n+1];
		dp[0]=0;
		for(int i=2;i<=n;i++){
			if(A[i-1]>A[i-2]){
				dp[i-1]=dp[i-2]+1;
			}else{
				dp[i-1]=1;
			}
		}
		Arrays.sort(dp);
		return dp[n];
	}
	/**
	 * LIS
	 * @param A
	 * @return
	 */
	public static int find_max_subArray1(int[] A){	
		int n=A.length;
		int[] dp=new int[n];
		for(int i=0;i<n;i++){
			dp[i]=1;
			for(int j=0;j<i;j++){
				if(A[i]>=A[j]){
					dp[i]=dp[i]>dp[j]+1?dp[i]:dp[j]+1;
				}
				
			}
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		return dp[n-1];
		
		
	}
	/**
	 * LCS
	 * @param strA
	 * @param strB
	 * @return
	 */
	public static int lcs_length(String strA,String strB){
		char[] arrA=strA.toCharArray();
		char[] arrB=strB.toCharArray();
		int a=arrA.length;
		int b=arrB.length;
		int[][] dp=new int[a+1][b+1];
		for(int i=0;i<=a;i++){
			dp[i][0]=0;
		}
		for(int j=0;j<=b;j++){
			dp[0][j]=0;
		}
		for(int i=1;i<=a;i++){
			for(int j=1;j<=b;j++){
				if(arrA[i-1]==arrB[j-1]){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
					//连续公共，求出dp中的最大值
					//dp[i][j]=0;
				}
				
			}
		}
		return dp[a][b];
		
	}
	/**
	 * 背包问题
	 * @param w 单件重量
	 * @param v 对应价值
	 * @param n 数量
	 * @param cap 背包重量要求
	 * @return
	 */
	public int maxValue(int[] w, int[] v, int n, int cap) {
		int[][] dp=new int[n+1][cap+1];
		for(int i=0;i<n+1;i++){
			dp[i][0]=0;
		}
		for(int j=0;j<cap+1;j++){
			dp[0][j]=0;
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<cap+1;j++){
				if(j>=w[i-1]){
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[n][cap];
    }
	/**
	 * 矩阵最短路径问题
	 * @param map
	 * @param n
	 * @param m
	 * @return
	 */
	public int getMin(int[][] map, int n, int m) {
        // write code here
         int[][] dp=new int[n][m];
		 //初始化行
		 dp[0][0]=map[0][0];
		 for(int i=1;i<m;i++){
			 dp[0][i]=dp[0][i-1]+map[0][i];
		 }
		 for(int j=1;j<n;j++){
			 dp[j][0]=dp[j-1][0]+map[j][0];
		 }
		 for(int i=1;i<n;i++){
			 for(int j=1;j<m;j++){
				 dp[i][j]=Math.min(dp[i-1][j]+map[i][j], dp[i][j-1]+map[i][j]);
			 }
		 }
		 return dp[n-1][m-1];
    }
	/**
	 * 最优编辑问题
	 * @param A
	 * @param n
	 * @param B
	 * @param m
	 * @param c0
	 * @param c1
	 * @param c2
	 * @return
	 */
	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // write code here
		int[][] dp=new int[n+1][m+1];
		for(int i=0;i<n+1;i++){
			dp[i][0]=c1*i;
		}
		for(int j=1;j<m+1;j++){
			dp[0][j]=c0*j;
		}
		char[] arrA=A.toCharArray();
		char[] arrB=B.toCharArray();
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				if(arrA[i-1]==arrB[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}else{
					dp[i][j]=Math.min(Math.min(dp[i-1][j]+c1,dp[i][j-1]+c0),dp[i-1][j-1]+c2);
				}
			}
		}
		
		return dp[n][m];
    }
	

}
