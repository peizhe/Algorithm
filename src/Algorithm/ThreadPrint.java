package Algorithm;

public class ThreadPrint implements Runnable {
	private String producer, consumer;
	private int count;
	private boolean flag = false;
	private int i;// 循环i次

	public ThreadPrint(String a, String b, int i) {
		producer = a;
		consumer = b;
		this.i = i;
	}

	public void run() {
		while (count < i)
			changenumber();
	}

	public synchronized void changenumber() {
		if (Thread.currentThread().getName().equals(producer)) {
			try {
				if (flag)
					wait();
				else if (count < i) {
					flag = true;
					System.out.println(Thread.currentThread().getName()
							+ ":生产者生产商品" + count);
					notify();
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (Thread.currentThread().getName().equals(consumer)) {
			try {
				if (flag && count < i) {
					flag = false;
					System.out.println(Thread.currentThread().getName()
							+ ":消费者消费商品" + (count ++));
					notify();
					Thread.sleep(1000);
				} 
				else{
					wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		try {
					
			String a = "生产者";
			String b = "消费者";
			ThreadPrint tp1 = new ThreadPrint(a,b,5);
			
			Thread t1 = new Thread(tp1);
			Thread t2 = new Thread(tp1);
			t1.start();
			t2.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
