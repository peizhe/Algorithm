package Interview;

public class Test {
	public static void main(String[] mh){
		System.out.println(new B().getValue());
	}
	
	
	static class A{
		protected int value;
		
		public A(int val){
			setValue(val);
		}
		
		public void setValue(int value){
			this.value = value;
		}
		
		public int getValue(){
			try{
				value ++;
				return value;
			} finally{
				this.setValue(value);
				System.out.println(value);
			}
		}
	}
	
	
	static class B extends A {
		public B(){
			super(5);
			setValue(getValue() - 3);
		}
		
		public void setValue(int val){
			super.setValue(val * 2);
		}
	}
}
