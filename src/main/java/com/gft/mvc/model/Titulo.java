package com.gft.mvc.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Titulo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long codigo;

    @NotBlank(message = "Descrição é obrigatória.")
    @Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres")
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data de vencimento não pode ser nula")
    private Date dataVencimento;

    @NotNull(message = "Valor não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01.")
    @DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99.")
    @NumberFormat(pattern = "#,##0.00")
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

    @Override
    public String toString() {
        return "Titulo{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                ", statusTitulo=" + statusTitulo +
                '}';
    }
}
