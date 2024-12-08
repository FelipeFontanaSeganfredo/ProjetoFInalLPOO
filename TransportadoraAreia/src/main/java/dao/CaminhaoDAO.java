package dao;

import model.Caminhao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class CaminhaoDAO {

    private EntityManagerFactory emf;

    public CaminhaoDAO() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit"); // Substitua pelo nome da unidade no persistence.xml
    }

  public void salvar(Caminhao caminhao) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        if (caminhao.getId() == null || em.find(Caminhao.class, caminhao.getId()) == null) {
            em.persist(caminhao); // Insere um novo caminhão
        } else {
            em.merge(caminhao); // Atualiza o caminhão existente
        }
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}
    
    public boolean remover(int id) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        Caminhao caminhao = em.find(Caminhao.class, id);
        if (caminhao != null) {
            em.remove(caminhao); // Remove o caminhão encontrado
            em.getTransaction().commit();
            return true;
        }
        return false; // Caminhão não encontrado
    } catch (Exception e) {
        em.getTransaction().rollback();
        e.printStackTrace();
        return false;
    } finally {
        em.close();
    }
}
    
    public List<Caminhao> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Caminhao c", Caminhao.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Caminhao buscarPorMotorista(String motorista) {
    EntityManager em = emf.createEntityManager();
    try {
        return em.createQuery("SELECT c FROM Caminhao c WHERE c.motorista = :motorista", Caminhao.class)
                .setParameter("motorista", motorista)
                .getResultStream()
                .findFirst() // Retorna o primeiro resultado, se houver
                .orElse(null);
    } finally {
        em.close();
    }
}

public Caminhao buscarPorId(int id) {
    EntityManager em = emf.createEntityManager();
    try {
        return em.find(Caminhao.class, id);
    } finally {
        em.close();
    }
}
    
}
