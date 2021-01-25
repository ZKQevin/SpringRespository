import com.org.handler.MyIncationHandler;
import com.org.service.SomeService;
import com.org.service.imp.SomeServiceimp;

import java.lang.reflect.InvocationHandler;

public class Myapp {
    public static void main(String[] args) {
/*        SomeService service=new SomeServiceimp();
        service.doOther();
        service.doSome();
        //不再使用此方法掉用哪个，而去使用代理让其拥有增加的方法
        */
        Object target=new SomeServiceimp();//创建目标对象
        InvocationHandler handler=new MyIncationHandler(target);//创建InvocationHandler对象
        //创建Proxy代理
        SomeService Proxy= (SomeService) java.lang.reflect.Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler
        );
        //通过代理执行方法，会调用handler中的invoke()
        Proxy.doSome();
        //JDK中的动态代理方法实现
        System.out.println(Proxy.getClass());

    }
}