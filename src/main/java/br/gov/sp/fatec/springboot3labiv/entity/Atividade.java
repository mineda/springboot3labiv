package br.gov.sp.fatec.springboot3labiv.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atv_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atv_id")
    private Long id;

    @Column(name = "atv_enunciado")
    private String enunciado;

    @Column(name = "atv_data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;


    @Column(name = "atv_data_hora_limite")
    private LocalDateTime dataHoraLimite;

    @Column(name = "atv_peso")
    private Integer peso;

    @Column(name = "atv_observacoes")
    private String observacoes;

    public Atividade() {}

    public Atividade(String enunciado, LocalDateTime dataHoraCadastro, LocalDateTime dataHoraLimite) {
        this.enunciado = enunciado;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraLimite = dataHoraLimite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraLimite() {
        return dataHoraLimite;
    }

    public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
        this.dataHoraLimite = dataHoraLimite;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
