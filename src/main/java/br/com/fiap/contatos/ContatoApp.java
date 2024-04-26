package br.com.fiap.contatos;

import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.dao.TipoContatoDao;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {
    public static void main(String[] args) {
        EntityManager em = Conexao.getEntityManager();


        //cadastrar(em);
        //atualizar(em);
        //excluir(em);
        //consultarContatoPorId(em);
        //listTodosOsContatos(em);
        //listContatosPorEmail(em);
        consultarTipoContatoPeloId(em);
    }

    private static void consultarTipoContatoPeloId(EntityManager em) {
        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        TipoContato tipoContatoBuscado = new TipoContato();
        tipoContatoBuscado.setId(5L);
        TipoContato tipoContatoEncontrado = new TipoContato();

        tipoContatoEncontrado = tipoContatoDao.buscarTipoContatoPeloId(tipoContatoBuscado);

        System.out.println(tipoContatoEncontrado.getTipo());

        System.out.println(tipoContatoEncontrado.getContatos());

    }




    public static void listContatosPorEmail(EntityManager em){

        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatosPorEmail("tonho@email.com.br");

        for(Contato contato: contatos){
            System.out.println(contato.toString());
        }

        System.out.println("Fim dos registros");

    }



    public static void listTodosOsContatos(EntityManager em){

        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listTodosOsContatos();

        for(Contato contato: contatos){
            System.out.println(contato.toString());
        }

        System.out.println("Fim dos registros");

    }


    public static void cadastrar(EntityManager em){
        TipoContato tipoContato = new TipoContato();
        tipoContato.setId(5L);
        //tipoContato.setTipo("Amigo");

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);

        em.getTransaction().begin();
        //tipoContatoDao.salvar(tipoContato);

        Contato contato = new Contato();
        contato.setName("Tonhão");
        contato.setEmail("tonho@email.com.br");
        contato.setDataNascimento(LocalDate.of(1958, 3, 23));
        contato.setTipoContato(tipoContato);


        ContatoDao contatoDao = new ContatoDao(em);

        contatoDao.salvar(contato);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Contato contato = new Contato();
        contato.setId(3L);
        contato.setName("Tonhassu");
        contato.setEmail("ton@gmail.com.br");
        contato.setDataNascimento(LocalDate.of(1923, 3, 30));


        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();
    }

    public static void excluir(EntityManager em){
        Contato contato = new Contato();
        contato.setId(3L);


        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.excluir(contato);
        em.getTransaction().commit();
    }

    public static void consultarContatoPorId(EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.consultarContatoPorId(8L);
        em.getTransaction().commit();
    }
}
