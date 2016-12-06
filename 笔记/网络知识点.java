-- 网络协议：
		OSI 七层协议：
			应用层；
			表示层：
			会话层：
			运输层：TCP, UDP
			网络层：ARP, RARP，ICMP，IP
				ARP 协议：地址解析协议，根据IP地址获取MAC地址(物理地址, 硬件地址)的一个 TCP/IP 协议。ARP 命令可用于查询本机 ARP 缓存中 IP 地址和 MAC 地址的对应关系、添加或删除静态对应关系等
				RARP 协议：反向地址转换协议,根据MAC地址获取IP地址。允许局域网的物理机器从网关服务器的 ARP 表或者缓存上请求其 IP 地址
				ICMP 协议：ICMP 协议是一种面向无连接的协议，用于传输出错报告控制信息。它是 TCP/IP 协议族的一个子协议，用于在 IP 主机、路由器之间传递控制消息。
						   控制消息是指网络通不通、主机是否可达、路由是否可用等网络本身的消息。
			数据链路层：
			物理层：
		DNS (域名系统): 因特网上作为域名和IP地址相互映射的一个分布式数据库(DNS 的作用就是将主机名转换成 IP 地址)，DNS 协议运行在 UDP 协议之上
		MAC 地址(物理地址, 硬件地址)：在网络底层的物理传输过程中，是通过物理地址来识别主机的，它一般也是全球唯一的。物理地址跟你的网卡是绑定的。
		第三层网络层负责 IP 地址，第二层数据链路层则负责 MAC 地址。
