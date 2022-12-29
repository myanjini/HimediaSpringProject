package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client c1 = ctx.getBean(Client.class);
		Client c2 = ctx.getBean(Client.class);
		
		System.out.println("c1 == c2 ==> " + (c1 == c2));
		
		Client c3 = new Client();
		Client c4 = new Client();
		
		System.out.println("c3 == c3 ==> " + (c3 == c4));
	}

}
