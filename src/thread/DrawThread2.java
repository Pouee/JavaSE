package thread;
import java.util.concurrent.locks.ReentrantLock;

public class DrawThread2 implements Runnable{
	private	Account account  = null ;
	private int draw = 0 ;
	static class Account{
		public ReentrantLock lock = new ReentrantLock();
		public int blance ;
		public Account(int blance){
			this.blance = blance ;
		}
	}
	public DrawThread2(Account account,int draw){
		this.account = account ;
		this.draw = draw ; 
	}
	@Override
	public void run() {
		account.lock.lock();
		account.lock.lock();
		if(account.blance >= draw){
			System.out.println("Draw "+draw);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.blance -= draw ; 
			System.out.println("Blance "+account.blance);
		}else{
			System.out.println("Money not enough!");
		} 
		account.lock.unlock();
		account.lock.unlock();
	}
	public static void main(String[] args) {
		Account ac = new Account(2000);
		Thread t1 = new Thread(new DrawThread2(ac,1500));
		Thread t2 = new Thread(new DrawThread2(ac,1500));
		t1.start();
		t2.start();
	}

}
