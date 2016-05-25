package br.com.jho.al.maze;

public class MyStack {
	int vector[] = {};
	private int position;

	public MyStack(int size) {

		vector = new int[size];
		position = -1;
	}

	public MyStack() {
		
		vector = new int[10];
		position = -1;
	}

	public boolean isEmpty() {
		
		return position == -1;
	}

	public boolean isFull() {
		
		return position == vector.length - 1;
	}

	public int size() {
		
		return vector.length;
	}

	public int top() {
		
		return position;
	}

	public void push(int element) {
		
		if (position < vector.length)
			vector[++position] = element;
		else {
			System.out.println("Overflow");
			throw new StackOverflowError("Stack Overflow");
		}
	}

	public int pop() {
		
		int recValue;
		
		if (!isEmpty()) {
			recValue = vector[position];
			position--;
		} else
			throw new StackOverflowError("Stack Underflow");
		
		return recValue;
	}

	public void clear() {
		
		position = -1;
	}

	public void print() {
		
		int tempValue;
		MyStack mystack =  new MyStack(vector.length);
		
		if (!isEmpty()) {
			while (!isEmpty()) {
				tempValue = pop();
				mystack.push(tempValue);
				System.out.println(tempValue);
			}
			
			while (!mystack.isEmpty())
				push(mystack.pop());
		}
		
		//else if (!mystack.isEmpty())
			

		else
			//System.out.println("Pilha vazia");
			throw new StackOverflowError("Stack Underflow");
	}
	
	public void fillStack() {
		
		for (int i = 0; i < 10; i++) {
			vector[++position] = i+1;
		}
	}
}
