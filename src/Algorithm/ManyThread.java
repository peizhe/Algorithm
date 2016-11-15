package Algorithm;

public class ManyThread extends Thread{
	public String name;
	
	public void setThreadName(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 0;i < 10;i ++){
			System.out.println(name + " " + i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?> thread1 = Class.forName("Algorithm.ManyThread");
			
			ManyThread mathread1 = (ManyThread)thread1.newInstance();
			mathread1.setThreadName("线程1");
			ManyThread mathread2 = (ManyThread)thread1.newInstance();
			mathread2.setThreadName("线程2");
			
			mathread1.start();
			mathread2.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
