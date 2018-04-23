package com.datastructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * problem：双栈排序
 * @author admin
 *
 */
public class Stack4 {
	  public ArrayList<Integer> twoStacksSort(int[] numbers) {
	        // write code here
		  Stack<Integer> stack=new Stack<Integer>();
		  ArrayList<Integer> list=new ArrayList<Integer>();
		  for(int i=0;i<numbers.length;i++){
			  stack.push(numbers[i]);
		  }
		  sortStackByStack(stack);
		  for(int a:stack){
			  list.add(a);
			  
		  }
		  return list;
	    }
	  
	  
	  public static void sortStackByStack(Stack<Integer> stack){
		  Stack<Integer> help=new Stack<Integer>();
		  while(!stack.isEmpty()){
			  int cur=stack.pop();
			  while(!help.isEmpty()&&help.peek()<cur){
				  stack.push(help.pop());
			  }
			  help.push(cur);
		  }
		  while(!help.isEmpty()){
			  stack.push(help.pop());
		  }
		  
	  }
}
