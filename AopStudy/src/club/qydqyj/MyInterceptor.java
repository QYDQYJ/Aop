package club.qydqyj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{

	@Override
	public void before(Object obj) {
		System.out.println(" before...");
	}

	@Override
	public void after(Object obj) {
		System.out.println("after...");
	}

	@Override
	public void afterReturning(Object obj) {
		System.out.println("afterReturning...");
	}

	@Override
	public void afterThrowing(Object obj) {
		System.out.println("afterThrowing...");
	}
	
}
