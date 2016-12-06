(0) Android SDK版本、API版本、Android版本的关系：
	开发Android程序等很多地方，需要设置 Android SDK 的版本，而其要我们写的却是API版本的数字
	1、CompileSdkVersion 是你SDK的版本号，也就是API Level，例如 API-19、API-20、API-21 等等。
		Android 版本和对应的 API 版本的对应关系
		Code name				Version				API level
		Marshmallow				6.0					API level 23
		Lollipop				5.1					API level 22
		Lollipop				5.0					API level 21
		KitKat					4.4 - 4.4.4			API level 19
		Jelly Bean				4.3.x				API level 18
		Jelly Bean				4.2.x				API level 17
		Jelly Bean				4.1.x				API level 16
		Ice Cream Sandwich		4.0.3 - 4.0.4		API level 15, NDK 8
		Ice Cream Sandwich		4.0.1 - 4.0.2		API level 14, NDK 7

		Honeycomb				3.2.x				API level 13
		Honeycomb				3.1					API level 12, NDK 6
		Honeycomb				3.0					API level 11
		Gingerbread				2.3.3 - 2.3.7		API level 10
		Gingerbread				2.3 - 2.3.2			API level 9, NDK 5
		Froyo					2.2.x				API level 8, NDK 4
		Eclair					2.1					API level 7, NDK 3
		Eclair					2.0.1				API level 6
		Eclair					2.0					API level 5
		Donut					1.6					API level 4, NDK 2
		Cupcake					1.5					API level 3, NDK 1


	2、buildeToolVersion 是你构建工具的版本，其中包括了打包工具aapt、dx等等。这个工具的目录位于..your_sdk_path/build-tools/XX.XX.XX
	   这个版本号一般是 API-LEVEL.0.0。 例如 I/O2014 大会上发布了 API20 对应的 build-tool 的版本就是20.0.0，在这之间可能有小版本，例如20.0.1等等。

	   你可以用高版本的build-tool去构建一个低版本的sdk工程，例如build-tool的版本为20，去构建一个sdk版本为18的
	   例如：compileSdkVersion 18，buildToolsVersion "22.0.1"这样也是OK的。

	3. Android targetSdkVersion（为了兼容性的考虑） 原理： http://www.open-open.com/lib/view/open1453252891870.html

