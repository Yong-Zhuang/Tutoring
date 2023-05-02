package edu.umb.cs.threads.basics;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeFlag{
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	
	public void setDone(){
		lock.lock();
		try{
			done = true;
		}finally{
			lock.unlock();			
		}
	}
	
	public void work(){
		while(true){
			lock.lock();
			try{
				if(done) break; // balking
				System.out.println("#");
			}finally{
				lock.unlock();
			}
		}
		System.out.println("Flag state changed.");
	}
	
	public static void main(String[] args){
		ThreadSafeFlag flagObject = new ThreadSafeFlag();
		new Thread(flagObject.new Interrupter(flagObject)).start();
		flagObject.work();
	}
	
	public class Interrupter implements Runnable{
		private ThreadSafeFlag target;
		
		Interrupter(ThreadSafeFlag target){
			this.target = target;
		}
		
		public void run(){
			try{
				Thread.sleep(100);
				target.setDone();
			} catch (InterruptedException e){}
		}
	}
}
