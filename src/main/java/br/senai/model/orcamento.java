package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity(name = "orcamento")
public class orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=500)
    @NotNull
    private String tipo_evento;

    @NotNull
    @Size(max=50)
    private String tipo_serv;

    @NotNull
    @Size(max=50)
    private String local_recep;

    @OneToMany
    private List<Evento> eventos;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo_evento() {
        return tipo_evento;
    }
    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    public String getTipo_serv() {
        return tipo_serv;
    }
    public void setTipo_serv(String tipo_serv) {
        this.tipo_serv = tipo_serv;
    }
    public String getLocal_recep() {
        return local_recep;
    }
    public void setLocal_recep(String local_recep) {
        this.local_recep = local_recep;
    }

    @Override
    public java.lang.String toString() {
        return "orcamento{" +
                "id=" + id +
                ", tipo_evento='" + tipo_evento + '\'' +
                ", tipo_serv='" + tipo_serv + '\'' +
                ", local_recep='" + local_recep + '\'' +
                ", eventos=" + eventos +
                '}';

    }
}





