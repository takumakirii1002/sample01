package sample_order;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	public Input() {
	}
	public String inputString() {
		//文字列の入力を受け付ける
		Scanner scan=new Scanner(System.in);
		String input=null;
		System.out.println("文字を入力 enter");
		input=scan.nextLine();
		return input;
	}
	public String inputString(String s) {
		Scanner scan=new Scanner(System.in);
		String input=null;
		System.out.println(s+" 文字で入力　enter");
		input=scan.nextLine();
		return input;
	}
	public int inputInt() {
		//数列の入力を受け付ける
		int input =0;
		boolean loop=true;
		while(loop) {
			try {
				Scanner scan=new Scanner(System.in);
				System.out.println("数字を入力 enter");
				input=scan.nextInt();
				loop=false;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("整数を入力してください");
				loop=true;
			}
		}
		return input;
	}

	public int inputInt(String s) {
		int input=0;
		boolean loop=true;
		while(loop) {
			try {
				Scanner scan=new Scanner(System.in);
				System.out.println(s+" 数字で入力 enter");
				input=scan.nextInt();
				loop=false;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("整数を入力してください");
				loop=true;
			}
		}
		return input;
	}
	public int inputInt(String s,int i) {
		int input=0;
		boolean loop=true;
		while(loop) {
			try {
				Scanner scan=new Scanner(System.in);
				System.out.println(s+" 数字で入力　enter");
				input=scan.nextInt();
				if(i<=0||i<input) {
					System.out.println(i+"までの整数を入力してください");
					loop=true;
				}else {
					loop=false;
				}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("整数を入力してください");
				loop=true;
			}
		}
		return input;
	}
	public int inputInt(int i) {
		int input=0;
		boolean loop=true;
		while(loop) {
			try {
				Scanner scan=new Scanner(System.in);
				System.out.println("数字で入力　enter");
				input=scan.nextInt();
				if(input<=0||i<input) {
					System.out.println(i+"までの整数を入力してください");
					loop=true;
				}else {
					loop=false;
				}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("整数を入力してください");
				loop=true;
			}
		}
		return input;
	}

	public void close(){
		Scanner scan=new Scanner(System.in);
		scan.close();
	}





}
