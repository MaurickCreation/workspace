package test;
import java.util.*;
import org.jdom.*;
import xml.*;
import donnees.*;
import xml.*;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cuvee c = new Cuvee();
		ArrayList cu = c.getListCuvee();
		for (int i=0;i<cu.size();i++ ){
			c = (Cuvee) cu.get(i);
			c.afficheCuvee();
		}
	}

}
