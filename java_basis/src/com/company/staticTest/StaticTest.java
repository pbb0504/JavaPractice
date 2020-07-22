package com.company.staticTest;

/**
 * @author: pbb
 * @date: 2020/7/22 13:19
 */
public class StaticTest {
    public class innerClass {
        innerClass() {
            System.out.println("=========constructor==========");
        }

        public void innerMethod() {
            System.out.println("=========innerMethod==========");
        }
    }

    public static void main(String[] args) {
        // have static
        /*innerClass innerClass = new StaticTest.innerClass();
        innerClass.innerMethod();*/
        // or
       /* innerClass innerClass1 = new innerClass();
        innerClass1.innerMethod();*/

        // no static
        StaticTest staticTest = new StaticTest();
        StaticTest.innerClass innerClass2 = staticTest.new innerClass();
        innerClass2.innerMethod();
        // or
        StaticTest.innerClass innerClass3 = new StaticTest().new innerClass();
        innerClass3.innerMethod();
    }
}
