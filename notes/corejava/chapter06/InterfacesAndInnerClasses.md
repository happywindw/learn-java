#Chapter 6: Interfaces and Inner Classes  
###6.1 Interfaces  
-- 接口中的所有方法自动的属于public。因此接口中声明的方法不必加public修饰符。但在继承接口的类中，继承的方法应显示的声明为public。  
-- 接口中可以定义常量，但绝对不能有实例域。  
-- 一个类要实现一个接口，必须在类声明中指定要实现的接口，并且在类中定义该接口的所有方法。