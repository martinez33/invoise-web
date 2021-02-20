package com.mycompany.invoise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiseWebApplication {

	public static void main(String[] args) {

		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
		InvoiceControllerInterface invoiceControllerInterface = applicationContext.getBean(InvoiceControllerInterface.class);//soit par l'id du Bean
		invoiceControllerInterface.createInvoice();*/

		SpringApplication.run(InvoiseWebApplication.class, args);
	}

}
