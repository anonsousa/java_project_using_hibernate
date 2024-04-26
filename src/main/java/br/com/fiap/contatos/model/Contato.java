package br.com.fiap.contatos.model;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "tbl_contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBL_CONTATOS_SEQ")
    @SequenceGenerator(name = "TBL_CONTATOS_SEQ", sequenceName = "TBL_CONTATOS_SEQ", allocationSize = 1)
    private Long id;


    private String name;
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "tipoContato_id")
    private TipoContato tipoContato;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoContato=" + tipoContato +
                '}';
    }
}
