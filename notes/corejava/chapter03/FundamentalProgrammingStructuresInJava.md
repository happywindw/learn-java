#chapter 3: Fundamental Programming Structures in Java

###3.1 A Sample Java Program
   
- 类名的命名规范是驼峰式风格。
   
- 源文件的文件名必须与公共类的类名相同，并用.java作扩展名。
   
- 在Java中，每个句子必须用分号结束，注意回车不是语句结束的标志。

###3.2 Comments

1. Java中常见的有三种注释，第一种是 // ，其范围从 // 开始到本行末尾。

2. 第2种以 /* 开始，以 */ 结束，其间的部分均被识别为注释，常用于多行注释的情况。

3. 第3种以 /** 开始，以 */ 结束，常用来自动生成文档。

4. 注意在Java中， /* */注释不能嵌套。

###3.3 Data Types

- Java是一种强类型语言。必须为每一个变量声明一种类型。

- Java一共有8种基本类型，4种整形（byte, short, int, long），2种浮点型（float, double），一种表示unicode字符的char型以及一种表示真值的boolean型。

- Java使用 Infinity（正无穷大），-Infinity（负无穷大），NaN（不是一个数字）来表示溢出和出错的情况，比如 2/0 的结果是Infinity， 0/0 的结果是NaN。

- 上述三个值分别对应 Double.POSITIVE_INFINITY、Double.NEGATIVE_INFINITY 和 Double.NaN。注意任意两个NaN的值认为是不相同的，比较NaN时可以使用 Double.isNaN(x) 方法。

- char类型通常用来表示一个单一的16位Unicode字符，其范围从\u0000到\uffff（65535），它可以存储任何字符。

- boolean类型有两个值：true 和 false，用来判定逻辑条件。整型值和布尔值之间不能进行相互转换。
