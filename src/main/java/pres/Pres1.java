package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class Pres1 {

	public static void main(String[] args) throws Exception {
		/*
		 * injection des dépendances par instanciation statique
		 */
		/*
		DaoImpl dao=new DaoImpl();
		MetierImpl metier=new MetierImpl();
		metier.setDao(dao);
		System.out.println(metier.calcul());
		*/
		
			Scanner scanner=new Scanner(new File("config.txt"));
			
			String daoClassName=scanner.nextLine();
			Class cDao=Class.forName(daoClassName);
			IDao dao=(IDao) cDao.newInstance();
			
			String metierClassName=scanner.nextLine();
			Class cMetier=Class.forName(metierClassName);
			IMetier metier= (IMetier) cMetier.newInstance();
			
			Method m=cMetier.getMethod("setDao", IDao.class);
			m.invoke(metier, dao);
			
			System.out.println(metier.calcul());
		
	}

}
