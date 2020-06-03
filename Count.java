public class Count {
	private static volatile int anum;
	private static String threadName = "";

	public Count() {
		anum = 0;
	}

	public /* synchronized */ void increment() {
		int temp;
		temp = anum;
		System.out.println("Thread is " + Thread.currentThread().getName() + " n <=" + temp);
		threadName = Thread.currentThread().getName();
		try {
			Thread.sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		temp = temp + 1;
		try {
			Thread.sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		anum = temp;
		System.out.println("Thread is " + Thread.currentThread().getName() + " n =>" + temp);
	}

	public /* synchronized */ String print() {
		return String.valueOf(anum);
	}

	public /* synchronized */ void printThreadName() {
		System.out.println("threadName from Count.java: " + threadName);
	}

	public /* synchronized */ String getThreadName() {
		return threadName;
	}
}