package com.datastructure;

import java.util.Stack;

/**
 * problem:栈的反转
 * @author admin
 *
 */
public class Stack3 {
	
	 public int[] reverseStack(int[] A, int n) {
		 Stack<Integer> stack=new Stack<Integer>();
		 for(int i=0;i<n;i++){
			 stack.push(A[i]);
		 }
		 reverse(stack);
		 int[] A1=new int[n];
		 for(int i=0;i<n;i++){
			 A1[i]=stack.get(i);
		 }
		 return A1;
		 // write code here
	  }
	 
	 //递归函数1：将stack的栈底元素返回并移除
	 public static int getAndRemoveLastElement(Stack<Integer> stack){
		 int result=stack.pop();
		 if(stack.isEmpty()){
			 return result;
		 }else{
			 int last=getAndRemoveLastElement(stack);
			 stack.push(result);
			 return last;
		 }
	 }
	 
	 public static void reverse(Stack<Integer> stack){
		 if(stack.isEmpty()){
			 return;
		 }
		 int i=getAndRemoveLastElement(stack);
		 reverse(stack);
		 stack.push(i);
	 }
	 

}
