package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javamavenhibernate.HibernateUtil;
import model.UsuarioPessoa;

public class DaoGeneric<E> {
	
	private EntityManager entityManager = HibernateUtil.gEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); //Iniciar uma transação
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E updateMerge(E entidade) { //Salva ou atualiza
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	
	}
	
	public E pesquisar(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
	}
	
	public E pesquisar(Long id, Class<E> entidade) {

		E e = (E) entityManager.find(entidade, id);

		return e;
	}
	
	public void deletarPorId(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade); //Método para identificar o Id
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.createNativeQuery("delete from" + entidade.getClass().getSimpleName().toLowerCase() + "where id =" + id).executeUpdate();// Faz o delete
		
		transaction.commit(); //Grava alteração no banco de dados
																										

	}

	

	

}
