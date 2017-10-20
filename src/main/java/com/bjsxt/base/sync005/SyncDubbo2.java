package com.bjsxt.base.sync005;
/**
 * synchronized的重入
 * 当一个线程得到了一个对象锁后，再次请求此对象时是可以再次获得该对象的锁
 * @author alienware
 *
 */
public class SyncDubbo2 {

	static class Main {
		public int i = 10;
		public synchronized void operationSup(){
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sub extends Main {
		public synchronized void operationSub(){
			try {
				while(i > 0) {
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);		
					this.operationSup();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Sub sub = new Sub();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//Sub sub = new Sub();
				sub.operationSub();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				sub.operationSub();
			}
		});

		t1.start();
		t2.start();

	}


	
}
