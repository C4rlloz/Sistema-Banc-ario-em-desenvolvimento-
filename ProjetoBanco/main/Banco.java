package main;

import java.util.ArrayList;
import java.util.List;
import bank.Cliente;
import dao.ClienteDao;

public class Banco {
    public static void main(String[] args) {
        
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente(1, "Carlos", "Almirante Tamandaré, 352");
        clientes.add(cliente);

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.salvar(clientes);
        
        List<Cliente> clientesRetorno = new ArrayList<>();
        clientesRetorno = clienteDao.recuperar();

        for(Cliente c : clientesRetorno){
            System.out.println("ID: "+c.getId());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Endereço: "+c.getEndereco());
            System.out.println();
        }

        clienteDao.excluirCliente(2);
        clienteDao.excluirCliente(6);

        Cliente cliente2 = new Cliente(2, "Jorge", "Almondegas, canoa, 45");
        clientes.add(cliente2);

        System.out.println("Executou!");
    
    }
    
}
