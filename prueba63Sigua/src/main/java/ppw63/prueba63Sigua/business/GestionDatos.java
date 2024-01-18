package ppw63.prueba63Sigua.business;

import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ppw63.prueba63Sigua.dao.ClienteDAO;
import ppw63.prueba63Sigua.model.Cliente;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDAO daoCliente;
	
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0103515111");
		cliente.setNombre("Paul Sigua");
		

		cliente.setCodigo(1);
		cliente.setDni("0103709911");
		cliente.setNombre("Kevin Torres");

		cliente.setCodigo(1);
		cliente.setDni("0103709911");
		cliente.setNombre("Wendy Sigua");

		cliente.setCodigo(1);
		cliente.setDni("0103709911");
		cliente.setNombre("David Sigua");

		cliente.setCodigo(1);
		cliente.setDni("0103709911");
		cliente.setNombre("Leo Sigua");
		
		daoCliente.insert(cliente);
	}
}