/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaaplication1.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javaaplication1.domain.Cliente;

/**
 *
 * @author ricke
 */
public class ClienteMapDAO implements IClienteDAO {
    
     private Map<Long, Cliente> map;
    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());

        }

    }

    
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

   
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
    
}
