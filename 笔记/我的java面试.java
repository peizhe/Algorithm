-- java 虚拟机: http://blog.csdn.net/bingduanlbd/article/details/8363734
	运行数据区域(Runtime Data Areas)：当运行一个JVM示例时，系统将分配给它一块内存区域（这块内存区域的大小可以设置的），这一内存区域由JVM自己来管理。
		从这一块内存中分出一块用来存储一些运行数据，例如创建的对象，传递给方法的参数，局部变量，返回值等等。分出来的这一块就称为运行数据区域。

		运行数据区域可以划分为6大块(前3个区域（PC寄存器、Java栈、本地方法栈）是每个线程独自拥有的, 后三者则是整个JVM实例中的所有线程共有的)：

			(1) 程序计数寄存器（PC 寄存器）: 每一个线程都拥有一个PC计数器，当线程启动（start）时，PC 计数器被创建，这个计数器存放当前正在被执行的字节码指令（JVM 指令）的地址。

		  **(2) Java 栈 : Java 栈也是每个线程单独拥有，线程启动时创建。
					  这个栈中存放着一系列的栈帧（Stack Frame），JVM 只能进行压入（Push）和弹出（Pop）栈帧这两种操作。
					  每当调用一个方法时，JVM 就往栈里压入一个栈帧，方法结束返回时弹出栈帧。

					  每个栈帧包含三个部分：
					  	本地变量数组 : 
					  	操作数栈 : 
					  	方法所属类的常量池引用: 

			(3) 本地方法栈（Native Method Stack）: 当程序通过 JNI（Java Native Interface）调用本地方法（如C或者 C++ 代码）时，就根据本地方法的语言类型建立相应的栈。

																																		 (上面3个每个线程独自拥有)
			=================================================================================================================================================================
																																		 (下面3个整个JVM实例中的所有线程共有)

		  **(4) Java 堆 : 堆中存放的是程序创建的对象或者实例。这个区域对JVM的性能影响很大。垃圾回收机制处理的正是这一块内存区域。
					  所以，类加载器加载其实就是根据编译后的 Class 文件，将 java 字节码载入 JVM 内存，并完成对运行数据处于的初始化工作，供执行引擎执行。

		  **(5) 方法区域 :当启动一个 JVM 实例时，方法区域被创建。它用于存放运行常量池、有关域和方法的信息、静态变量、类和方法的字节码。
					  不同的JVM实现方式在实现方法区域的时候会有所区别。Oracle 的 HotSpot 称之为永久区域（Permanent Area）或者永久代（Permanent Generation）

		  **(6) 运行常量池（Runtime Constant Pool）: 运行常量池本应该属于方法区，但是由于其重要性，JVM 规范将其独立出来说明。
					  这个区域存放 (类和接口的常量、方法和域的所有引用)。当一个方法或者域被引用的时候，JVM 就通过运行常量池中的这些引用来查找方法和域在内存中的的实际地址。




		public class ColdWind {

			public char[] ch = new char[10]; //Java堆 (依赖对象存在,对象存在则它存在,对象是放在堆上的)
			public String s = null; //Java堆 (依赖对象存在,对象存在则它存在,对象是放在堆上的)

			public static int x = 10; //方法区域 (静态成员变量的初始化发生在类的初始化阶段)
			public final int y = 10; //常量池 (编译期就将结果放入常量池)
			public int z = 10; //Java堆 (依赖对象存在,对象存在则它存在,对象是放在堆上的)

			public ColdWind() {};

			public static void add(int a, int b){} 

			public void mul(int a, int b){} 

			public static void main(String[] mh) {
				int[] nums = new int[]{}; //Java堆
				ColdWind cw = new ColdWind();
			}
		}
					

		boolean 变量在 JVM 中和 int 所占字节相同 : 4个字节
		boolean[] 数组在 JVM 中转换成 byte[] 数组 : 每个 boolean 占1个字节

