package com.ntu.oa.controller;

public class Test {
	private String prtNo;

	public Test(String prtNo) {
		this.prtNo = prtNo;
	}

	public void send() {
		// 新定义线程来处理发送
		new Thread() {
			public void run() {
				// 这里可以写一个等待方法，让当前线程等待10秒钟现象更明显
				// 控制台打印日志
				try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("...............");
			}
		}.start();
	}

	public static void main(String[] args) {
		String prtNo = "1001200912310155555";
		// 调用异步发送短信
		Test sendAsync = new Test(prtNo);
		sendAsync.send();
		System.out.println("已经签单");

	}
}