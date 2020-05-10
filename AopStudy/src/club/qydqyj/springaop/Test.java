package club.qydqyj.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import club.qydqyj.po.User;
import club.qydqyj.po.UserService;

public final class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
		UserService us=ac.getBean(UserService.class);
		User user=new User();
		user.setId(1);
		user.setName("qydqyj");
		us.printUser(user);
		/**
		 * @Around在后
		 * around before...
before()
打印User对象：User [id=1, name=qydqyj]
around after...
after()
afterReturning()

		 * @Around在前
		 * 
		 * 
		 * around before...
before()
打印User对象：User [id=1, name=qydqyj]
around after...
after()
afterReturning()
		 * 
		 * 结论：环绕通知放在哪里都一样
		 * 
		 * 
		 */
	}
}
