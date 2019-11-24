# 反射：框架设计的灵魂
框架：半成品软件。可以在框架的基础上进行软件开发，简化编码

反射：将类的各个组成部分封装为其他对象，这就是反射机制
   > 好处：
        1.可以在程序运行过程中，操作这些对象。
        2.可以解耦，提高程序的可扩展性。
	
**获取Class对象的方式：**

	1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
	多用于配置文件，将类名定义在配置文件中。读取文件，加载类。
	2. 类名.class：通过类名的属性class获取
	多用于参数的传递
	3. 对象.getClass()：在Object类中定义
	多用于对象的获取字节码的方式
 结论：
	同一个字节码文件再一次程序运行过程中，只会被加载一次，不论通过哪种方式获取的class对象都是同一个。

* Class对象功能：
    * 获取功能：
        1. 获取成员变量
            * Field[] getFields():获取public修饰的成员变量
            * Field getField(String name):获取指定名称的public修饰的成员变量
            
            * Field[] getDeclaredFields():获取所有成员变量，不考虑修饰符
            
                // 忽略访问权限修饰符的安全检查
                       Field b; b.setAccessible(true);
            * Field getDeclaredField(String name)
        2. 获取构造方法
            * Constructor<?>[] getConstructors()
            * Constructor<T> getConstructor(Class<?>... parameterTypes)
            
            * Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
            * Constructor<?>[] getDeclaredConstructors()
        3. 获取成员方法
            * Method[] getMethods()
            * Method getMethod(String name, Class<?>... parameterTypes)
            
            * Method[] getDeclaredMethods()
            * Method getDeclaredMethod(String name, Class<?>... parameterTypes)
        4. 获取类名
            * String getName()
* Field:成员变量
    * 操作：
        1. 设置值
        2. 获取值
        3. setAccessible(true):暴力反射 
  
* Constructor:构造方法
    * 创建对象：
        * T newInstance(Object... initargs)
         
        * 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
    * Method:方法对象
        * 执行方法：
            * Object invoke(Object obj, Object... args)