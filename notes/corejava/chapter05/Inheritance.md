#Chapter 5: Inheritance

###5.1 Classes, Superclasses, and Subclasses  
- “is-a”关系是继承的一个明显特征。  
- 继承关系中，已存在的类称为超类（superclass）、基类（base class）或父类（parent class）；新类称为子类（subclass）、派生类（derived class）或孩子类（child class）。  
- 子类调用父类方法需使用super关键字。  
- 子类不能访问父类的私有域，初始化父类的私有域需要调用父类构造器。使用super调用构造器的语句必须是子类构造器中的第一条语句。  
- 若子类没有显式的调用父类的构造器，java会自动调用父类的默认无参构造器。若父类没有默认构造器，会产生编译错误。
- this关键字的两个用途：一是引用隐式参数；二是调用该类其他的构造器。  
- super关键字的两个用途：一是调用超类方法；二是调用超类构造器。  
- 一个对象变量可以指示多种实际类型的现象被称为多态（polymorphism）。在运行时能够自动地选择调用哪个方法的现象称为动态绑定（dynamic binding）。  
- 由一个公共超类派生出来的所有类的集合被称为继承层次（inheritance hierarchy）。在继承层次中，从某个特定的类到其祖先的路径被称为该类的继承链（inheritance chain）。  
- 方法的名字和参数列表称为方法的签名。返回类型不是签名的一部分。  
- 动态绑定时若每次都搜索调用方法将十分耗时。因此，虚拟机预先为每个类创建了一个方法表（method table），其中列出了所有方法的签名和实际调用方法。  
- 动态绑定的执行过程：  
  1. 编译器获取对象的声明类型和需要调用的方法名称。提取出该对象实际类型的方法表。  
  2. 虚拟机根据需调用方法的签名搜索应具体调用哪一个方法，这个过程被称为重载解析（overloading resolution）。  
  3. 调用该方法。  
- 静态绑定是指程序调用private、final、static类型的方法或者构造器时，编译器可以准确的知道应该调用哪个方法。  
- 声明为final的类无法被继承，声明为final的方法无法被覆盖。final类中的方法也都是final的，但不包括域。  
- 将一个类或者方法声明为final的主要目的是：确保它们不会在子类中改变语义。  
- 将一个超类的引用赋给一个子类变量时，必须进行类型转换，这样才能通过运行时检查。  
- 对象之间只有通过了instanceof运算符检查的类型转换才能够成功。一般应尽量少用向下的类型转换和instanceof运算符。  
- 只能在继承层次内进行类型转换。  
- 包含一个或多个抽象方法的类本身必须被声明为抽象类。除了抽象方法外，抽象类还可以包含具体数据和具体方法。  
- 一个类即使不包含抽象方法，也可以被声明为抽象类。抽象类不可以被实例化。  
- 控制可见性的4个修饰符：  
  1. private —— 对本类可见；  
  2. public —— 对所有类可见；  
  3. protected —— 对本包和子类可见；  
  4. 不加修饰符 —— 对本包可见。

###5.2 Object: The Cosmic Superclass  
- Object类是Java中所有类的始祖。可以使用Object类型的变量引用任何类型的对象。  
- Object类提供的equals方法会比较两个对象的引用是否相同。实际上我们往往将两个状态相同的对象认为是相等的，这时就需要覆写这个方法。  
- Java规范要求equals方法具有下面的特性：  
  1. 自反性：对于任何非空引用x，x.equals(x)应该返回true。  
  2. 对称性：对于任何引用x和y，当且仅当y.equals(x)返回true，x.equals(y)也应该返回true。  
  3. 传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，x.equals(z)也应返回true。  
  4. 一致性：如果x和y引用的对象没有发生变化，反复调用x.equals(y)应该返回同样的结果。  
  5. 对于任意非空引用x，x.equals(null)应该返回false。  
- 对比两个可能为null的对象时，应该使用Objects.equals(a, b)方法。a==b==null时，返回true，其中一个为null时返回false。都不为null时返回a.equals(b)。  
- 子类的equals方法应该首先调用父类的equals方法。  
- equals方法中getClass()方法与instanceof运算的选择：  
  1. 如果子类拥有自己的equals方法，则根据对称性要求应采用getClass进行检测。  
  2. 如果由超类决定两个对象是否相等，那么就可以使用instanceof进行检测，同时超类的equals方法应声明为final型。  
