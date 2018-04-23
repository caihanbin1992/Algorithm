package com.datastructure;

import java.util.Stack;

/**
 * 数据结构-栈和队列
 * problem:定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author admin
 *
 */
public class Stack1 {
	
	private Stack<Integer> stackData=new Stack<Integer>();
	private Stack<Integer> stackMin=new Stack<Integer>();
	
	 public void push(int node) {
	        stackData.push(node);
	        if(stackMin.empty()||stackMin.peek()>node){
	        	stackMin.push(node);
	        }else{
	        	stackMin.push(stackMin.peek());
	        }
	    }
	    
	    public void pop() {
	        if(stackMin.empty()){
	        	throw new RuntimeException("stack is null");
	        }
	        if(stackData.peek()==stackMin.peek()){
	        	stackMin.pop();
	        }
	        stackData.pop();
	    }
	    
	    public int top() {
	        return stackData.peek();
	    }
	    
	    public int min() {
	        if(stackMin.isEmpty()){
	        	throw new RuntimeException("stack is null");
	        }
	        return stackMin.peek();
	    }
 
}
