# Java-stock-level-montior-gui
Java Stock Level Montior GUI
# 基于Java Swing的仓库订单管理系统

# 实现的功能(Netbeans IDE编写)
- 打开客户端,连接数据库
- 查看低库存的订单
- 查看特定供应商订单
- 查看特定部件
- 查看订单状态和失效日期
- 创建查看删除修改采购订单和采购信息
- 创建查看修改删除库房内容
- 打印支付信息
- 客户端程序不会收到无效输入的影响而崩溃
- 有异常处理

# 具体实现效果图
- Output.png
- PO.png
- POL.png
- SR.png


# 所用mySql数据库的结构
- 数据库结构.png
- PO表CompletedStatus的设计.png 
- PO表status的设计.png 
- PO表结构.png
- POL表结构.png
- SR表结构.png

# 备注
**支持多线程服务器客户端的最终版本失传了，只找到了早期实现版本，见coursework234文件夹，早期版本只完成了PO表和多线程客户端与后台服务器,启动的方法是先要运行ThreadedServer.java，再运行myJFrame.java**
