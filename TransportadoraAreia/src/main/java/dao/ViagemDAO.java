package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Viagem;

public class ViagemDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ViagemDAO() {
        emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
        em = emf.createEntityManager();
    }

    /**
     * Salvar uma nova viagem no banco de dados.
     *
     * @param viagem Objeto Viagem a ser salvo.
     */
    public void salvar(Viagem viagem) {
        em.getTransaction().begin();
        em.persist(viagem);
        em.getTransaction().commit();
    }

    /**
     * Atualizar uma viagem existente no banco de dados.
     *
     * @param viagem Objeto Viagem a ser atualizado.
     */
    public void atualizar(Viagem viagem) {
        em.getTransaction().begin();
        em.merge(viagem);
        em.getTransaction().commit();
    }

    /**
     * Excluir uma viagem do banco de dados.
     *
     * @param viagem Objeto Viagem a ser excluído.
     */
    public void excluir(Viagem viagem) {
        em.getTransaction().begin();
        em.remove(em.contains(viagem) ? viagem : em.merge(viagem));
        em.getTransaction().commit();
    }

    /**
     * Buscar todas as viagens no banco de dados.
     *
     * @return Lista com todas as viagens.
     */
    public List<Viagem> listarTodas() {
        return em.createQuery("SELECT v FROM Viagem v", Viagem.class).getResultList();
    }

    /**
     * Buscar uma viagem pelo ID.
     *
     * @param id Identificador da viagem.
     * @return Objeto Viagem correspondente ou null se não encontrado.
     */
    public Viagem buscarPorId(Long id) {
        return em.find(Viagem.class, id);
    }

    /**
     * Fechar os recursos do DAO.
     */
    public void fechar() {
        em.close();
        emf.close();
    }
}
