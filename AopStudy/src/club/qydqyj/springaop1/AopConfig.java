package club.qydqyj.springaop1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"club.qydqyj.springaop1","club.qydqyj.po"})
@EnableAspectJAutoProxy
public class AopConfig {
	
}
