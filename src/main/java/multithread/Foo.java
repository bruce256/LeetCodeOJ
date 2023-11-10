package multithread;

/**
 * @author 吕胜 lvheng1
 * @date 2023/11/5
 **/
public class Foo {
	
	private boolean one = false;
	private boolean two = false;
	public Foo() {
	
	}
	
	public synchronized void first(Runnable printFirst) throws InterruptedException {
		
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		one = true;
		notifyAll();
	}
	
	public synchronized void second(Runnable printSecond) throws InterruptedException {
		while (!one) {
			wait();
		}
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		two = true;
		notifyAll();
	}
	
	public synchronized void third(Runnable printThird) throws InterruptedException {
		while (!two) {
			wait();
		}
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Foo foo = new Foo();
		foo.first(() -> System.out.println("one"));
		foo.second(() -> System.out.println("two"));
		foo.third(() -> System.out.println("three	"));
	}
}