(1) 安卓四大组件：Activity、Service、BroadcastReceiver、ContentProvider
	<1> Activity (Activity生命周期):
		1.一个 Activity 栈对应一个 Task(任务),一个 App 启动后就是一个 Task，一个应用可以有多个 Task，这涉及到 Activity 的启动方式

		2.一个 Activity 的状态有3种: Resumed、Paused、Stoped

		3.当前页面按下电源键，屏幕黑掉，再按电源键解屏幕锁，这个过程执行的生命周期方法是：
			onPause() --> onStop() --> (onRestart() --> onStart() --> onResume())

		4.指定 Activity 为横向或者竖向(Activity 注册标签中有screenOritation属性设置(landscope(横屏),portrait(竖屏)))
		  Activity 设置为窗体模式，同样也是在 Activity 注册标签中有 theme 属性设置成.Dialog

		5.当屏幕横竖切换时(一般游戏开发或者视频播放才回考虑横竖屏)
			默认情况下 Activity 会销毁然后重新创建一个 Activity
				-- 所以横竖屏切换时，需要保存 Activity 的状态，然后重建完成恢复状态
				-- 在横竖屏切换时, Activity 会调用onSaveInstanceState(Bundle outState)方法，在这个方法中，使用 Bundle 实现本 Activity 数据的保存
				-- 重建 Activity 时，将保存的 Bundle 值取出来，给控件设置上。
			可以通过在 AndroidManifest 中 Activity 注册的地方设置configChanged属性实现横竖屏切换不重新创建 Activity

		6.Activity 通过 SharedPreference 进行数据的保存：
			SharedPreference 使用xml格式为 Android 应用提供一种永久的数据保存方式，
			它存储在文件系统的 data/data/your_app_package_name/shared目录下，可以被处在同一应用中的所有 Activity 访问

			保存数据到 SharedPreference 时一般在 Activity 的onPause()方法中进行保存！
			恢复数据时在onResume()中进行恢复(将 SharedPreference 中的数据恢复出来)

		7.Activity 的启动方式: standard singleTop singleTask singleInstance
			standard : 每次启动都重新创建一个 Activity，放入目标 Task 的栈顶
			singleTop : 在当前任务栈中，如果栈顶和当前 Activity 相同，则不重新创建 Activity 对象;否则重新创建
			singleTask : 在当前任务栈中，判断栈中是否存在 Activity，如果不存在，创建一个新 Activity 入栈;如果存在，则清除掉栈中该 Activity 之上的所有 Activity，显示当前 Activity
			singleInstance : 新创建一个任务栈，放入新创建的 Activity，该任务栈只允许存在一个 Activity 实例;如果已存在该 Activity 的栈，则将此栈切换到当前任务栈

		8.Android Activity 类中的 finish()、onDestory()和 System.exit(0) 三者的区别 : http://blog.csdn.net/yelangjueqi/article/details/9466347
	 		Activity.finish()
				Call this when your activity is done and should be closed. 
				在你的activity动作完成的时候，或者Activity需要关闭的时候，调用此方法。
				当你调用此方法的时候，系统只是将最上面的 Activity 移出了任务栈，并没有及时的调用onDestory（）方法，其占用的资源也没有被及时释放。
				因为移出了栈，所以当你点击手机上面的“back”按键的时候，也不会找到这个Activity。

			Activity.onDestory()
				the system is temporarily destroying this instance of the activity to save space.
				系统销毁了这个Activity的实例在内存中占据的空间。
				在 Activity 的生命周期中，onDestory()方法是他生命的最后一步，资源空间都释放掉。当重新进入此Activity的时候，必须重新创建，执行onCreate()方法。

			System.exit(0)
				这玩意是退出整个应用程序的，是针对整个Application的。将整个进程直接KILL掉。
				使用时，可以写在onDestory()方法内，亦可直接在想退出的地方直接调用：
				如：System.exit(0); 或 Android.os.Process.killProcess(android.os.Process.myPid());

		9.Android Activity 之间传递数据的几种方法:
		 	*1. 通过全局Application类共享数据
			    MyApp extends Application{
			        String var;
			        public void setVar(String var){
			             this.var = var;
			        ｝
			    }
			    在Manifest.xml中标签中 android:name=".MyApp" ，其它Activity中调用getApplication()获取该全局对象

			*2. 使用剪切板传递数据
			    ClipboardManager manager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
			    String name = "jack";
			    manager.setText(name);

			*3. 通过Intent传递数据
			    Intent intent = new Intent();
			    intent.putExtra("name","david");
			   
			*4. 使用静态变量传递数据

	<2> Intent 是组件之间进行通信的桥梁(分为直接 Intent 和 间接 Intent) : 由以下各个组成部分
		Component(组件) : 目的组件(直接 Intent，其他几个部分可以组合是间接 Intent)
			setComponent(),setClassName()两个方法都是直接 Intent(显示跳转)

		Action(动作) : 用来表示意图的行动(代表某一种特定的动作)
			以下是Intent类中预定义的部分 Action:
			ACTION_CALL -- 目标组件为activity,代表拨号动作;
			ACTION_EDIT -- 目标组件为activity,代表向用户显示数据以供其编辑的动作;
			ACTION_MAIN -- 目标组件为activity,表示作为task中的初始activity启动(这个很常见，第一个启动的 Activity 都有这个);
			ACTION_BATTERY_LOW -- 目标组件为broadcastReceiver,提醒手机电量过低;
			ACTION_SCREEN_ON -- 目标组件为broadcast,表示开启屏幕。

		category(类别) : 用来表现动作的类别(用于指定一些目标组件需要满足的额外条件。 Intent 对象中可以包含任意多个category属性)
			以下是Intent类中预定义的部分category:
			CATEGORY_HOME -- 表示目标activity必须是一个显示homescreen的activity;
			CATEGORY_LAUNCHER -- 表示目标activity可以作为 Task 栈中的初始activity,常与 ACTION_MAIN 配合使用;
			CATEGORY_GADGET -- 表示目标activity可以被作为另一个activity的一部分嵌入。

		data(数据) : 表示与动作要操纵的数据
			data属性指定所操作数据的 URI。 data经常与action配合使用, 
			如果action为 ACTION_EDIT, data的值应该指明被编辑文档的URI; 
			如果action为 ACTION_CALL, data的值应该是一个以"tel:"开头并在其后附加号码的 URI; 
			如果action为 ACTION_VIEW, data的值应该是一个以"http:"开头并在其后附加网址的 URI;
			Intent 类的setData()方法用于设置data属性,setType()方法用于设置data的MIME类型,setDataAndType()方法可以同时设定两者。

		type(数据类型) : 对于data范例的描写

		extras(扩展信息) : 扩展信息

		Flags(标志位) : 期望这个意图的运行模式(Flag 属性是一个int值, 用于通知 Android 系统如何启动目标activity,或者启动目标activity之后应该采取怎样的后续操作)
			所有的 Flag 都在 Intent 类中定义, 部分常用 Flag 如下:
				FLAG_ACTIVITY_NEW_TASK -- 通知系统将目标activity作为一个新 Task 的初始 Activity;(常用)
				FLAG_ACTIVITY_CLEAR_TOP -- 相当于singleTop
				FLAG_ACTIVITY_CLEAR_TASK -- 相当于singleTask

				FLAG_ACTIVITY_NO_HISTORY -- 通知系统不要将目标 Activity 放入历史栈中;
				FLAG_FROM_BACKGROUND -- 通知系统这个 Intent 来源于后台操作, 而非用户的直接选择;

	<3> IntentFilter 的过滤顺序 :
		android系统处理隐式 Intent 时, 会比较 Intent 和 IntentFilter 的action, category，data属性, 如果以上3个属性全都相符的话, 则 IntentFilter 所属的component就可以作为目标组件的候选
		(可能存在多个符合条件的component时)。

		1.测试action属性。 Intent 最多只能定义1个 Action, filter可以定义1个或多个 Action。 通过 Action 测试的条件为 : filter定义了 Intent 的 Action。
		2.测试category属性。Intent 可以任意多个 category, filter也可以任意个category。通过category测试的条件为 : filter定义了intent的所有category。
		3.测试data属性。 Intent 最多只能定义1个data, filter则可以定义多个data。
			通过data测试的条件为:
			a.如果intent没有指定data和data type,则只有没有定义data和datetype的filter才能通过测试;
			b.如果intent定义了data没有定义datatype, 则只有定义了相同data且没有定义datetype的filter才能通过测试;
			c.如果intent没有定义data却定义了datatype, 则只有未定义data且定义了相同的datatype的filter才能通过测试;
			d.如果intent既定义了data也定义了datatype, 则只有定义了相同的data和datatype的filter才能通过测试。
			data属性是一个URI, URI 中包含scheme,host, post和path, 典型的 URI 为 : scheme://host:port/path (scheme, host, post和path都是可选的。)
			比较2个data时, 只比较filter中包含的部分。比如filter的一个data只是指定了scheme部分, 则测试时只是比较data的scheme部分, 只要两者的scheme部分相同, 就视为"相同的data"。

	<4> Service : 默认运行在主进程的主线程中，可以通过 process 属性设置其运行在其他进程(包名:remote)
		process 属性 : 
			如果进程名是以一个冒号开头的(process=":remote")，则这个新的进程对于这个应用来说是私有的，当它被需要或者这个服务需要在新进程中运行的时候，这个新进程将会被创建。
			如果进程名是以小写字符开头的(process="remote")， 则这个服务将运行在以这个名字命名的全局的进程中(必须有相应的权限)。这将允许在不同应用中的各种组件可以共享一个进程，从而减少资源的占用。

		0.使用 Service 的技巧：
			startService 创建的 Service 会长期存在，只要不调用stopService()
			bindService 创建的 Service 在解绑时停止(Activity 在销毁时必须解绑)
			一般使用时会先调用 start 启动服务，后调用 bind绑定服务

		1.Service 的种类，Service 的启动方式（2种）：http://blog.csdn.net/vipzjyno1/article/details/26004831
			按照使用范围分类：
				本地服务：
					功能：用于实现应用程序自己的一些任务，比如查询升级信息，并不占用应用程序比如 Activity 所属线程，而是单开线程后台执行，这样用户体验比较好。
					使用：在 Service 可以调用 Context.startService()启动，调用 Context.stopService()结束。在内部可以调用 Service.stopSelf() 或 Service.stopSelfResult()来自己停止。无论调用了多少次startService()
						  ，都只需调用一次stopService()来停止。
				远程服务：
					功能：可以被其他应用程序复用，比如：天气预报服务，其他应用程序不需要再写这样的服务，调用已有的即可。
					使用：可以定义接口并把接口暴露出来，以便其他应用进行操作。客户端建立到服务对象的连接，并通过那个连接来调用服务。调用 Context.bindService() 方法建立连接，并启动，以调用 Context.unbindService()
						  关闭连接。多个客户端可以绑定至同一个服务。如果服务此时还没有加载，bindService()会先加载它。
			按照运行类别分类：
				前台服务：
					功能：前台服务需要调用 startForeground()，使用前台服务可以避免服务在后台运行的时候被系统KILL。
					使用：可以看出，我们只需要在onStartCommand里面调用 startForeground方法让服务前台运行，然后在onDestroy里面调用stopForeground解除前台运行既可！
						  所以，例如手机中的音乐播放器，不管手机是否是在休眠状态，只要开始播放了，系统就不会去KILL这个服务，只有当停止播放音乐时，服务才可能会回收清除。
				后台服务：
					后台服务就是处于后台运行的。
					在服务分类中，提到了3种服务通信类型，一种是通过startService()直接启动服务，一种是通过bindService()的方式启动。3.使用 AIDL 方式的 Service。
						1.context.startService() 启动流程（后台处理工作）：
							context.startService()  -> onCreate()  -> onStartCommand()  -> Service running  -> context.stopService()  -> onDestroy()  -> Service stop 
						2.context.bindService()启动流程（在本地同一进程内与Activity交互）：
							context.bindService()  -> onCreate()  -> onBind()  -> Service running  -> onUnbind()  -> onDestroy()  -> Service stop
						3.Service 实现不同进程间的通信：http://www.cnblogs.com/sevenyuan/archive/2013/03/22/2975682.html
							（1）使用广播
							（2）AIDL

		2.实现进程间(跨进程)通信:
			使用 AIDL 实现进程间(跨进程)通信 : http://www.cnblogs.com/devinzhang/archive/2011/12/31/2308985.html
				(1)在 AIDL 中
					Activity 属于客户端;Service 属于中间人(可以和 Activity 不在一个进程);业务对象属于服务器端
				(2)进程间通信需要网络传输(Socket)
				(3)使用 AIDL 传递自定义数据类型(官方文档)

			使用 Messenger 实现 IPC(进程间) 通信。(官方文档，在 Service 中)
				(1)Messenger 底层也是使用了 AIDL 的形式。和 AIDL 不同的是，Messenger 方式是利用 Handler 形式处理，因此它是线程安全的，这样表示
				   它不支持并发处理;AIDL 方式是线程不安全的，它支持并发处理，在使用 AIDL 时要保证线程安全。
				(2)大部分情况下不需要并发处理，因此通常只需要使用 Messanger 方式。

		3.AIDL 解决了什么问题？:(小米)
			AIDL (Android Interface Definition Language) 是一种IDL 语言，用于生成可以在 Android 设备上两个进程之间进行进程间通信(interprocess communication, IPC)的代码。
			如果在一个进程中（例如 Activity）要调用另一个进程中（例如Service）对象的操作，就可以使用 AIDL 生成可序列化的参数。 
			AIDL IPC 机制是面向接口的，像 COM 或 Corba 一样，但是更加轻量级。它是使用代理类在客户端和实现端传递数据。

		4.Service 和 Thread 的区别:
			1). Thread：Thread 是程序执行的最小单元，它是分配CPU的基本单位。可以用 Thread 来执行一些异步的操作。 
			2). Service：Service 是 Android 四大组件之一，Service 默认运行在主进程的主线程上的。
				如：onCreate，onStart 这些函数在被系统调用的时候都是在主进程的主线程上运行的。如果是Remote Service，那么对应的 Service 则是运行在独立进程的主线程上。
				
			    Thread : Thread 的运行是独立于 Activity 的，也就是说当一个 Activity 被 finish 之后，如果你没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行。
			    因此这里会出现一个问题：当 Activity 被 finish 之后，你不再持有该 Thread 的引用。另一方面，你没有办法在不同的 Activity 中对同一 Thread 进行控制。

				举个例子：如果你的 Thread 需要不停地隔一段时间就要连接服务器做某种同步的话，该 Thread 需要在 Activity 没有start的时候也在运行。
				这个时候当你 start 一个 Activity 就没有办法在该 Activity 里面控制之前创建的 Thread。
				因此你便需要创建并启动一个 Service ，在 Service 里面创建、运行并控制该 Thread，这样便解决了该问题（因为任何 Activity 都可以控制同一 Service，而系统也只会创建一个对应 Service 的实例）。
				因此你可以把 Service 想象成一种消息服务，而你可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService，Context.unbindService，来控制它，
				你也可以在 Service 里注册 BroadcastReceiver，在其他地方通过发送 broadcast 来控制它，当然这些都是 Thread 做不到的。

		5.Service 与 UI 之间的通信方式:
			（1）使用直接启动的startService实现信息传递
				流程：UI  ——> Service
				操作：使用 Intent 进行数据传递，通过服务中的onStartCommand方法进行接受（和Activity间传递方式一样）

			（2）使用绑定启动的bindservice实现信息传递（
				流程：UI  ——> Service

			（3）使用Broadcast（广播）进行信息的双向传递
				流程：UI  <——> Service
				操作：注册绑定广播接受器，之后通过广播来进行2者间通信
				注意：在服务退出的时候记得unregisterReceiver(receiver);注销广播接收器


		6.IntentSercice 是什么：http://laokaddk.blog.51cto.com/368606/1340540/
			在Android开发中，我们或许会碰到这么一种业务需求，一项任务分成几个子任务，子任务按顺序先后执行，子任务全部执行完后，这项任务才算成功。
			那么，利用几个子线程顺序执行是可以达到这个目的的，但是每个线程必须去手动控制，而且得在一个子线程执行完后，再开启另一个子线程。
			或者，全部放到一个线程中让其顺序执行。这样都可以做到，但是，如果这是一个后台任务，就得放到Service里面，由于Service和Activity是同级的，
			所以，要执行耗时任务，就得在Service里面开子线程来执行。那么，有没有一种简单的方法来处理这个过程呢，答案就是IntentService。

			简单说，IntentService 是继承于 Service 并处理异步请求的一个类，在 IntentService 内有一个工作线程来处理耗时操作，启动 IntentService 的方式和启动传统 Service 一样，
			同时，当任务执行完后，IntentService 会自动停止，而不需要我们去手动控制。另外，可以启动IntentService多次，
			而每一个耗时操作会以工作队列的方式在 IntentService 的 onHandleIntent 回调方法中执行，并且，每次只会执行一个工作线程，
			执行完第一个再执行第二个，以此类推。

			IntentService 优点：
				第一，省去了在 Service 中手动开线程的麻烦，
				第二，当操作完成时，我们不用手动停止 Service，
				第三，使用方便、简单

		7.如何设置自己的 Service 不被android系统回收？
			1.android 有一种机制，当内存不足时，会首先杀死后台进程。可以将自己的 Service 设置成前台进程，这样提高了该进程的优先级，就不容易被杀死。
			2.这样仍然存在Service被回收的情况，可以这样实现：创建两个 Service，一个 Service 监听另一个 Service，如果该 Service 被android回收，那另一个 Service 将启动它（QQ就是这样实现的）
			3.在 Service 的生命周期函数 onDestroy()方法中重新启动 Service

	<5> BroadcastReceiver : 广播(onReceive() 方法不能书写耗时操作,如果超过10秒，则无效(看官方文档有说明))
		0.广播的分类 :
			普通广播 : 注册接收者、发送广播
			有序广播 : (广播优先级从-1000--1000，值越大优先级越高，优先级在Intent-filter中指定)
			粘性广播 : 先发送，后接收(发送一个广播后，系统会缓存该广播，等到receiver注册后，才会接受到)(好比电视台播放节目，等到你打开电视才会收到电视节目)

			广播接收的顺序:先看优先级，再看是否动态注册(动态注册优先级更高)、

		1.广播接受者有两种注册方式 :
			静态注册 : 在 AndroidManifest 中注册
			动态注册 : 在 Activity 的onResume()方法中注册，在onPause()中注销

		2.BroadcastReceiver 应用
			实现网络状态监测
			电量监测(接收系统发出的广播，系统一般每一分钟发一次广播)	
			发短信的功能，接收短信的功能(用到去好好看看视频这个代码吧)

		3.如何使发出的广播让指定的某一程序接收，其他程序不允许接收：
			http://blog.csdn.net/mingli198611/article/details/17762149
			一、只允许本应用内允许接收。

			解决方案一：LocalBroadcastManager （局部广播，本地广播）
				优点：
				1. 因广播数据在本应用范围内传播，你不用担心隐私数据泄露的问题。
				2. 不用担心别的应用伪造广播，造成安全隐患。
				3. 相比在系统内发送全局广播，它更高效。
				缺点：
				1. 它只能够在同一个进程使用，如果本应用是多进程的。必须保证发送者和接收者是在同一个进程内。
				2. 它只能够动态注册和取消。

			解决方案二：intent 指定包名Intent.setPackage设置广播仅对本程序有效

				指定某一个应用允许接收。

				解决方案：intent 指定包名Intent.setPackage设置广播仅对相同包名的有效

				优点：
				1.支持跨进程
				2.receiver可以是静态注册也可以是动态注册。
				3.只有指定的包名的应用程序才能够接收到数据，所以安全性较高。
				缺点：
				1.如果一旦反编译，很容易伪造广播，造成安全隐患
				2.在系统内发生全局广播，它效率较低
				3.它只能够满足一个应用的需求，不能够同时指定多个

			解决方案三：指定某一个receiver允许接收。

				解决方案：intent 指定包名Intent. setComponent设置广播仅对相同包名的有效

				优点：
				1.可以指定到具体某一个receiver，安全性更高
				2.receiver可以是静态注册也可以是动态注册。
				缺点：
				1.它只能指定一个receiver，局限性较大

			解决方案四：指定多个应用有权接收。

				解决方案：sendBroadcast(Intent, String)的接口在发送广播时指定接收者必须具备的permission。如果担心反编译后，权限被窃取，限制失效。可以在声明权限时，提高权限的
				level为签名验证，即只有相同签名的应用且有该权限才能够接收，这样就能够满足产品簇的问题。

				使用实例：

				AndroidManifest.xml

				<permission android:description="@string/XXX" 
				       android:label="XXXX" 
				       android:name=" com.test.permission" 
				       android:protectionLevel="signature">
				 
				<receiver
				       android:name="XXXX"
				       android:permission="com.test.permission" >

			           <intent-filter >
			                <action android:name="XXXXX" />
			           </intent-filter>

				 </receiver>

				Intent intent = new Intent();             
				intent.setAction("消息action");            
				sendBroadcast(intent, "com.test.permission");

	<6> ContentProvider : 内容提供者
		*1.ContentProvider 是一个进程使用另一进程数据的标准接口

		*2.ContentProvider 的使用 : github 上寻找一个例子去学习
			ContentResolver : 调用者需要使用
			ContentValues : 数据保存者(存储查询条件的)

		*3.App 群 : app_2 想访问 app_1 的数据 :
			在app_1 中需要创建 ContentProvider 以及数据的增添改查，然后 ContentProvider 在 AndroidManifest 文件注册
			app_2 通过声明 ContentProvider 的 authorities 匹配进行访问数据。

	<7> Fragment (子类 : DialogFragment(窗体形式)、ListFragment、PreferenceFragment): 碎片
		*0.Fragment 的生命周期（http://www.cnblogs.com/mybkn/articles/2455142.html）

		*1.Fragment 与 ViewPager 使用时的一些情况：
			1.ViewPager + Fragment 取消预加载（延迟加载）:http://www.2cto.com/kf/201501/368954.html
				ViewPager.setOffscreenPageLimit(int limit)：用来设置默认加载的 fragment 数量（也是缓存的Fragment数量），
				其中参数可以设为0或者1，参数小于1时，会默认用1来作为参数，未设置之前，ViewPager 会默认加载两个 Fragment。

				介绍两个方法：
					void setUserVisibleHint(boolean isVisibleToUser)：设置Fragment可见状态
					boolean getUserVisibleHint()：获得Fragment可见状态，我们可以重写 Fragment 在其中做判断

					import android.support.v4.app.Fragment;
					public abstract class BaseFragment extends Fragment {
					     
					    /** Fragment当前状态是否可见 */
					    protected boolean isVisible;
					     
					     
					    @Override
					    public void setUserVisibleHint(boolean isVisibleToUser) {
					        super.setUserVisibleHint(isVisibleToUser);
					         
					        if(getUserVisibleHint()) {
					            isVisible = true;
					            onVisible();
					        } else {
					            isVisible = false;
					            onInvisible();
					        }
					    }
					     
					     
					    /**
					     * 可见
					     */
					    protected void onVisible() {
					        lazyLoad();     
					    }
					     
					     
					    /**
					     * 不可见
					     */
					    protected void onInvisible() {
					         
					         
					    }
					     
					     
					    /** 
					     * 延迟加载
					     * 子类必须重写此方法
					     */
					    protected abstract void lazyLoad();
					}
			
			2.如果ViewPager.setOffscreenPageLimit(int limit)参数设置为1或者0，那么就不会缓存，每次移动到前一个Fragment时，都会重新建立Fragment，没有缓存。

		*2.Fragment 的特点 :
			1.Fragment 可以作为Activity界面的一部分组成出现；
			2.可以在一个 Activity 中同时出现多个 Fragment，并且一个 Fragment 也可以在多个 Activity 中使用；
			3.在 Activity 运行过程中，可以添加、移除或者替换 Fragment；
			4.Fragment 可以响应自己的输入事件，并且有自己的生命周期，它们的生命周期会受宿主 Activity 的生命周期影响	

		*3.Fragment 添加到 Activity 有两种方式 :
			静态方式 : 在 Activity 的布局文件中添加 fragment 控件(一般是大屏幕显示两个部分时，不常用)
			动态方式 : 在 Activity 中使用代码的方式添加 fragment(使用到 FragmentManager 以及 事务的提交，使用较多)

		*4.Fragment 放入 Activity 栈 
			Fragment 通过addToBackStack() 将自己放入 Activity 栈中，同时重写onKeyDown()方法 (这样点击返回键时，不会整个 Activity 销毁，而是回到上一个 Fragment)

		*5.Fragment 与 Activity，Fragment 与 Fragment 的交互 (接口的回调，很经典):
			Fragment 与 Activity 的交互 :
				在 Activity 中 : 调用getSupportFragmentManager().findFragmentById() 获取 Fragment
				在 Fragment 中 : 调用getActivity() 获得其所在的 Activity

			Fragment 与 Fragment 的交互 :  (用到接口的回调，接口要写到事件源 Fragment 里，其宿主 Activity 实现该接口)
				通过 Activity 进行交互

		*6.PreferenceFragment、PreferenceActivity (官方文档有解释，有实例) :
			这两个都可以用来制作手机设置的界面相关内容，用来作属性的设置

