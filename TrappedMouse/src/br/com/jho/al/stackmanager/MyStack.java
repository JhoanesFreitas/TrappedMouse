package br.com.jho.al.stackmanager;

import br.com.jho.al.maze.Cell;

public class MyStack {
	
	Cell[] mazeStack;
	private int position;

	public MyStack(int size) {

		mazeStack = new Cell[size];
		position = -1;
	}

	public MyStack() {
		
		mazeStack = new Cell[10];
		position = -1;
	}

	public boolean isEmpty() {
		
		return position == -1;
	}

	public boolean isFull() {
		
		return position == mazeStack.length - 1;
	}

	public int size() {
		
		return mazeStack.length;
	}

	public void push(Cell element) {
		
		if (position < mazeStack.length)
			mazeStack[++position] = element;
		else {
			System.out.println("Overflow");
			throw new StackOverflowError("Stack Overflow");
		}
	}

	public Cell pop() {
		
		Cell recValue;
		
		if (!isEmpty()) {
			recValue = mazeStack[position];
			position--;
		} else
			throw new StackOverflowError("Stack Underflow");
		
		return recValue;
	}

	public void clear() {
		
		position = -1;
	}

	public void print() {
		
		Cell tempValue;
		MyStack mystack =  new MyStack(mazeStack.length);
		
		if (!isEmpty()) {
			while (!isEmpty()) {
				tempValue = pop();
				mystack.push(tempValue);
				System.out.println(tempValue);
			}
			
			while (!mystack.isEmpty())
				push(mystack.pop());
		}			

		else
			throw new StackOverflowError("Stack Underflow");
	}

}
