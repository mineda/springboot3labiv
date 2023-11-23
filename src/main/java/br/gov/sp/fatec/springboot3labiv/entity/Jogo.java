package br.gov.sp.fatec.springboot3labiv.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jog_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    private Long id;

    @Column(name = "jog_titulo")
    private String titulo;

    @Column(name = "jog_estudio")
    private String estudio;

    @Column(name = "jog_data_hora_lancamento")
    private LocalDateTime dataHoraLancamento;

    @Column(name = "jog_classificacao")
    private String classificacao;

    @Column(name = "jog_duracao_media")
    private Float duracaoMedia;

    public Jogo() {}

    public Jogo(String titulo, String estudio, LocalDateTime dataHoraLancamento) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.dataHoraLancamento = dataHoraLancamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public LocalDateTime getDataHoraLancamento() {
        return dataHoraLancamento;
    }

    public void setDataHoraLancamento(LocalDateTime dataHoraLancamento) {
        this.dataHoraLancamento = dataHoraLancamento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Float getDuracaoMedia() {
        return duracaoMedia;
    }

    public void setDuracaoMedia(Float duracaoMedia) {
        this.duracaoMedia = duracaoMedia;
    }

}
