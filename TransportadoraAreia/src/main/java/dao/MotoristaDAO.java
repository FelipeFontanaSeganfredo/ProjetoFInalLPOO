package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import model.Motorista;

public class MotoristaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public MotoristaDAO() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    public void salvar(Motorista motorista) {
        em.getTransaction().begin();
        em.persist(motorista);
        em.getTransaction().commit();
    }

    public void atualizar(Motorista motorista) {
        em.getTransaction().begin();
        em.merge(motorista);
        em.getTransaction().commit();
    }

    public void excluir(Motorista motorista) {
        em.getTransaction().begin();
        em.remove(em.contains(motorista) ? motorista : em.merge(motorista));
        em.getTransaction().commit();
    }

    public List<Motorista> listarTodos() {
        return em.createQuery("SELECT m FROM Motorista m", Motorista.class).getResultList();
    }

    public Motorista buscarPorId(int id) {
        return em.find(Motorista.class, id);
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
