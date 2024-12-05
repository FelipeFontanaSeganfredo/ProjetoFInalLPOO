/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author User PC
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Cliente;

import java.util.List;

public class ClienteService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteService() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public void atualizar(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void excluir(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
        em.getTransaction().commit();
    }

    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public void fechar() {
        em.close();
        emf.close();
    }
    
    public Cliente buscarPorId(Long id) {
    return em.find(Cliente.class, id);
    }
}
