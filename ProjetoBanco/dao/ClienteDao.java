package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import bank.Cliente;

public class ClienteDao {
    
    private final String arquivo = "clientes.txt";

    public void salvar(List<Cliente> clientes) {

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                for(Cliente cliente : clientes){
                        writer.write(cliente.getId()+"; "+cliente.getNome()+"; "+cliente.getEndereco());
                        writer.newLine();
                    }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os clintes: "+e.getMessage());
            e.printStackTrace();
        } finally {

        }
    }
    public List<Cliente> recuperar() {
        
        List<Cliente> clientes = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){

            String linha;
            while((linha = reader.readLine()) != null){
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String endereco = partes[2];
                Cliente cliente = new Cliente(id, nome, endereco);
                clientes.add(cliente);


            }
        } catch (FileAlreadyExistsException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public void excluirCliente(int id){
        
        List<Cliente> clientes = new ArrayList<>();
        clientes = recuperar();

        for (int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i);
        if(cliente.getId() == id){
            clientes.remove(i);
            salvar(clientes);
            return;
        }
        }
        System.out.println("Cliente não encontrado!.");
    }
    public void atualizarCliente(Cliente clienteAtualizado){
        List<Cliente> clientes = new ArrayList<>();
        clientes = recuperar();
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i);
            if(cliente.getId() == clienteAtualizado.getId()){
                clientes.set(i, clienteAtualizado);
                salvar(clientes);
                return;
            }
        }
        System.out.println("Cliente não encontrado!.");
        Sysyem.out.println("Dados do cliente já cadastrado!");
    }
}
