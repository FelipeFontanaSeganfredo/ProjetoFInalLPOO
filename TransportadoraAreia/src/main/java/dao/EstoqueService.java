/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import model.Estoque;

/**
 *
 * @author 20231PF.CC0010
 */
public class EstoqueService {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public EstoqueService() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    public void salvar(Estoque cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public void atualizar(Estoque cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void excluir(Estoque cliente) {
        em.getTransaction().begin();
        em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
        em.getTransaction().commit();
    }

    public List<Estoque> listarTodos() {
        return em.createQuery("SELECT e FROM Estoque e", Estoque.class).getResultList();
    }

    public void fechar() {
        em.close();
        emf.close();
    }
    
    public Estoque buscarPorId(Long id) {
    return em.find(Estoque.class, id);
    }
}
