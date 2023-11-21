package br.gov.sp.fatec.springboot3labiv.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dcn_dicionario")
public class Dicionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dcn_id")
    private Long id;

    @Column(name = "dcn_verbete")
    private String verbete;

    @Column(name = "dcn_significado")
    private String significado;

    @Column(name = "dcn_versao")
    private Integer versao;

    @Column(name = "dcn_data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Column(name = "dcn_data_hora_revisado")
    private LocalDateTime dataHoraRevisado;

    public Dicionario() {}

    public Dicionario(String verbete, String significado, LocalDateTime dataHoraCadastro) {
        this.verbete = verbete;
        this.significado = significado;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVerbete() {
        return verbete;
    }

    public void setVerbete(String verbete) {
        this.verbete = verbete;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraRevisado() {
        return dataHoraRevisado;
    }

    public void setDataHoraRevisado(LocalDateTime dataHoraRevisado) {
        this.dataHoraRevisado = dataHoraRevisado;
    }

}
