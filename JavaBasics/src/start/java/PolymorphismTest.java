package start.java;

/**
 * @author YunTang
 * @create 2020-07-17 10:06
 */

/*
 * 面向对象特征之三：多态性
 *
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 *   对象的多态性：[父类的引用]指向[子类的对象]（或子类的对象赋给父类的引用）例如：Person p1 = new Man(); // 其中Person是Man的父类
 *
 * 3. 多态的使用：虚拟方法调用
 *   有了对象的多态性以后，我们在[编译期]，只能调用父类[Person]中声明的方法，但在[运行期]，我们实际执行的是[子类[Man]重写父类[Person]]的方法。
 *   总结：编译，看左边；运行，看右边。
 *
 * 4.多态性的使用前提：①类的继承关系(没有继承就没有多态) ②方法的重写
 *
 * 5.对象的多态性，只适用于[方法]，不适用于属性（编译和运行都看[左边]）
 *
 * 6.有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法。
 *  子类特有的属性和方法不能调用。
 *
 *  如何才能调用子类特有的属性和方法？
 *	向下转型：使用[强制类型转换符]。Man m1 = (Man)p2;（使用强转时，可能出现ClassCastException的异常）
 *
 *  instanceof关键字的使用
 *
 *      ①a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
 *
 *      ②使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先
 *      进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
 *
 *      ③如果a instanceof A返回true,则a instanceof B也返回true，其中，类B是类A的父类。
 *
 * 7.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中。
 *
 * 8.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量。
 */

public class PolymorphismTest {
}
