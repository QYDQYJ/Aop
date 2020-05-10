package club.qydqyj.springaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("club.qydqyj.springaop")
@EnableAspectJAutoProxy
public class AopConfig {
	@Bean
	public UserAspect getUserAspect() {
		return new UserAspect();
	}
}
