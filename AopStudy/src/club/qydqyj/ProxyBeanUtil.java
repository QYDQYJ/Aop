package club.qydqyj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler{
/*
 * 1��before(Object obj)
 * 2��bean����
 * 3��after(Object obj)
 * 4��û���쳣afterReturning(Object obj),�����쳣afterThrowing(Object obj)
 * 
 * 
 */
	/*
	 * 
	 * ����������Ҫʵ��InvocationHandler�ӿڣ�������invoke()�����е���Interceptor�ĸ�������
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(T obj, Interceptor interceptor) {
		
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new InvocationHandler() {
			//��ʵ����
			final Object target=obj;
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				interceptor.before(target);
				//������ʵ���󷽷��ķ���ֵ
				try {
					Object retVal = method.invoke(target, args);
					int i=1/0;
					interceptor.afterReturning(target);
				} catch (Throwable t) {
					interceptor.afterThrowing(target);
				}finally {
					//catch������ִ��
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
