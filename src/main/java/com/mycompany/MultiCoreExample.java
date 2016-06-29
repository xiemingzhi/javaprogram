package com.mycompany;

public class MultiCoreExample {

	public static void main(String[] args) {
		MultiCoreExample mce = new MultiCoreExample();
		int numProcs = Runtime.getRuntime().availableProcessors();
		for (int i = 0; i < numProcs; i++) {
			MyRun mr = mce.new MyRun(i);
			(new Thread(mr)).start();
			System.out.println("Started thread " + i);
		}
	}

	public class MyRun implements Runnable {

		public int myint;
		
		public MyRun(int myint) {
			this.myint = myint;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(myint*1000);
				while(true) {}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
}
