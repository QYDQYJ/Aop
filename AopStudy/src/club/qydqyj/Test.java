package club.qydqyj;

public final class Test {

	public static void main(String[] args) {
		IHelloWorld iHelloWorld=new HelloWorld();
		Interceptor interceptor=new MyInterceptor();
		IHelloWorld proxyIHelloWorld = ProxyBeanFactory.getBean(iHelloWorld, interceptor);
		proxyIHelloWorld.print();
	}

}
