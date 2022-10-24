package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedido.model.entidade.Cliente;

public class ClienteDAOTest {

	private ClienteDAO clienteDAO;

	
	@Before
	public void initalize() {
		clienteDAO = new ClienteDAO();
		clienteDAO.deletar(new Cliente(99L));
		Cliente cliente = new Cliente("Jose das Couves",99L); 
		clienteDAO.salvar(cliente);
		Assert.assertTrue(true);
		System.out.println("rodou o before");
	}
	
	@Test
	public void test() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Jose das Couves"); 
		boolean validacao = clienteDAO.salvar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	
	
	@Test
	public void testDeletarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Boolean retorno = clienteDAO.deletar(new Cliente(99L));
		Assert.assertTrue(retorno);
	}
	


}
