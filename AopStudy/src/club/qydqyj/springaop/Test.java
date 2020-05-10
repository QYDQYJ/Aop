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
		 * @Around�ں�
		 * around before...
before()
��ӡUser����User [id=1, name=qydqyj]
around after...
after()
afterReturning()

		 * @Around��ǰ
		 * 
		 * 
		 * around before...
before()
��ӡUser����User [id=1, name=qydqyj]
around after...
after()
afterReturning()
		 * 
		 * ���ۣ�����֪ͨ�������ﶼһ��
		 * 
		 * 
		 */
	}
}
