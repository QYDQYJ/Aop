package club.qydqyj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler{
/*
 * 1、before(Object obj)
 * 2、bean方法
 * 3、after(Object obj)
 * 4、没有异常afterReturning(Object obj),出现异常afterThrowing(Object obj)
 * 
 * 
 */
	/*
	 * 
	 * 第三个参数要实现InvocationHandler接口，并且在invoke()方法中调用Interceptor的各个方法
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(T obj, Interceptor interceptor) {
		
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new InvocationHandler() {
			//真实对象
			final Object target=obj;
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				interceptor.before(target);
				//调用真实对象方法的返回值
				try {
					Object retVal = method.invoke(target, args);
					int i=1/0;
					interceptor.afterReturning(target);
				} catch (Throwable t) {
					interceptor.afterThrowing(target);
				}finally {
					//catch代码块后执行
					interceptor.after(target);
				}
				return null;
			}
		});
	}
	
	public static Interceptor interceptor(Interceptor interceptor) {
		return interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}

}