(2) 数据存储相关问题 :
	<1> LitePal 的使用：当有数据库（增删改查）操作时，才会创建表，否则进行查询操作会报错
	SQlite 不支持布尔型变量，因此 LitePal 的bean文件中如果存在布尔型，则必须注解为(Column(Ignore = "true"))

	<2> Android 如何把一个对象保存起来：
		*0 以文件的形式存储
		*1 通过 SharedPreference 存储
		*2 通过 SQlite 存储
		*3 通过 ContentProvider 存储

	<3> Android 数据库升级（字段变更以及增加数据库表）：http://blog.csdn.net/leehong2005/article/details/9128501
		总体思路
			1：将表A重命名，改了A_temp。
			2：创建新表A。
			3：将表A_temp的数据插入到表A。

		在应用程序开发的过程中，数据库的升级是一个很重要的组成部分（如果用到了数据库），因为程序可能会有 V1.0，V2.0，
		当用户安装新版本的程序后，必须要保证用户数据不能丢失，对于数据库设计，如果发生变更（如多添加一张表，表的字段增加或减少等），那么我们必须想好数据库的更新策略。

	<4> 数据库的操作类型有哪些，如何导入外部数据库？
			把原数据库包括在项目源码的 res/raw
			android系统下数据库应该存放在 /data/data/com..（package name）/ 目录下，所以我们需要做的是把已有的数据库传入那个目录下.
			操作方法是用FileInputStream读取原数据库，再用FileOutputStream把读取到的东西写入到那个目录.

	<5> 内部存储器(手机自带的存储空间，这里面的文件是该应用私有的，其他应用不能访问) : 
		*1.读写内部存储器的文件，读取 res/raw目录下的原生文件(获取文件流 : getResource().openRawResource(R.raw.文件名))

		*2.使用内部存储器保存内部缓存文件 :
			如果你想保存一些缓存文件，而不是永久保存，可以使用getCacheDir()打开文件所在的目录，代表内部应用程序应保存的临时缓存文件。

			当设备内部存储空间低时，Android 可以删除这些缓存文件以回收空间。然而你不应该依赖系统来为你清除这些文件。
			你应该自己维护缓存文件，并保持在一个合理的消耗空间的限制，比如1M，当用户卸载你的程序，这些数据将被删除。

			函数 				获取的目录
			getCacheDir()   	data/data/<packageName>/cache

			getFilesDir()		获取私有文件目录 : data/data/<packageName>/files

			getDir(name, model) 创建(或打开已存在的)目录 : data/data/<packageName>/app_<文件名>

			deleteFile(name)	删除私有目录的文件 : data/data/<packageName>/files

			fileList()			获取data/data/<packageName>/files 目录的文件名数组

	<6> 外部存储器(SD 卡，其他应用可以访问) : 保存缓存文件
		*0.首先在 AndroidManifest 中添加读写权限

		*1.检查是否有 SD 卡
			获取 SDCard 路径 : Environment.getExternalStorageDirectory().getPath()

		*2.外部存储器保存私有缓存文件(Android 4.4 以后才可以使用，之前是自己建立公共文件夹) : 
			函数 								获取的目录												作用 							对应手机内容
			Context.getExternalFilesDir()		获取 SDcard/Android/data/<应用包名>/files/ 目录 		存放一些长时间保存的数据		清除数据

			Context.getExternalCacheDir			获取 SDcard/Android/data/<应用包名>/cache/ 目录 		存放一些临时缓存数据 			清除缓存

			当用户卸载该应用时，采用上述方法建立的文件，SDcard/Android/data/<应用包名>/ 文件夹下的所有文件将被删除，不会留下缓存数据。(Android 4.4 之前需要手动删除)

