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
import model.Carga;

public class CargaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CargaDAO()
    {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }
    
    public void salvar(Carga carga) {
        em.getTransaction().begin();
        em.persist(carga);
        em.getTransaction().commit();
    }

    public void atualizar(Carga carga) {
        em.getTransaction().begin();
        em.merge(carga);
        em.getTransaction().commit();
    }

    public void excluir(Carga carga) {
        em.getTransaction().begin();
        em.remove(em.contains(carga) ? carga : em.merge(carga));
        em.getTransaction().commit();
    }

    public List<Carga> listarTodos() {
        return em.createQuery("SELECT d FROM Carga d", Carga.class).getResultList();
    }
    
    public Carga buscarPorId(Long id) {
        return em.find(Carga.class, id);
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
