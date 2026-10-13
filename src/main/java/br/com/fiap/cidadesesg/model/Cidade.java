
package br.com.fiap.cidadesesg.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String estado;

    @PositiveOrZero
    private Double indiceReciclagem;

    @PositiveOrZero
    private Double emissaoCo2;

    public Cidade() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEstado() { return estado; }
    public Double getIndiceReciclagem() { return indiceReciclagem; }
    public Double getEmissaoCo2() { return emissaoCo2; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setIndiceReciclagem(Double indiceReciclagem) {
        this.indiceReciclagem = indiceReciclagem;
    }
    public void setEmissaoCo2(Double emissaoCo2) {
        this.emissaoCo2 = emissaoCo2;
    }
}
