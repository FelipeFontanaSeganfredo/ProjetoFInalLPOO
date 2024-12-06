package dao;

import model.Caminhao;
import jakarta.persistence.*;
import java.util.List;

public class CaminhaoDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CaminhaoDAO() {
        // Inicializa a fábrica de gerenciadores de entidades
        entityManagerFactory = Persistence.createEntityManagerFactory("meu-persistence-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Criar (Create)
    public void salvar(Caminhao caminhao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(caminhao); // Salva o objeto no banco de dados
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Ler (Read)
    public Caminhao buscarPorId(int id) {
        return entityManager.find(Caminhao.class, id); // Busca o Caminhao pelo ID
    }

    public List<Caminhao> listarTodos() {
        TypedQuery<Caminhao> query = entityManager.createQuery("SELECT c FROM Caminhao c", Caminhao.class);
        return query.getResultList(); // Retorna uma lista de todos os caminhões
    }

    // Atualizar (Update)
    public void atualizar(Caminhao caminhao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(caminhao); // Atualiza o objeto no banco de dados
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Deletar (Delete)
    public void deletar(int id) {
        try {
            Caminhao caminhao = buscarPorId(id);
            if (caminhao != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(caminhao); // Remove o objeto do banco de dados
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Fechar a conexão com o banco
    public void fechar() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
