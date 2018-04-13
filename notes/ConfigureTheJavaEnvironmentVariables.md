##Windows系统下环境变量配置

1.安装jdk，完毕后在cmd中输入 java -version 命令后打印了版本号则说明安装成功。

2.在 高级系统设置->高级->环境变量（win7）中进入环境变量配置界面。

3.在【系统变量】中新建JAVA_HOME变量，变量值为实际安装路径（如：D:\Program Files\Java\jdk1.8.0_151）。

4.在【系统变量】中找到CLASSPATH，没有到话就新建。变量名为CLASSPATH，变量值为【.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;】，注意这里一个符号都不能少。

5.在【系统变量】中找到Path，在Path变量的最后添加值【;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;】，这里需注意前后用分号隔开。

6.完成后点击确定按钮保存配置。

7.在cmd中分别输入java和javac命令，若打印出很多命令使用说明则配置成功。

