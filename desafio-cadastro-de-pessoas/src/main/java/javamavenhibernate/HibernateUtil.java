package javamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory factory = null; //Fábrica de conexão com o hibernate
	
	static {
		init();
	}
	
	private static void init() { //Método inicial que vai ler o arquivo persistence.xml
		
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("java-maven-hibernate");
			}
			
		} catch (Exception e) {
			e.printStackTrace(); //Método para imprimir no console
		}
		
	}
	
	public static EntityManager gEntityManager() {
		return factory.createEntityManager(); //Provê a parte de persistência 
	}
	
	public static Object getPrimaryKey(Object entity) { //Retorna a primary key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
		
	}
}
