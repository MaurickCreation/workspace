/**
 * 
 */
package test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author mramilijaona
 *
 */
@Component("testbean")
@Scope("prototype")
public class Test {
	
	@Value(value="chaine test 2")
	private String test;

	public Test() {
		super();
		System.out.println("Constructeur du type Test");
	}

	public Test(String test) {
		super();
		this.test = test;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
}
