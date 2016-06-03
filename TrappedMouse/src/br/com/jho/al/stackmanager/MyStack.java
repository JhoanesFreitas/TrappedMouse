package br.com.jho.al.stackmanager;

import br.com.jho.al.maze.Cell;

public class MyStack<T> {

    private T[] mazeStack;
    private int position;

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        mazeStack = (T[]) new Object[size];
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

    public void push(T element) {

        if (position < mazeStack.length) {
            position+=1;
            mazeStack[position] = element;
                    
            System.out.println("Pos push: \t" + position);
        } else {
            System.out.println("Overflow");
            throw new StackOverflowError("Stack Overflow");
        }
    }

    public T pop() {

        T recValue;

        if (!isEmpty()) {
            recValue = mazeStack[position];
            position-=1;
            System.out.println("Pos pop: \t" + position);
        } else {
            throw new StackOverflowError("Stack Underflow");
        }

        return recValue;
    }

    public void clear() {

        position = -1;
    }

    public void print() {

        T tempValue;
        MyStack mystack = new MyStack(mazeStack.length);

        if (!isEmpty()) {
            while (!isEmpty()) {
                tempValue = pop();
                mystack.push(tempValue);
                System.out.println(tempValue);
            }

            while (!mystack.isEmpty()) {
                push((T) mystack.pop());
            }
        } else {
            throw new StackOverflowError("Stack Underflow");
        }
    }

}
