#Chapter 4: Object and Classes

###4.1 Introduction to Object-Oriented Programming  
- Java是一种完全符合面向对象程序设计（OOP）范型的语言。在OOP中，不必关心对象的具体实现，只要能够满足用户的基本需求即可。  
- 传统的结构化程序设计通过设计一系列的过程（算法）来解决问题，算法被放在第一位，数据结构在第二位。OOP则调换了这个次序。面向对象更适合解决规模较大的问题。  
- 类（class）是构造对象的模板或蓝图。由类构造（construct）对象的过程称为创建类的实例（instance）。  
- 对象中的数据称为实例域（instance field），操纵数据的过程称为方法（method）。
- 每个对象的实例域的集合被称为这个对象的当前状态（state）。
- 实现封装（encapsulation）的关键在于绝对不能让类中的方法直接的访问其他类的实例域。程序仅通过对象的方法与对象进行交互。  
- 封装赋予了对象“黑盒”特征，这是提高重用性和可靠性的关键。这意味着一个类可以全面的改变数据存储方式，只要仍旧使用同样的方法操纵数据，其他对象就不知道或不介意发生的变化。  
- 对象的三个主要特征：行为（behavior）、状态（state）、标识（identity）。  
- 类之间的三个主要关系：依赖（“uses-a”）、聚合（“has-a”）、继承（“is-a”）。  
  1. 如果一个类的方法需要操纵另一个类的对象，我们就说这个类依赖于另一个类。应尽量减少类之间的依赖关系，也就是降低耦合度。  
  2. 聚合是指一个类对象包含另一个类的对象。
  3. 继承，即is-a关系，表示一个类是另一个类的子集关系。  

###4.2 Using Predefined Classes  
- Java使用构造器（constructor）创建新实例，构造器的名字应与类名相同，通过“new + 构造器”的方法来创建类的实例对象。  
- 对象变量中保存的是对象的引用，二不是实际的对象。  
- 对实例域做出修改的方法称为更改器方法（mutator method），仅访问实例域而不进行修改的方法称为访问器方法（accessor method）。  

###4.3 Defining Your Own Classes  
- 使用public标记类的实例域是一种极不提倡的做法，因为这完全破坏了封装。  
- 关于类的构造器：  
  1. 构造器与类同名  
  2. 每个类可以有一个以上的构造器  
  3. 构造器可以有0个、1个或多个参数  
  4. 构造器没有返回值  
  5. 构造器总是伴随着new操作一起调用  
- 显示参数（explicit）与隐式参数（implicit）：  
  1. 显式参数，就是平时见到的在方法名括号中间的参数，就是所谓能看得见的参数。  
  2. 隐式参数，是在类的方法中调用了类的实例域。这个被调用的实例域就是隐式参数。关键字this表示隐式参数。  
- 注意编写访问器方法时，返回类型不应该是一个可变对象的引用，这会破坏封装。此时可以使用clone。  
- 一个方法可以访问所属类的所有对象的私有数据，这是Java中的一种约定。  
- 使用final修饰的实例域必须在构建对象时进行初始化，并且后续无法修改。  
- 如果一个类的所有方法都不会改变其对象，这种类就是不可变的类，如String类。  
- final修饰符大多用于基本类型或不可变类，修饰可变类时不可变的只是这个类的引用。

###4.4 Static Fields and Methods  
- 定义为static的域将在这个类的所有对象间共享，它属于类而不属于任何独立的对象。  
- 静态变量一般使用较少，静态常量（static final）使用较多。  
- 静态方法不能调用实例域，一般使用类名来调用静态方法。

###4.5 Method Parameters  
- 按值调用（call by value）表示方法接收的是调用者提供的值。而按引用调用（call by reference）表示方法接收的是调用者提供的变量地址。  
- Java在传递参数时总是采用按值调用。

###4.6 Object Construction  
- 如果多个方法有相同的名字、不同的参数，便产生了重载（overloading）。  
- 同一个类中的构造器可以通过this(...)调用另一个构造器。  
- 初始化数据域，除了在声明时赋值和在构造器中设置值之外，海可以通过初始化块（initialization block）进行。  
- 新建类对象时初始化块会先与构造器执行。  
- 调用类的一个构造器的具体处理步骤：  
  1. 所有数据域被初始化为默认值（0，false，null）；  
  2. 按照在类声明中出现的次序，依次执行所有域初始化语句与初始化块；  
  3. 如果构造器第一行调用了第二个构造器，则执行第二个构造器主体；  
  4. 执行这个构造器主体。  
- Java不支持析构器，但可以为任意一个类添加finalize方法回收资源。另外不推荐使用它。

###4.7 Packages  
- Java允许使用包（package）将类组织起来。所有标准的Java包都处于java和javax包层次中。使用包的主要原因是确保类名的唯一性。  
- 一个类可以使用所属包中的所用类，以及其他包中的公有类（public class）。  
- import语句不仅可以导入类，还增加了导入静态方法和静态域的功能。  
- 如果没有在源文件中放置package语句，这个源文件中的类就被放置在一个默认包（default package）中。默认包没有名字。  
- 如果源文件没有放在源文件中指定的包目录下，也可以进行编译。如果它不依赖其他包就不会报错。但是，最终的程序将无法执行，因为虚拟机无法找到这个类文件。

###4.8 The Class Path  
- 类存储在文件系统的子目录中，类的路径必须与包名匹配。

###4.9 Documentation Comments  
- JDK包含一个很有用的工具javadoc，它可以由源文件生成一个HTML文档。

###4.10 Class Design Hints  
- 类的一些设计技巧：  
  1. 一定要保证数据私有。  
  2. 一定要对数据初始化。  
  3. 不要在类中使用过多的基本类型。  
  4. 不是所有的域都需要独立的域访问器和域更改器。  
  5. 将职责过多的类进行分解。  
  6. 类名和方法名要能够体现它们的职责。  
