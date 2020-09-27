import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: pbb
 * @date: 2020/9/27 22:42
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object object;

    DynamicProxyHandler(Object o){
        this.object = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before buy house");
        Object invoke = method.invoke(object, args);
        System.out.println("after buy house");
        return invoke;
    }
}