(3) 线程间通信相关问题 :
	<1>.使用 Handler 可以完成两点工作 :
		*1.消息调度和在将来的某个时间点执行一个 Runnable 

		*2.多个任务加入到一个消息队列中执行

	<2> Handler 机制以及其中涉及的对象 :
		Message : 消息，其中包含了消息 ID，消息处理对象以及处理的数据等，由 MessageQueue 统一列队，终由 Handler 处理。
		Handler : 处理者，负责Message的发送及处理。使用Handler时，需要实现handleMessage(Message msg)方法来对特定的Message进行处理，例如更新UI等。
		MessageQueue : 消息队列，用来存放 Handler 发送过来的消息，并按照 FIFO 规则执行。当然，存放 Message 并非实际意义的保存，而是将Message以链表的方式串联起来的，等待Looper的抽取。
		Looper : 消息泵，不断地从 MessageQueue 中抽取 Message 执行。因此，一个 MessageQueue 需要一个 Looper。
		Thread : 线程，负责调度整个消息循环，即消息循环的执行场所。

		Handler 的处理过程运行在创建Handler的线程里
	    一个 Looper 对应一个 MessageQueue
	    一个线程对应一个 Looper
	    一个 Looper 可以对应多个 Handler
	    不确定当前线程时，更新 UI 时尽量调用post方法

	<3> Handler 在发送消息时，Message msg = handler.obtainMessge() 与 Message msg = new Message()区别 :
			hanlde.obtainMessage()方法 : 从整个 Messge 池中返回一个新的 Message 实例，在许多情况下使用它，因为它能避免分配新的对象，节省资源、使 Message 能够重复使用。Message 池是以链表的形式存储的(链表的最大长度是50)

			new Message() 方法 : 每次都重新创建一个 Message 对象，增加了内存开销。

	<4> Handler、Thread 和 HandlerThread 的差别（小米）:
		android.os.Handler 可以通过 Looper 对象实例化，并运行于另外的线程中，Android 提供了让 Handler 运行于其它线程的实现方式，也是就 HandlerThread。
		HandlerThread 对象start后可以获得其 Looper 对象，并且使用这个 Looper 对象实例 Handler。(这时handle绑定的是子线程，拥有子线程的 Looper 和 MessageQueue)

		使用handler的sendMessage方法时，所有处理将在子线程中进行，开启了定义的 Thread 或 Runnable 新线程
		使用handler的post方法时，直接调用 Thread 或 Runnable 的run方法，所有处理都在主线程中进行，并没有开启定义的 Thread 或 Runnable 新的线程！！！

	<5> Handler 也会出现内存泄漏问题 :

		Handler 创建一般是以匿名内部类的形式出现。一个类的内部类(非静态)，内部类对象依赖外部类对象。
		当 Activity 中的 Handler 在处理任务时，此时要退出 Activity，由于 Hanlder 持有外部类的引用，会造成 Activity 无法被回收，从而造成内存泄露、内存溢出。(需要等待 Handler 处理完毕，才能在内存中释放 Activity 对象)

		解决方法 : handler 的标准写法(当需要处理 handleMessage() 方法时)
			*1.定义内部类时，最好定义成静态内部类
			*2.使用弱引用(引用的强弱 : 强引用 > 软引用 > 弱引用)
				public static class MyHandler extends Handler {
					WeakReference<MyActivity> weakReference;

					public MyHandler(MyActivity activity){
						weakReference = new WeakReference<MyActivity>(activity);
					}

					public void handleMessage(Message msg) {
						MyActivity activity = weakReference.get();
						if (activity != null) {
							//处理
						}
					}
				}

				private final MyHandler handler = new MyHandler(this);

	<6> 使用 Handler 实现 App 闪屏页 :
		闪屏页的作用 : 1.欢迎界面 2.初始化工作(检查网络状态等)
		Handler.postDelayed(new Runnable(){}, 3000) 在 run() 方法中执行初始化工作等，handler所在的 Activity 显示闪屏页

	<7> Handler 的正确写法 :
		*1.当需要处理 handleMessage 时,使用静态内部类 + 弱引用的方式(上面这种)

		*2.当handler调用postDelayed()形式时，直接声明即可(Handler handler = new Handler(); handler.postDelayed();)

	<8> AsyncTask 的使用(底层也是拿 Handler + 线程池的方式 实现)
		*1.onPreExecute() : 在主线程中执行，进行网络请求前进行调用

		   doInBackGround(Params...) : 在子线程中执行

		   onProgressUpdate(Progress...) : 在主线程中执行

		   onPostExecute(Result...) : 在主线程中执行，子线程执行完成后调用该方法

		   要求 : AsyncTask 的实例必须在 UI 线程中创建;
		   		  execute 方法必须在 UI 线程中调用; 
		   		  不能手动调用上述几个方法;
		   		  Task 只能被调用一次，否则多次调用将会出现异常;
		   		  AsyncTask 不能完全取代线程，在一些逻辑较为复杂或者需要在后台反复执行的逻辑就可能需要线程来实现;

	<9> Loader 异步加载数据 (可以创建自己的 loader 加载其他数据源的数据(网络数据也可以)):
		*1.Loader 的作用 : 
			They are available to every Activity and Fragment.(能应用于 Activity 和 Fragment)
			They provide asynchronous loading of data.(异步加载数据)
			They monitor the source of their data and deliver new results when the content changes.(Loader 会监视数据源，数据源数据变化时 Loader 会返回新的结果)
			They automatically reconnect to the last loader's cursor when being recreated after a configuration change. Thus, they don't need to re-query their data(发生configuration change时自动重连接)

		*2.AsyncTaskLoader : Abstract loader that provides an AsyncTask to do the work.

		*3.CursorLoader(数据源必须是 ContentProvider 提供; 不能是网络数据) : A subclass of AsyncTaskLoader that queries the ContentResolver and returns a Cursor. 
						This class implements the Loader protocol in a standard way for querying cursors, 
						building on AsyncTaskLoader to perform the cursor query on a background thread so that it does not block the application's UI. 
						Using this loader is the best way to asynchronously load data from a ContentProvider, 
						instead of performing a managed query through the fragment or activity's APIs.

						从一个内容提供者去异步加载数据是 CursorLoader 对象最大用处

