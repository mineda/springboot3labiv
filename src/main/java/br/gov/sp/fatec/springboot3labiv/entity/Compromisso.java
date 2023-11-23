package br.gov.sp.fatec.springboot3labiv.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cpm_compromisso")
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpm_id")
    private Long id;

    @Column(name = "cpm_nome")
    private String nome;

    @Column(name = "cpm_data_hora")
    private LocalDateTime dataHora;

    @Column(name = "cpm_duracao_prevista")
    private Float duracaoPrevista;

    @Column(name = "cpm_cep")
    private Long cep;

    @Column(name = "cpm_numero")
    private Integer numero;

    public Compromisso() {}

    public Compromisso(String nome, LocalDateTime dataHora, Float duracaoPrevista) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.duracaoPrevista = duracaoPrevista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Float getDuracaoPrevista() {
        return duracaoPrevista;
    }

    public void setDuracaoPrevista(Float duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
}
