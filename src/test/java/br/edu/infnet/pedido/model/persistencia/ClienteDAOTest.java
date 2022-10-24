package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedido.model.entidade.Cliente;

public class ClienteDAOTest {

	private IDAO clienteDAO = new ClienteDAO();

	@Before
	public void initalize() {
		Cliente cliente = new Cliente("Jose das Couves"); 
		clienteDAO.salvar(cliente);
		Assert.assertTrue(true);
		System.out.println("rodou o before");
	}
	
	@Test
	public void test() {
		IDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Jose das Couves"); 
		boolean validacao = clienteDAO.salvar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaClientes() {
		IDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	
	
	@Test
	public void testDeletarClientes() {
		IDAO clienteDAO = new ClienteDAO();
		
		List<Cliente> todos = clienteDAO.listarTodos();
		
		Boolean retorno = clienteDAO.deletar(todos.get(0));
		Assert.assertTrue(retorno);
	}
	


}
