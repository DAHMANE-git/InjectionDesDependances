package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{

	@Override
	public double getData() {
		/*
		 * je me connecte à la bd
		 */
		double data=98;
		return data;
	}
	
	public void init() {
		System.out.println("Instanciation de DaoImpl");
	}

}
