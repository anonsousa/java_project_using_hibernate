package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Contato contato){
        em.persist(contato);
    }

    public void atualizar(Contato contato){
        em.merge(contato);
    }

    public void excluir(Contato contato){
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);

    }

    public void consultarContatoPorId(Long id){
        Contato contatoConsulta = em.find(Contato.class, id);
        if (contatoConsulta != null){
            System.out.println(contatoConsulta.toString());
        }
        else {
            System.out.println("Contato não encontrado no banco de dados");
        }
    }

    public List<Contato> listTodosOsContatos(){
        //JPQL
        String consulta = "SELECT c FROM Contato c ORDER BY name ASC";

        return em.createQuery(consulta).getResultList();
    }

    public List<Contato> listarContatosPorEmail(String email){
        String consulta = "SELECT c FROM Contato c WHERE email = :email_procurado";

        return em.createQuery(consulta, Contato.class)
                .setParameter("email_procurado", email)
                .getResultList();
    }






























}
