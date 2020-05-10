package club.qydqyj;

public class ProxyBeanFactory {
	public static <T> T getBean(T obj, Interceptor interceptor) {
		return ProxyBeanUtil.getBean(obj, interceptor);
	}
}
