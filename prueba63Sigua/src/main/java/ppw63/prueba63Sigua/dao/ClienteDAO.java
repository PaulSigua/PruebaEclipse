package ppw63.prueba63Sigua.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ppw63.prueba63Sigua.model.Cliente;

import java.util.List;


// Objetos sin estado
@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}

	public Cliente read(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}

	public List<Cliente> getAll(){
		// Cliente no es una tabla, es una entidad
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	public Cliente getClientePorCedula(String cedula) {
		String jpql = "SELECT c FROM Cliente c WHERE c.dni = :cedula";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		List<Cliente> clientes = q.getResultList();
		if(clientes.size()>0) {
			return clientes.get(0);
		}
		return null;
	}
}