- 编写一个完美的equals方法：  
  1. 显示参数命名为otherObject，稍后需将它转换成另一个名为other的变量。  
  2. 检测this与otherObject是否引用同一个对象。
  3. 检测otherObject是否为null，为null就返回false。
  4. 比较this与otherObject是否属于同一个类。每个子类都有不同的equals时，就用getClass检测。子类都使用父类的equals方法时就使用instanceof检测。  
  5. 将otherObject转换为相应的类类型变量。
  6. 比较域是否相等，使用==比较基本类型，使用Objects.equals()方法比较对象，数组对象使用静态方法Array.equals()。  
- 注意自己编写的equals方法的显示参数应该声明为Object类型，这样才能覆盖Object类的equals方法。同时应使用@Override标记该方法。  
- 散列码（hash code）是由对象导出的一个整形值。散列码是没有规律的。  
- 如果重新定义equals方法，就必须重新定义hashCode方法，以便用户可以将对象插入到散列表中。  
- hashCode方法应该返回一个整形数值（可以是负数），并合理地组合实例域的散列码，以便能够让各个不同的对象产生的散列码更加均匀。  
- 两个相等的对象必须返回相等的散列码，所以equals方法与hashCode方法必须一致。若equals仅使用ID判定相等，则hashCode同样仅散列ID，而不是对象域的其他值。  
- int Objects.hash(Object... Object)方法返回多个对象组合成的散列码；static Objects.hashCode(a)方法返回对象a的hash code，当a为null时返回0；数组可以使用静态方法Arrays.hashCode()得到对应的散列码。  
- 绝大多数类的toString方法返回值的格式： classname[field1:xxx, field2:xxx, ..., fieldn:xxx]  
- 子类的toString方法应首先调用父类的toString方法（如果有），再补充子类多出的部分。

###5.3 Generic Array Lists  
- ArrayList是一个采用类型参数（type parameter）的泛型类（generic class）。  
- ArrarList管理这对象引用的一个内部数组，当内部数组已满后会自动扩容，扩容方式是将所有对象从较小的数组拷贝到较大的数组中。  
- 若大概能确定数组的容量，可以使用ensureCapacity()方法，这样可以减少重新分配空间的次数。  
- 一旦确定了ArrayList对象的长度不会再发生变化，就可以调用trimToSize()方法。此方法将调整数组大小为当前所需的大小，多余的存储空间将被垃圾回收器回收。  
- 向数组中插入一个元素时，该元素之后的元素都要向后移动一个位置。若插入元素时数组列表的大小超了容量，就会自动重分配空间。  
- 删除时与插入相反，该元素之后的元素都要前移一个位置。插入与删除操作的效率都比较低。  
- 若经常在数组中间插入或删除元素且数组长度较大，应使用链表而非数组列表。

###5.4 Object Wrappers and Autoboxing  
- 所有的基本类型都有一个与之对应的类，这些类称为包装器（wrapper）。  
- 对象包装器类是不可变的，一旦构造了包装器，就不允许更改包装在其中的值。同时包装器类是final的，不允许继承。  
- 定义数组列表ArrayList<...>时，尖括号中不允许放基本类型，这时就可以使用包装器类型。  
- 一个Integer型的ArrayList的效率比int[]的效率低的多，因为每个基本类型都要放在包装器类中。当构造大型基本类型的集合时，应优先考虑数组。  
- 将基本类型转换为包装器类型称为自动装箱（autoboxing），反过来称为自动拆箱。  
- Java规定对包装器类的比较时，若对应基本类型的值相同，就认为相等。  
- 装箱与拆箱是编译器认可的，不是虚拟机。编译器在生成类的字节码时会自动插入必要的方法调用，虚拟机只是执行这些字节码。  

###5.5 Methods with a Variable Number of Parameters  
- JAVA中部分方法的参数数量是可变的，可变的部分实际相当于传入了一个数组。

###5.6 Enumeration Classes  
- 枚举类型（public enum Size{SMALL, MEDIUM, LARGE, EXTRA_LARGE}）实际声明的是一个类，它是Enum类的子类。  
- 如果需要的话，可以在枚举类型中添加一些构造器、方法和域。