-- java如何等待线程结束获取资源
	（1）通过join()方法实现：
		 调用子线程.join()方法即可，这时主线程会执行waite()方法，
		 public class Threads {
		    public static void main(String[] args) {
		        SubThread thread = new SubThread();
		        thread.start();
		        //主线程处理其他工作,让子线程异步去执行.
		        mainThreadOtherWork();
		        System.out.println("now waiting sub thread done.");
		        //主线程其他工作完毕,等待子线程的结束, 调用join系列的方法即可(可以设置超时时间)
		        try {
		            thread.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        System.out.println("now all done.");
		    }
		 
		    private static void mainThreadOtherWork() {
		        System.out.println("main thread work start");
		        try {
		            Thread.sleep(1000L);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        System.out.println("main thread work done.");
		    }
		 
		    public static class SubThread extends Thread {
		        @Override
		        public void run() {
		            working();
		        }
		 
		        private void working() {
		            System.out.println("sub thread start working.");
		            busy();
		            System.out.println("sub thread stop working.");
		        }
		 
		        private void busy() {
		            try {
		                sleep(10000L);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		 
		    }
		}

	（2）通过Future的get()方法
		public class Threads {
 
		    static ExecutorService executorService = Executors.newFixedThreadPool(1);
		 
		    @SuppressWarnings("rawtypes")
		    public static void main(String[] args) throws InterruptedException, ExecutionException {
		        SubThread thread = new SubThread();
		        Future future = executorService.submit(thread);
		        mainThreadOtherWork();
		        System.out.println("now waiting sub thread done.");
		        future.get();
		        
		        System.out.println("now all done.");
		        executorService.shutdown();
		    }
		 
		    private static void mainThreadOtherWork() {
		        System.out.println("main thread work start");
		        try {
		            Thread.sleep(3000L);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        System.out.println("main thread work done.");
		    }
		 
		    public static class SubThread extends Thread {
		        @Override
		        public void run() {
		            working();
		        }
		 
		        private void working() {
		            System.out.println("sub thread start working.");
		            busy();
		            System.out.println("sub thread stop working.");
		        }
		 
		        private void busy() {
		            try {
		                sleep(5000L);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		 
			}
		}

-- String StringBuffer 和 StringBuilder 的区别：(小米、乐视、百度)
 		String ：是一个常量 (速度最慢)
 		StringBuffer ：是一个变量，多线程安全 (速度中等)
 		StringBuilder ： 是一个变量，多线程不安全 (速度最快)

 		例：String s = "abcd";
			s = s + 1;
			System.out.print(s);// result : abcd1

			我们明明就是改变了String型的变量s的，为什么说是没有改变呢? 其实这是一种欺骗，JVM 是这样解析这段代码的：首先创建对象s，赋予一个abcd，
			然后再创建一个新的对象s用来执行第二行代码，也就是说我们之前对象s并没有变化，所以我们说String类型是不可改变的对象了，
			由于这种机制，每当用String操作字符串时，实际上是在不断的创建新的对象，而原来的对象就会变为垃圾被ＧＣ回收掉，可想而知这样执行效率会有多低。

			而StringBuffer与StringBuilder就不一样了，他们是字符串变量，是可改变的对象，每当我们用它们对字符串做操作时，实际上是在一个对象上操作的，
			这样就不会像String一样创建一些而外的对象进行操作了，当然速度就快了。

-- String 和 CharSequece 的区别：
		CharSequence 与 String 都能用于定义字符串，但CharSequence的值是可读可写序列，而String的值是只读序列。

-- a += 1与a = a + 1的区别：
	a在作为赋值语句的左值或者右值时意义不同：作为左值时，其意义为变量的地址，a=1就是将符号a代表的内存空间存入“1”这个量；而作为右值的时候，它就直接作为我们习惯用的1来用。
	总结起来，当a作为左值时代表存放的内存空间地址，右值作为数值的代名词（本例子中）。

	第一个表达式中，左值a作为一个地址，+=将a内存内的值直接 +1 操作。
	第二个表达式中，首先计算 a + 1，然后作为一个整体赋值给a内存。

    short a = 1; a = a + 1;(这样写会有错误，右面的a会作为int型进行计算，计算完需要强转才不会出错)
    short a = 1; a += 1;(这样写没问题) 

-- java接口的意义:(百度)
  	规范、扩展、回调

-- 抽象类的意:(乐视)
  	为其子类提供一个公共的类型 封装子类中得重复内容 定义抽象方法，子类虽然有不同的实现 但是定义是一致的

-- 内部类的作用:(百度、乐视)
	1.内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
	2.在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
	3.内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。

-- 父类的静态方法能否被子类重写:(猎豹)
	子类继承父类后，用相同的静态方法和非静态方法，这时非静态方法覆盖父类中的方法（即方法重写），
	父类的该静态方法被隐藏（如果对象是父类则调用该隐藏的方法），另外子类可继承父类的静态与非静态方法，至于方法重载我觉得它其中一要素就是在同一类中，
	不能说父类中的什么方法与子类里的什么方法是方法重载的体现

-- HashTable 和 HashMap 的区别：(乐视、小米)
	1.继承不同：
		public class HashTable extends Dictionary implements Map
		public class HashMap  extends AbstractMap implements Map
	2.Hashtable 中的方法是同步的，而HashMap中的方法在缺省情况下是非同步的。在多线程并发的环境下，可以直接使用Hashtable，但是要使用HashMap的话就要自己增加同步处理了。
	3.Hashtable中，key和value都不允许出现null值。在HashMap中，null可以作为键，这样的键只有一个；可以有一个或多个键所对应的值为null。
	  当get()方法返回null值时，即可以表示 HashMap 中没有该键，也可以表示该键所对应的值为null。因此，在HashMap中不能由get()方法来判断HashMap中是否存在某个键， 而应该用containsKey()方法来判断。
	4.两个遍历方式的内部实现上不同。Hashtable、HashMap 都使用了 Iterator。而由于历史原因，Hashtable 还使用了 Enumeration的方式 。
	5.Hashtable 和 HashMap 它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable 中hash数组默认大小是11，增加的方式是 old*2+1。HashMap 中hash数组的默认大小是16，而且一定是2的指数

-- LinkHashMap：LinkedHashMap 保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.
	也可以在构造时用带参数，按照应用次数排序。在遍历的时候会比HashMap慢。
	不过有种情况例外，当HashMap容量很大，实际数据较少时，遍历起来可能会比LinkedHashMap慢，因为LinkedHashMap的遍历速度只和实际数据有关，和容量无关，而HashMap的遍历速度和他的容量有关。

-- TreeMap: TreeMap 实现 SortMap 接口，能够把它保存的记录根据键排序,默认是按键值的升序排序，也可以指定排序的比较器，当用Iterator 遍历TreeMap时，得到的记录是排过序的。

-- WeakHashMap:WeakHashMap 实现了 Map 接口，是HashMap的一种实现，他使用弱引用作为内部数据的存储方案，WeakHashMap 可以作为简单缓存表的解决方案，当系统内存不够的时候，垃圾收集器会自动的清除没有在其他任何地方被引用的键值对。

-- java虚拟机的特性（百度、乐视）
   Java 语言的一个非常重要的特点就是与平台的无关性。而使用 Java 虚拟机是实现这一特点的关键。一般的高级语言如果要在不同的平台上运行，至少需要编译成不同的目标代码。
   而引入 Java 语言虚拟机后，Java 语言在不同平台上运行时不需要重新编译。Java 语言使用模式 Java 虚拟机屏蔽了与具体平台相关的信息，使得 Java 言编译程序只需生成在 Java 虚拟机上运行的目标代码（字节码），
   就可以在多种平台上不加修改地运行。Java 虚拟机在执行字节码时，把字节码解释成具体平台上的机器指令执行。

-- Java 中 == 和 equals 的区别，equals和hashCode的区别（乐视）:
	如果equals方法不被重写，== 和 equals 相同，都是比较内存地址是否相同
	如果equals方法被重写， == 比较的内存地址，equals 是自己实现的结果
	Java对于 eqauls 方法和 hashCode 方法是这样规定的：
    1、如果两个对象相同，那么它们的hashCode值一定要相同；
	2、如果两个对象的hashCode相同，它们并不一定相同（上面说的对象相同指的是用equals方法比较）

-- 多台(乐视)：
	多态存在的三个必要条件 一、要有继承； 二、要有重写； 三、父类引用指向子类对象。

-- 什么导致线程阻塞（美团）
	线程的阻塞
		为了解决对共享存储区的访问冲突，Java 引入了同步机制，现在让我们来考察多个线程对共享资源的访问，显然同步机制已经不够了，因为在任意时刻所要求的资源不一定已经准备好了被访问，
		反过来，同一时刻准备好了的资源也可能不止一个。为了解决这种情况下的访问控制问题，Java 引入了对阻塞机制的支持.
		阻塞指的是暂停一个线程的执行以等待某个条件发生（如某资源就绪），学过操作系统的同学对它一定已经很熟悉了。

-- 抽象类接口区别(360):
	1.默认的方法实现 
		抽象类可以有默认的方法实现完全是抽象的。接口根本不存在方法的实现
	2.实现 
		子类使用extends关键字来继承抽象类。如果子类不是抽象类的话，它需要提供抽象类中所有声明的方法的实现。
		子类使用关键字implements来实现接口。它需要提供接口中所有声明的方法的实现
	3.构造器
		抽象类可以有构造器
		接口不能有构造器
	4.与正常Java类的区别
		除了你不能实例化抽象类之外，它和普通Java类没有任何区别, 接口是完全不同的类型
	5.访问修饰符
		抽象方法可以有public、protected和default这些修饰符 接口方法默认修饰符是public。你不可以使用其它修饰符。
	6.main方法
		抽象方法可以有main方法并且我们可以运行它
		接口没有main方法，因此我们不能运行它。
	7.多继承
		抽象类在java语言中所表示的是一种继承关系，一个子类只能存在一个父类，但是可以存在多个接口。
	8.速度
		它比接口速度要快
		接口是稍微有点慢的，因为它需要时间去寻找在类中实现的方法。
	9.添加新方法
		如果你往抽象类中添加新的方法，你可以给它提供默认的实现。因此你不需要改变你现在的代码。 如果你往接口中添加方法，那么你必须改变实现该接口的类。

-- Volatile 有什么作用 ? 和 synchronized 的区别?
	用在多线程，同步变量。 线程为了提高效率，将某成员变量(如A)拷贝了一份（如B），线程中对A的访问其实访问的是B。只在某些动作时才进行A和B的同步。
	因此存在A和B不一致的情况。volatile就是用来避免这种情况的。volatile告诉jvm， 它所修饰的变量不保留拷贝，直接访问主内存中的（也就是上面说的A) 

	在Java内存模型中，有main memory，每个线程也有自己的memory (例如寄存器)。为了性能，一个线程会在自己的memory中保持要访问的变量的副本。
	这样就会出现同一个变量在某个瞬间，在一个线程的memory中的值可能与另外一个线程memory中的值，或者main memory中的值不一致的情况。

	
	volatile一般情况下不能代替 synchronized，因为volatile不能保证操作的原子性，即使只是i++，实际上也是由多个原子操作组成：read i; inc; write i，假如多个线程同时执行i++，volatile只能保证他们操作的i是同一块内存，但依然可能出现写入脏数据的情况。
	volatile是变量修饰符，而 synchronized 则作用于一段代码或方法

-- java类修饰符及访问权限：
					同一个类 	   同一包 		其他包的子类		其他包的非子类
	private			  可以
	default			  可以 			可以
	protected		  可以 			可以 			可以 						
	public			  可以 			可以 			可以 				可以
	
-- static 与 final 连用描述的变量只能被赋值一次！

-- 内部类一般声明为static 效率更高，而且不受外部类的约束

-- transient 关键字只能修饰变量，并且该变量不被序列化
   volatile 关键字修饰的变量，每次都是从主存中读取

-- Object 类不存在copy()方法，存在clone()方法

-- ArrayList 和 Vector 的区别:
	ArrayList 不支持线程的同步，Vector支持线程的同步 

-- 分析这个程序:

	线程t1执行wait()方法时会阻塞自己并释放锁！！！

	public static void main(String[]args)throws Exception {
	    final Object obj = new Object();
	    Thread t1 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	                try {
	                    obj.wait();
	                    System.out.println("Thread 1 wake up.");
	                } catch (InterruptedException e) {
	                }
	            }
	        }
	    };
	    t1.start();
	    Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
	    Thread t2 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	                obj.notifyAll();
	                System.out.println("Thread 2 sent notify.");
	            }
	        }
	    };
	    t2.start();
	}

	输出: Thread 2 sent notify. Thread 1 wake up

-- String 问题:
	String a = "hello";
	String b = "he" + new String("llo");
	String c = "he" + "llo";
	System.out.println(a == b) //false b会在运行时才知道是什么(主要是"llo"外面包含了一层外衣)
	System.out.println(a == c) //true

-- 线程安全的几个集合:
	Hashtable, Vector, Stack,Enumeration

-- JAVA 语言的下面几种数组复制方法中，哪个效率最高？ System.arraycopy()效率最高

-- 对于广义表的head()和tail()的理解了，head()是第一个元素，tail()是除了第一个元素的余下的。如果只有一个那么尾部是空