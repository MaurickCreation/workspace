package com.mcreation.lalahmode.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Test test = (Test) context.getBean("testbean");
//		Test test = (Test) context.getBean(Test.class);
		Personne personne = (Personne) context.getBean("personnebean");
//		Personne personne = (Personne) context.getBean(Personne.class);
		System.out.println("Test");
	}
}
