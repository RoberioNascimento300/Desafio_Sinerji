package javamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;
public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(30);
		pessoa.setLogin("teste");
		pessoa.setNome("Roberio Nascimento 2");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Nascimento");
		pessoa.setEmail("emailteste@hotmail.com");
		
		daoGeneric.salvar(pessoa);
	}
	
	@Test
	public void testeBuscar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		
		pessoa = daoGeneric.pesquisar(pessoa); //Atribuindo o objeto para a pesquisa
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeUpdate() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(99);
		pessoa.setNome("Nome atualizado Hibernate");
		
		pessoa = daoGeneric.updateMerge(pessoa); //Vai lá no banco, salva e retorna o objeto pessoa
		
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeDelete() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		daoGeneric.deletarPorId(pessoa);
		
	}

}
