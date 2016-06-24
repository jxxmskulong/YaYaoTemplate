package com.nieyue.test;

public class Test2 {
	public static void main(String[] args) {
		Thread thread=new Thread(new Runnable() {
			int a=1;
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(++a);
				}
			
			}
		});
		Thread thread2=new Thread(new Runnable() {
			int a=2;
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.err.println(++a);
				}
			}
		});
		
		thread.start();
		thread2.start();
		//thread.run();
		//thread2.run();
		
		//Thread.sleep(5);
		//thread.notify();
		System.out.println("333");
	}
}
