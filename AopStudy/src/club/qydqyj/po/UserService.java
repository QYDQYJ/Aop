package club.qydqyj.po;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	public void printUser(User user) {
		System.out.println("��ӡUser����" + user);
	}
}
