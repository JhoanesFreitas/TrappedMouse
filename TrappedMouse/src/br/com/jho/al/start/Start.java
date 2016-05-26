package br.com.jho.al.start;

import java.util.Scanner;

import br.com.jho.al.stackmanager.MyStack;

public class Start<T> {

	public static void main(String[] args) {
		
		int size;
		String row = "";
		
		Scanner in = new Scanner(System.in);
		MyStack stack;
		
		System.out.println("Digite o número de linhas para o labirinto: ");
		size = in.nextInt();
		
		stack = new MyStack(size);
		
		for (int i = 0; i < size; i++) {
			System.out.println("Linha: ");
			row = in.next();
			stack.push(row);
		}
		
		stack.print();
	}
}
