public class CallSingleton implements Runnable{		
		CallSingleton(){
		}
		
		public void run(){
				Singleton.getInstance();
		}
	}