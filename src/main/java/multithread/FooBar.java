package multithread;

import java.util.concurrent.Semaphore;

/**
 * @author LvSheng
 * @date 2019/12/6
 **/
class FooBar {
	
	private int       n;
	private Semaphore a;
	private Semaphore b;
	
	public FooBar(int n) {
		this.n = n;
		a = new Semaphore(1);
		b = new Semaphore(0);
	}
	
	public void foo(Runnable printFoo) throws InterruptedException {
		
		for (int i = 0; i < n; i++) {
			
			// printFoo.run() outputs "foo". Do not change or remove this line.
			a.acquire();
			printFoo.run();
			b.release();
		}
	}
	
	public void bar(Runnable printBar) throws InterruptedException {
		
		for (int i = 0; i < n; i++) {
			
			// printBar.run() outputs "bar". Do not change or remove this line.
			b.acquire();
			printBar.run();
			a.release();
		}
	}
}
