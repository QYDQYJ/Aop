package club.qydqyj.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import club.qydqyj.po.User;

@Aspect
public class UserAspect {
	@Pointcut("execution(* club.qydqyj.springaop.UserService.printUser(..))")
	public void print() {
	}
	
	@Around("print()")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("around before...");
		try {
			jp.proceed();
		} catch (Throwable e) {
			throw new RuntimeException();
		}
		System.out.println("around after...");
	}
	
	@Before("execution(* club.qydqyj.springaop.UserService.printUser(..))&&args(user)")
	public void before(User user) {
		System.out.println("before()"+user);
	}

	@After("print()")
	public void after() {
		System.out.println("after()");
	}

	@AfterReturning("print()")
	public void afterReturning() {
		System.out.println("afterReturning()");
	}

	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("afterThrowing()");
	}
}
