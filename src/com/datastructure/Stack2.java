package com.datastructure;


import java.util.*;
/**
 * problem：利用两个栈实现一个队列
 * @author admin
 *
 */
public class Stack2 {

	private Stack<Integer> stackPush=new Stack<Integer>();
	private Stack<Integer> stackPop=new Stack<Integer>();
	
	
	 public int[] twoStack(int[] ope, int n) {
		 int returnSize=0;
		 for(int i=0;i<n;i++){
			 if(ope[i]==0){
				 returnSize++;
			 }else{
				 stackPush.push(ope[i]);
			 }
			 
		 }
		 while(!stackPush.isEmpty()){
			 stackPop.push(stackPush.pop());
		 }
		 int[] result=new int[returnSize];
		 for(int i=0;i<returnSize;i++){
			 result[i]=stackPop.pop();
		 }
	        // write code here
		 return result;
	  }
	
}
