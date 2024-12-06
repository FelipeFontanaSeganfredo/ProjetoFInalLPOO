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
import java.util.List;
import model.Destino;

public class DestinoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DestinoDAO() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    public void salvar(Destino destino) {
        em.getTransaction().begin();
        em.persist(destino);
        em.getTransaction().commit();
    }

    public void atualizar(Destino destino) {
        em.getTransaction().begin();
        em.merge(destino);
        em.getTransaction().commit();
    }

    public void excluir(Destino destino) {
        em.getTransaction().begin();
        em.remove(em.contains(destino) ? destino : em.merge(destino));
        em.getTransaction().commit();
    }

    public List<Destino> listarTodos() {
        return em.createQuery("SELECT d FROM Destino d", Destino.class).getResultList();
    }
    
    public List<Destino> listarPorOrdemAlfabetica() {
    return em.createQuery("SELECT d FROM Destino d ORDER BY d.nome ASC", Destino.class)
             .getResultList();
    }

    public List<Destino> listarPorDistancia() {
        return em.createQuery("SELECT d FROM Destino d ORDER BY d.distancia ASC", Destino.class)
                 .getResultList();
    }


    public Destino buscarPorId(Long id) {
        return em.find(Destino.class, id);
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