(4) View 相关问题 :
	<1> Android 事件分发机制

		View 的事件分发机制：
			当你点击了某个控件，首先会去调用该控件所在布局(父布局)的dispatchTouchEvent方法，然后在布局的dispatchTouchEvent方法中找到被点击的相应控件，再去调用该控件的dispatchTouchEvent方法。
		 	只要触摸控件------>dispatchTouchEvent()方法

			 	public boolean dispatchTouchEvent(MotionEvent event) {  
				    if (mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED &&  
				            mOnTouchListener.onTouch(this, event)) {  
				        return true;  
				    }  
				    return onTouchEvent(event);  
				} 

				第一个条件，mOnTouchListener这个变量是在哪里赋值的呢？我们寻找之后在View里发现了如下方法：
				public void setOnTouchListener(OnTouchListener l) {  
				    mOnTouchListener = l;  
				}
				第二个条件(mViewFlags & ENABLED_MASK) == ENABLED 是判断当前点击的控件是否是enable的，按钮默认都是enable的，因此这个条件恒定为true。
				第三个条件就比较关键了，mOnTouchListener.onTouch(this, event)，其实也就是去回调控件注册touch事件时的 onTouch() 方法。

				也就是说如果我们在onTouch方法里返回true，就会让这三个条件全部成立，从而整个方法直接返回true。如果我们在onTouch方法里返回false，就会再去执行onTouchEvent(event)方法。

			如果dispatchTouchEvent()返回true：直接返回，后面一系列action将不被执行(click操作等)
			如果dispatchTouchEvent()返回false：执行onTouchEvent()

		ViewGroup 事件分发机制：
			touch 事件的层级传递：http://hanhailong.com/2015/09/24/Android-%E4%B8%89%E5%BC%A0%E5%9B%BE%E6%90%9E%E5%AE%9ATouch%E4%BA%8B%E4%BB%B6%E4%BC%A0%E9%80%92%E6%9C%BA%E5%88%B6/

				总结说一下：
				1.事件都是从 Activity.dispatchTouchEvent() 开始传递
				2.事件由父 View 传递给子 View，ViewGroup 可以通过 onInterceptTouchEvent()方法对事件拦截，停止其向子view传递
				3.如果事件从上往下传递过程中一直没有被停止，且最底层子View没有消费事件，事件会反向往上传递，这时父 View(ViewGroup)可以进行消费，如果还是没有被消费的话，最后会到 Activity 的onTouchEvent()函数。
				4.如果View没有对 ACTION_DOWN 进行消费，之后的其他事件不会传递过来，也就是说 ACTION_DOWN 必须返回true，之后的事件才会传递进来
				5.OnTouchListener 优先于onTouchEvent()对事件进行消费
				6.如果 View 对 ACTION_DOWN 进行了消费，则不会再向父 View 传递

				补充：
					只要父控件不拦截，dispatchTouchEvent()就一定会向子 View 传递事件(即调用子 View 的dispatchTouchEvent())
					1.父控件和子控件都写点击事件(onclick())，点击时执行子控件的点击方法
					2.父控件的onTouch()方法如果返回true，不会阻断事件向子 View 传递(只要父控件的 onItercepTouchEvent()方法不返回 True 就会继续向子 View 传递)

	<2> Activity、Window、View 三者的差别 :
		Activity 是控制单元，Window 是承载模型，View 是显示视图
		Activity 好比是一幅画的框架，里面有一个window，window提供了一张画布，view就在这个画布上将自己画上去。

		1.在Activity中调用attach(attach方法很关键)，创建了一个Window，创建的window是其子类PhoneWindow
		2.在Activity中调用setContentView(R.layout.xxx),实际上是调用的getWindow().setContentView(),调用PhoneWindow中的setContentView方法
		3.创建 ParentView ：作为 ViewGroup 的子类，实际是创建的 DecorView (作为 FramLayout 的子类),将指定的 R.layout.xxx进行填充通过布局填充器进行填充【其中的parent指的就是DecorView】
		4.调用 ViewGroup  的removeAllView()，先将所有的view移除掉。添加新的view：addView()

	<3> View 的绘制过程 : 
		整个View树的绘图流程是在ViewRoot.Java 类的performTraversals()函数展开的，该函数做的执行过程可简单概况为
	 	根据之前设置的状态，判断是否需要重新计算视图大小(measure)、是否重新需要安置视图的位置(layout)、以及是否需要重绘(draw)

	<4> View 绘制 :
		Cavas : 画布; Paint : 画笔

		*0.创建自己的 View 需要继承 View 或 View 的其他子类,然后重写几个方法 :
			onDraw() : 在组件加载时调用该方法，完成组件绘制。
				cavas.drawColor() : 设置画布的背景

		*1.绘制几何图形和位图(Bitmap)
		*2.SurfaceView(继承 View，速度快，双缓存(内存缓存，磁盘缓存)，游戏开发界面使用比较多) : 官方文档
		*3.Draw.9.patch : .9图片(文件名默认加一个.9)

	<5> Bitmap :
		ARGB-8888(最高清的图片编码方式) : 每个像素占4个字节
		RGB_565 : 每个像素占2个字节

		*1.加载大型图片(需要对图片进行重采样，然后再加载，一般都使用第三方加载图片)
		*2.图片的缓存(一般是一个activity所占内存的 1/8 作为缓存大小)
			内存缓存 : 用 LruCache<String, Bitmap> 实现(底层是 LinkedHashMap)
			磁盘缓存 : 第三方的 DiskLruCache 实现磁盘缓存(谷歌推荐)
			网络缓存 : CPU 在加载资源时，前两个缓存都没有命中，则从网络加载


