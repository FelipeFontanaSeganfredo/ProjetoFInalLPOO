package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Caminhao;

import java.util.List;

public class CaminhaoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    // Construtor que inicializa o EntityManagerFactory e EntityManager
    public CaminhaoDAO() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    // Método para salvar um novo caminhão
    public void salvar(Caminhao caminhao) {
        em.getTransaction().begin();
        em.persist(caminhao);
        em.getTransaction().commit();
    }

    // Método para atualizar informações de um caminhão existente
    public void atualizar(Caminhao caminhao) {
        em.getTransaction().begin();
        em.merge(caminhao);
        em.getTransaction().commit();
    }

    // Método para excluir um caminhão
    public void excluir(Caminhao caminhao) {
        em.getTransaction().begin();
        em.remove(em.contains(caminhao) ? caminhao : em.merge(caminhao));
        em.getTransaction().commit();
    }

    // Método para buscar um caminhão pelo ID
    public Caminhao buscarPorId(int id) {
        return em.find(Caminhao.class, id);
    }

    // Método para listar todos os caminhões
    public List<Caminhao> listarTodos() {
        return em.createQuery("SELECT c FROM Caminhao c", Caminhao.class).getResultList();
    }

    // Método para listar caminhões disponíveis
    public List<Caminhao> listarDisponiveis() {
        return em.createQuery("SELECT c FROM Caminhao c WHERE c.disponivel = TRUE", Caminhao.class)
                 .getResultList();
    }

    // Fechar os recursos
    public void fechar() {
        em.close();
        emf.close();
    }
}
