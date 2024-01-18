package ppw63.prueba63Sigua.business;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ppw63.prueba63Sigua.dao.ClienteDAO;
import ppw63.prueba63Sigua.model.Cliente;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;

	public void guardarClientes(Cliente cliente) {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public Cliente getClientePorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		return daoCliente.getClientePorCedula(cedula);
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
}

