package com.mcreation.lalahmode.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "personnebean")
@Scope("prototype")
public class Personne {

	@Autowired
	@Qualifier("testbean2")
	private Test test;

	public Personne() {
		super();
		System.out.println("Constructeur du type Personne");
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
}
