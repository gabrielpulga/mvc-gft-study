package com.gft.mvc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo statusTitulo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatusTitulo() {
        return statusTitulo;
    }

    public void setStatusTitulo(StatusTitulo statusTitulo) {
        this.statusTitulo = statusTitulo;
    }
}