(5) 常用控件问题 :
	<1> Android 的布局有哪些 ?
		*1.LinearLayout
		*2.RelativeLayout
		*3.GridLayout
		*4.TableLayout
		*5.FrameLayout
		*6.AbsoluteLayout(已弃用)

	<2> 一些基本控件的属性(去官方文档查)
		TextView : 是否可选中，字体(加粗、倾斜、加粗倾斜)...
			EditView : 是否可选中，是否可编辑...
			Button : style(使用系统自带的style)、selector使用(通过设置background来设置style)
		ImageView : scaleType(缩放属性，里面很多值)、tint(将图片渲染成指定颜色)
		ToggleButton (Switch 4.0以后): 开关按钮
		RatingBar : indicator属性(决定RatingBar是否可以点击)
		Spinner : 下拉列表(静态绑定和动态绑定下拉的数据)，需要使用Adapter进行适配(数据和控件)
			适配器：将两个不能直接交互的接口连接起来，从而可以交互
		AutoCompleteTextView : 搜索时，根据输入显示匹配下拉列表，需要使用Adapter进行适配(数据和控件)
		ProgressBar : 有两种显示方式(表盘形式(小、中、大)，线性填充形式)，可以通过style属性进行指定
			ProgressDialog : 使用
			标题栏进度条
			ProgressBar 也可以设定自己想要显示的图片进度，需要在drawable先建立一个xml文件，然后设置 ProgressBar 的 indeterminateDrawable 属性为刚才的xml文件
		AlertDialog : 显示各种样式的 Dialog。同时可以自定义自己的显示样式。

		时间和日期选择器：
			TimePickerDialog : 继承 DialogFragment
			DatePickerDialog : 继承 DialogFragment
			TimePicker : 官方 API
			DatePicker : 官方 API

		GridView : 网格的方式，同时也需要适配器(自定义适配器，继承BaseAdapter)
		ListView : 单层列表的方式。
			ArrayAdapter : 自带的 Adapter，可以使用android自带的 Item 实现单选多选的列表(不用自己设计 Item)
			SimpleAdapter : 自带的 Adapter，可以实现图文列表(Item 需要自己设计)
			继承 BaseAdapter : 实现更加灵活的 Item 布局

			!!!使用 ListView 时宽高要设置成match_parent

			ListView 加载布局效率(getView() : 每加载一个 Item 都会执行getView()):
				重复使用convertView(减少view对象的创建) : 不要每次去渲染布局，不然一滚动就会创建新的view，浪费了很多内存，很容易出现内存泄露
				使用 ViewHolder(加快查找速率，每次在 Item 布局中 findViewById()会消耗时间) : 用于保存第一次查找的组件，避免下次重复去查。

		ExpandableListView(Listview 的子类) : 两层列表的方式(扩展 ListView)
			ExpandableAdapter : 适配器

		ImageSwitcher : 图片滚动、实现幻灯片的效果(需要实现 View.Factory 和 View.OnTouchListener 两个接口)
		TextSwitcher : 文字滚动 

		ViewFlipper : 整个视图进行切换(软件开始安装时的引导页可以拿这个实现)

		ViewPager : (制作app的引导页)，ViewPager 是 V4 包中的组件，使用这个控件可以实现引导页的实现(在这个布局里面嵌入几个子布局)，
			使用 PageAdapter 适配器将 ViewPager 和 显示的布局结合起来。(和 viewPager Fragment 结合使用一样，只是不需要title)

	<3> View.Stub 使用 :
		*1. ViewStub 只能 Inflate 一次，之后ViewStub对象会被置为空。按句话说，某个被ViewStub指定的布局被Inflate后，就不会够再通过ViewStub来控制它了。
     	*2. ViewStub 只能用来 Inflate 一个布局文件，而不是某个具体的View，当然也可以把View写在某个布局文件中。
     	*3. 在程序的运行期间，某个布局在 Inflate 后，就不会有变化，除非重新启动。
           因为 ViewStub 只能 Inflate 一次，之后会被置空，所以无法指望后面接着使用 ViewStub 来控制布局。所以当需要在运行时不止一次的显示和隐藏某个布局，那么 ViewStub 是做不到的。
           这时就只能使用 View 的可见性来控制了。
     	*4. 想要控制显示与隐藏的是一个布局文件，而非某个 View。因为设置给 ViewStub 的只能是某个布局文件的 Id，所以无法让它来控制某个 View。

    <4> Listview RecyclerView 相关问题 :
		*1. 一个页面图片、视频的异步加载如何实现：
			使用第三方的图片加载库：Glide、Picasso
			Glide 和 Picasso 的区别：（Glide算是Picasso的一个升级）http://www.cnblogs.com/mybkn/articles/2455142.html
				Glide优点：内存占用小（Glide 默认采用 Bitmap 格式是 RGB_565，Picasso 默认采用的 Bitmap 格式是 ARGB-8888），加载图片速度快（可以计算图片大小）、可以加载.gif动态图、自动根据显示图片大小加载图片。
					 Glide 的with()中的参数不单单可以传入 Context、还可以传入 Activity、fragment等，其好处在于图片加载和 Activity/Fragment 的生命周期保持一致。
					 缺点：加载图片质量没有 Picasso 高（Glide 默认采用 Bitmap 格式是 RGB_565，Picasso 默认采用的 Bitmap 格式是 ARGB-8888），会为每一个尺寸的图片都进行缓存（浪费了存储空间），Picasso 只是缓存一张原图片大小
					 
		*2. ListView 和 RecyclerView 的区别：
			recyclerView的优点：
				优点：RecyclerView 是 ListView 的升级版本，更加先进和灵活。
					  可以自定义动画和布局的方向，在以前还需要我们自己写横向滑动的listview。

					  （1）为每个条目位置提供了layout管理器（RecyclerView.setLayoutManager）
					  （2）为每个条目设置了操作动画（RecyclerView.setItemAnimator）（RecyclerView的动画库：https://github.com/wasabeef/recyclerview-animators）
					  RecyclerView.Adapter，比BaseAdapter做了更好的封装，把BaseAdapter的getView方法拆分成onCreateViewHolder方法和onBindViewHolder方法，
					  强制需要创建ViewHolder，这样的好处就是避免了初学者写性能不佳的代码

					  RecyclerView.Adapter 包含了一种新型适配器，其实与以前我们使用的适配器基本类似，只是稍微有所不同，
					  比如viewholder它帮我们封装好了，不用像以前使用listview的适配器一样自己去写viewholder了。所以它的性能比以前应该好了不少

					  RecyclerView 本身它是不关心视图相关的问题的，由于 ListView 的紧耦合的问题，google的改进就是 RecyclerView本 身不参与任何视图相关的问题。
					  它不关心如何将子View放在合适的位置，也不关心如何分割这些子View，更不关心每个子View各自的外观。更进一步来说就是 RecyclerView 它只负责回收和重用的工作，这也是它名字的由来。


				缺点：没有listview那么完善，没添加头、尾视图的功能。
					  需要自己添加分割线
					  没有onItemClick()方法，需要自己进行书写
				
		*3. 有没有考虑 RecyclerView 的兼容低版本的问题：
			RecyclerView 是一个可以替代 Listview 和 Gallery 的有效空间
			google 已经帮我么解决了这个问题，RecyclerVIew 是Android5.0出现的新控件，而且在support-v7中有了低版本支持，所以不用担心低版本的显示问题

		*4. ViewHolder 的好处：http://blog.csdn.net/jacman/article/details/7087995
	 		就是一个持有者的类，他里面一般没有方法，只有属性，作用就是一个临时的储存器，把你getView方法中每次返回的View存起来，可以下次再用。
	 		这样做的好处就是不必每次都到布局文件中去查找你的 View，提高了效率。

	 		ListView 的工作原理：http://blog.csdn.net/bill_ming/article/details/8817172

	 	*5. ListView 解决加载错位问题：
	 		为每一个Item设置一个唯一的 Tag（这个 Tag 一般数据源有关），当需要显示的时候，判断当前 Item 的 Tag 和数据源是否一致，一致则显示，否则不显示。

	 		例如：给 ImageView 设置一个 tag, 并预设一个图片。当 Item1 比 Item8 图片下载的快时， 你滚下去使 Item8 可见，这时 ImageView 的 tag 被设成了
				  Item8 的 URL， 当 Item1 下载完时，由于 Item1 不可见现在的 tag 是 Item8 的 URL，所以不满足条件，
				  虽然下载下来了但不会设置到 ImageView 上, tag 标识的永远是可见 view 中图片的 URL。

	 		// 给 ImageView 设置一个 tag
			holder.img.setTag(imgUrl);
			// 预设一个图片
			holder.img.setImageResource(R.drawable.ic_launcher);
			

			// 通过 tag 来防止图片错位
			if (imageView.getTag() != null && imageView.getTag().equals(imageUrl)) {
			    imageView.setImageBitmap(result);
			}
			
		*6. ListView 如何实现view的复用的：
			假如一个屏幕显示7个Item，当item1滑动出屏幕后，item8从下面滑动出来，此时又要调用getview，但是此时的converview已经不再为空了（因为它和Item1的ViewType相同），
			而是上次一划出屏幕的item1，此时我们只需要重新修改下item1的数据，而不必重新创建一个新的view。

		*7. ScrollView 里嵌套 ListView，ListView 只会显示一条数据，显示不全，产生了滑动冲突，解决方法：
			自定义 ListView，重写其 onMeasure()方法，重新测量 ListView 组件的高度和宽度(宽度没有问题，需要重新计算高度)

