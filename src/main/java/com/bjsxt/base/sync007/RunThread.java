package com.bjsxt.base.sync007;

/**
 * 验证volatile 修饰的变量在线程间相互可见
 * 一、变量isRunning不加volatile关键字的main方法执行描述：
 * 1、实例化一个RunThread对象线程，启动
 * 2、休眠1秒
 * 3、调用isRunning方法，改变变量isRunning的布尔值，
 * 二、结果：isRunning设置成了false，但是线程没有停止
 * 三、原因：实例化对象RunThread后，isRunning的值为true，run方法判断为真，开始循环（开辟了一个新的线程），
 *          然后改变isRunning的值为false，虽然值改变了（改变了主线程的值），但是在新的线程中的isRunning值没有改变（没有共享），因此，线程不停止。
 * 四、解决方案：isRunning添加关键字volatile修饰，实现变量线程间可见
 */
public class RunThread extends Thread{

	/** volatile **/
	private volatile boolean isRunning = true;
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("进入run方法..");
		int i = 0;
		while(isRunning == true){
			//..
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(1000);
		rt.setRunning(false);
		System.out.println("isRunning的值已经被设置了false");
	}
	
	
}
