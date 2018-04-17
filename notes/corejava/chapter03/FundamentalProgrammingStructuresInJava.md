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

###3.4 Variables  
- 变量名必须是一个以字母开头的由字母或数字构成的序列。变量名大小写敏感且没有长度限制。  
- 变量的声明应尽量靠近第一次使用它的地方，这是一种良好的程序编写风格。  
- 关键字 final 修饰的变量只能被赋值一次，叫做常量，通常常量名使用全大写。  
- 同时使用 static 和 final 修饰的变量叫做类变量，类变量可以被多个类（public时）或者类中的多个方法所使用。

###3.5 Operators  
- 合法且不会损失精度的数值类型转换：byte -> short -> int -> long， char -> int，int -> double。  
- 合法但可能损失精度的数值类型转换：int -> float，long -> float，long -> double。  
- 两种不同数值类型的数进行二元操作时（如 n + f，n=9，f=3.44f），会先将两个操作数转换为同一种类型，再进行计算：  
	1.如果2个操作数中有一个是double类型，另一个就会被转换为double类型;  
	2.否则，如果其中一个操作数是float类型，另一个操作数会被转化为float类型；  
	3.否则，如果其中一个操作数是long类型，另一个操作数会被转化为long类型；  
	4.否则，都转换为int类型。  
	
###3.6 Strings  
- 使用 + 拼接一个String和一个非String对象时，后者被转化为String，任何对象都可以被转换为String。  
- 比较字符串相等需调用 equals 方法。 == 只能用来确定两个字符串是否放置在同一个位置上，也就是引用相同。  
- Java字符串由char序列组成。char数据类型是一个采用UTF-16编码表示Unicode代码点的代码单元。大多数常用的Unicode字符使用一个代码单元就可以表示。而辅助字符字符需要一对代码单元来表示。  
- 代码点（code point）是指与一个编码表中的某个字符对应的代码值。
- length方法将返回采用UTF-16编码表示的给定字符串所需要的代码单元数量。获取代码点的数量需使用codePointCount(s, e)方法。  
- 获取一个字符串中第i个代码点： int index = 'sss'.offsetByCodePoints(0, i); int cp = 'sss'.codePointAt(index);  。  
- 使用多个短字符串构建一个长字符串时，应使用StringBuilder类来提高效率。普通的连接方式会产生新的对象，效率比较低下。另外StringBuffer类允许多线程操作。

###3.7 Input and Output  
- 控制台输入使用Scanner类，控制台密码输入应使用Console类。  
- 文件读取可以使用Scanner类，文件写入使用PrintWriter类。

###3.8 Control Flow  
- 在循环中以 两个浮点数是否相等 作为退出条件时需要格外小心。由于浮点数计算存在舍入误差的原因，可能造成死循环。  
- 循环中使用带标签的break语句跳出多重循环，标签必须放在希望跳出的最外层循环之前，并且必须紧跟一个冒号。  
- 标签实际上可以应用到任何语句中，比如if或者语句块。这很类似goto语句的作用，但只能跳出语句块，不能跳入。另外并不提倡这种使用方式。  
- continue也有带标签的形式，将跳到与标签匹配的循环首部。  
- break和continue语句完全是可选的，即使不使用它们也可以表达同样的逻辑含义。

###3.9 Big Numbers  
- BigInteger 和 BigDecimal 类可以处理包含任意长度数字序列的数值。BigInteger类实现了任意精度的整数运算，BigDecimal实现了任意精度的浮点数运算。