(6) AndroidManifest 相关问题 :
	<1> AndroidManifest :
		(Android 系统在启动的时候就会抓取到了系统中所有安装的应用信息（解析apk文件的 Manifest 信息），即在 Android 系统的启动过程中就已经解析了系统中安装应用的 AndroidManifest.xml文件并保存起来了)
		其过程如下:

		1.在 SystemServer 进程启动过程中会调用 SystemServer 类的startBootstrapServices方法（主要用于启动ActivityManagerService服务和PackageManagerService服务），
		  然后会在这个方法中会调用 PackageManagerService.main()静态方法，这个方法主要是用来初始化 PackageManagerService 服务并执行相关逻辑的

		2.main方法的实现逻辑主要是创建了一个 PackageManagerService 对象，并将这个对象添加到 ServierManager 中为其他组件提供服务。

		3.在创建 PackageManagerService 对象时，会扫描下面几个目录中的.apk文件,然后如果是apk文件则调用scanPackageLI方法，scanPackageLI方法的名字很明显，就是用于解析这个apk文件的。(Android 系统启动过程中解析 Manifest 的流程是通过 PackageManagerService 服务来实现的)
			/system/framework
		    /system/app
		    /vendor/app
		    /data/app
		    /data/app-private

			上面5个目录是 Android 系统中存放apk的目录，Android 系统启动时会默认扫描并解析这几个目录下的apk文件。
			也就是说如果我们android手机在其他的目录下存在apk文件系统是不会默认解析的，
			反过来说，如果我们把我们的apk文件移动到这几个目录下，那么重新启动操作系统，该apk文件就会被系统解析并执行相关的逻辑操作。

		4.在scanPackageLI()方法中创建了一个 PackagerParser 对象，并调用了parsePackage()方法，这个方法其实就是解析 Manifest 的主要方法

		5.在parsePackage()方法中调用parseMonolithicPackage()方法，在parseMonolithicPackage()方法中调用parseBaseApk()方法进行 AndroidManifest.xml 文件的解析

		uses-sdk : 编译SDK的要求。
			比如：<uses-sdk
	                      android:minSdkVersion="15"
	                      android:targetSdkVersion="16"/>
	        前者是最小的SDK版本要求，后者是目标编译版本要求，跟project.properties中的target的API级别要一致，否则该应用不会运行在相应版本OS上。

	    meta-data : http://blog.csdn.net/qq396371485/article/details/50594986(不清楚到底是干什么用，存储数据为什么要这样嘞)

	<2> Style 和 Theme 的使用:
		Style 和 Theme 只是应用范围不同：
			Style 应用于某一控件，Theme 应用于整个应用或者某个 Activity

		1.如果想把整个项目的 Button 背景颜色、EditText 的字体颜色、背景颜色等统一设置：
			在 res --> values --> styles.xml --> 建立一个style --> 将这个style设置到 Application 的 theme属性。
			<!-- Base application theme. -->
		    <style name="AppTheme.Base" parent="Theme.AppCompat.DayNight.NoActionBar">
		        <!-- Customize your theme here. -->
		        <!--导航栏底色-->
		        <item name="colorPrimary">@color/primary</item>

		        <!--状态栏底色-->
		        <item name="colorPrimaryDark">@color/primary_dark</item>

		        <!--导航栏上的标题、菜单栏文本颜色-->
		        <item name="android:textColorPrimary">@color/text_primary</item>
		        <item name="titleTextColor">@color/white</item>
		        <item name="android:actionMenuTextColor">@color/white</item>

		        <!--（例如按钮）选中或者点击获得焦点后的颜色-->
		        <item name="colorAccent">@color/theme_accent_1</item>

		        <!--和 colorAccent相反，正常状态下(例如按钮）的颜色-->
		        <item name="colorControlNormal">@color/text_color_3</item>
		        <item name="colorControlActivated">@color/theme_accent_2</item>

		        
		        <!--Button按钮正常状态颜色-->
		        <item name="colorButtonNormal">@color/primary</item>

		        <!--EditText 输入框中字体的颜色-->
		        <item name="editTextColor">@color/body_text_1</item>
		        <item name="android:textColorHint">@color/body_text_3</item>
		        <item name="android:editTextColor">@color/body_text_1</item>
		        <item name="navigationIcon">@mipmap/ic_up</item>
		        <item name="android:actionMenuTextAppearance">@style/MenuTextStyle</item>

		        <!--Activity窗口的颜色-->
		        <item name="android:windowBackground">@android:color/transparent</item>
		        <item name="android:windowAnimationStyle">@android:style/Animation</item>
		        <item name="android:windowIsTranslucent">true</item>

		        <!--<include_recyclerview name="android:editTextBackground">@drawable/selector_edit_text</include_recyclerview>
		        <include_recyclerview name="android:editTextStyle">@style/Widget.App.EditText</include_recyclerview>-->

		    </style>
		2.可以设置某一个 Activity 的主题
		3.可以设置某一控件的 Style

	<3> 自定义权限(当 B 应用启动 A 应用的组件（可以是 Activity，Service，BroadcastReceiver 等）时，如果没有设置权限，那么将无法使用。那么就需要给 A 应用制定的组件设置一个Permission就可以了。)
		得先自定义一个权限，才有自定义权限可以被使用。
		首先需要在应用 A 中自定义一个权限 :
			<?xml version="1.0" encoding="utf-8"?>
			<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.example.flyko.myapplication" >
				<permission android:name="com.coldwind.permission.mypermission" android:protectionLevel="normal"/>
				<permission-group android:name="com.coldwind.permission.mypermission.group" android:protectionLevel="normal"/>
				<permission-tree android:name="com.coldwind.permission.mypermission.tree" android:protectionLevel="normal"/>
			</manifest>
		在 A 应用的对应 Activity 声明权限
			<activity
			    android:permission="com.coldwind.permission.mypermission"

			    android:name=".MainActivity"
			    android:theme="@style/AppBaseTheme">
			</activity>

		第一步 : 在 B 应用中使用时，先在 B 的 AndroidManifest.xml文件声明要使用的权限。
			<?xml version="1.0" encoding="utf-8"?>
			<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.example.cold2wind.myapplication" >
			    <uses-permission android:name="com.coldwind.permission.mypermission" />
			</manifest>
		第二步 : 
			public class MainActivity extends Activity {
			    @Override
			    public void onCreate(Bundle savedInstanceState) {
			       super.onCreate(savedInstanceState);
			       setContentView(R.layout.main);

			       ((Button) findViewById(R.id.button1))
			              .setOnClickListener(new View.OnClickListener() {
			                  @Override
			                  public void onClick(View v) {
			                     Intent intent = new Intent();
			                     //声明权限
			                     intent.setClassName("packageName",
			                            "com.coldwind.permission.mypermission");
			                     startActivity(intent);
			                  }
			              });
			    }
			}

(7) 第三方相关问题 :
	<1> 极光推送的步骤：http://jingyan.baidu.com/article/39810a238900e7b636fda636.html

	<2> umeng第三方登录以及分享到各个平台

(8) App 安装、启动过程及相关问题 :
	<1> APK 安装过程发生了哪些事情：http://blog.csdn.net/wh_19910525/article/details/7909686

	<2> 一个App启动发生了哪些事情：http://oncenote.com/2015/06/01/How-App-Launch/

	<3> 如何测试哪一个app耗电

	<4> 应用安装的路径和流程：

		应用安装涉及到如下几个目录：
			system/app : 系统自带的应用程序，无法删除
	 		data/app : 用户程序安装的目录，有删除权限。安装时把apk文件复制到此目录
	 		data/data : 存放应用程序的数据
	 		Data/dalvik-cache : 将apk中的dex文件安装到dalvik-cache目录下(dex文件是dalvik虚拟机的可执行文件,其大小约为原始apk文件大小的四分之一)
	 
	    安装过程：复制APK安装包到data/app目录下，解压并扫描安装包，把dex文件(Dalvik 字节码)保存到dalvik-cache目录，并data/data目录下创建对应的应用数据目录。

	    卸载过程：删除安装过程中在上述三个目录下创建的文件及目录。

(9) Bar 类问题 :
	<1> Android ActionBar 的使用：http://blog.csdn.net/yuxlong2010/article/details/9299507
		*1.Menu 的使用(里面有很多 Item 自己实现一下)(官方文档)
			-- 搜索栏
			-- 分享操作栏

		*2.ActionBar 实现导航条样式(官方文档有)  -- viewPager 和 Fragment 搭配也可以实现

(10) Android Network(网络) 有关 :
	<0> 网络常识:
		*1.http 协议承载于 TCP 协议之上，默认端口号80.
		   https(承载于 ssl 和 tcl 之上)，默认端口号443.

		*2.URL : 同一资源定位符

		*3.Android 几种网络请求的方式:
			UrlHttpConnection : 最原始的方式，通过输入输出流进行交互
			Apache HttpClient : Apache 提供的，使用起来更简单
			Volley(2013年谷歌官方推荐的网络通信框架) : 适用于数据量不大，交互频繁(大数据量效果较差)
				StringRequest : 返回的数据格式是字符串
				JsonRequest : 返回的数据格式是 json
				ImageRequest : 返回是 Bitmap 格式
					ImageLoader : 底层用 ImageRequest 实现，它比 ImageRequest 更加高效，可以进行图片的缓存以及过滤掉重复链接
					NetworkImageView : 可以加载网络图片的一个控件
			Android-async-http(基于 HttpClient) : 数据量大小都可以，没有做缓存
			WebService : 是一种基于soap协议的远程调用标准，通过 WebService 可以将不同操作系统平台、不同技术、不同语言整合到一起

		*4.请求方式 :
			get : 大小不能超过4K，速度快，参数会在 Url 上显示，不安全
			post : 大小不限制，速度稍慢，参数不会在 Url 上显示，安全性高

	<1> httpclient如何设置结束时间

	<2> java socket机制

(11) Android 服务 :
	<1>.收发短信(ssm)的服务

	<2>.电话服务(TelephonyManager 其中有很多方法，可以获得手机的很多信息)
		*1.监听来电状态

		*2.监听来电显示

(12) Android 动画 (平移(Translate)、旋转(Rotate)、伸缩(Scale)、渐变(Alpha)) :
	<0>.动画的类型: 
		补间动画，
		帧动画，
		属性动画(用的较多，3.0 以后新加入的) : ObjectAnimarot, ValuesAnimator

		插值器 : 系统提供的
	
	<1>.Android 创建动画的方式 :
		*1. 通过res/animator文件夹下创建xml的方式进行加载(官方推荐)
		*2. 通过代码的方式

(13) 数据解析(xml,json)
	<1>.xml 解析方式 :
		*1.DOM 方式
		*2.SAX 方式
		*3.PULL 方式(Android 应用的)

	<2>.json
		解析 Json 数据 :
			*1.谷歌的 Gson
			*2.jsonReader 解析

		生成 Json 数据 :
			*1.谷歌的 Gson
			*2.JsonObject、JsonArray

(14) 一些工具类的问题 :
	<1> Dialog(AlertDialog, DialogFragment , ProgressDialog)的使用：
			一般的 AlertDialog：http://blog.csdn.net/flyfight88/article/details/8602162
			DialogFragment(一些优点)：http://blog.csdn.net/lmj623565791/article/details/37815413/

	<2> Toast 显示文字、图片、图文：
		显示图片：
			Toast t = new Toast(this);
			ImageView iv = new ImageView(this);
			iv.setImageResource(R.drawable.cat);
			t.setView(iv);
			t.show();

(15) 其他 :
	<1> Android 中的定时任务一般有两种实现方式：
 		一种是使用 Java API 里提供的 Timer 类 （不太实用于长期在后台运行的定时任务，为了电池的耐用，每种手机都有自己的休眠策略，当手机CPU休眠时，使用Timer的定时任务则无法正常运行）
 		一种是使用 Android 的 Alarm 机制(AlarmManager)  (Alarm 机制有唤醒CPU的功能，因此不存在上述 Timer 无法执行的情况)

 	<2> Android 为每个应用程序分配的内存大小是多少？（美团）
		android程序内存一般限制在16M，也有的是24M

	<3> 低版本SDK实现高版本api（小米）
		自己实现或@TargetApi annotation

	<4> Android 获取Context
		*1.getApplicationContext():应用程序上下文，作用域为整个APP
		*2.this:当前对象(当前界面的上下文)

	<5> Notification : 一般的通知是非常驻通知，下拉后可以删除掉。常驻通知下拉后不可以删除掉！

	<6> marginLeft = "-8dp" : 向左移动8dp

	<7> 什么情况导致oom（乐视、美团）：http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0920/3478.html
		1.使用更加轻量的数据结构 
		2.Android 里面使用 Enum 
		3.Bitmap 对象的内存占用 
		4.更大的图片 
		5.onDraw方法里面执行对象的创建 
		6.StringBuilder

(16) AndroidStudio :
	<1> AndroidStudio 一个工程下有多个Model，
		如果一个Model是以library的形式出现，则build.gradle设置成apply plugin: 'com.android.library'
		如果一个MOdel是主Model，则build.gradle设置成apply plugin: 'com.android.application