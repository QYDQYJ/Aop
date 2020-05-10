package club.qydqyj.springaop1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import club.qydqyj.po.User;

@Aspect
@Component
@Order(2)
public class Aspect2 {
	@Pointcut("execution(* club.qydqyj.po.UserService.printUser(..))")
	public void print() {
	}
	
//	@Around("print()")
//	public void around(ProceedingJoinPoint jp) {
//		System.out.println("around before...");
//		try {
//			jp.proceed();
//		} catch (Throwable e) {
//			throw new RuntimeException();
//		}
//		System.out.println("around after...");
//	}
	
	@Before("execution(* club.qydqyj.po.UserService.printUser(..))&&args(user)")
	public void before(User user) {
		System.out.println("Aspect2 before()"+user);
	}

	@After("print()")
	public void after() {
		System.out.println("Aspect2 after()");
	}

	@AfterReturning("print()")
	public void afterReturning() {
		System.out.println("Aspect2 afterReturning()");
	}

	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("Aspect2 afterThrowing()");
	}
}
