#Chapter 5: Inheritance

- “is-a”关系是继承的一个明显特征。  
- 继承关系中，已存在的类称为超类（superclass）、基类（base class）或父类（parent class）；新类称为子类（subclass）、派生类（derived class）或孩子类（child class）。  
- 子类调用父类方法需使用super关键字。  
- 子类不能访问父类的私有域，初始化父类的私有域需要调用父类构造器。使用super调用构造器的语句必须是子类构造器中的第一条语句。  
- 若子类没有显式的调用父类的构造器，java会自动调用父类的默认无参构造器。若父类没有默认构造器，会产生编译错误。

###5.1 Classes, Superclasses, and Subclasses  
