/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 10, message = "A placa não pode ter mais que {max} caracteres")
    @NotNull(message = "A palca deve ser informada")
    @NotBlank(message = "A placa não pode ser em branco")
    @Column(name = "placa", length = 10, nullable = false)
    private String palca;
    
    @Length(max = 30, message = "O renavam não pode ter mais que {max} caracteres")
    @NotNull(message = "O renavam deve ser informado")
    @NotBlank(message = "O renavam não pode ser em branco")
    @Column(name = "renavam", length = 30, nullable = false)
    private String renavam;
    
    @Length(max = 20, message = "O modelo não pode ter mais que {max} caracteres")
    @NotNull(message = "O modelo deve ser informado")
    @NotBlank(message = "O modelo não pode ser em branco")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @Length(max = 30, message = "O fabricante não pode ter mais que {max} caracteres")
    @NotNull(message = "O fabricante deve ser informado")
    @NotBlank(message = "O fabricante não pode ser em branco")
    @Column(name = "fabricante", length = 30, nullable = false)
    private String fabricante;
    
    @NotNull(message = "O ano de fabricção deve ser informado")
    @Column(name = "ano_fabricacao", columnDefinition = "numeric(4)")
    private Integer anoFabricacao;
    
    @NotNull(message = "O ano de modelo deve ser informado")
    @Column(name = "ano_modelo", columnDefinition = "numeric(4)")
    private Integer anoModelo;
    
    @NotNull(message = "A pessoa deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id",  nullable = false)
    @ForeignKey(name = "fK_pessoa_id")
    private Pessoa pessoa;
    
    @ManyToMany
    @JoinTable(name = "listaAcessorios",
            joinColumns = @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "acessorios", referencedColumnName = "id", nullable = false))
    List<Acessorios> listaAcessorio = new ArrayList<>();
    
    public Carro(){
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the palca
     */
    public String getPalca() {
        return palca;
    }

    /**
     * @param palca the palca to set
     */
    public void setPalca(String palca) {
        this.palca = palca;
    }

    /**
     * @return the renavam
     */
    public String getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the anoFabricacao
     */
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * @param anoFabricacao the anoFabricacao to set
     */
    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    /**
     * @return the anoModelo
     */
    public Integer getAnoModelo() {
        return anoModelo;
    }

    /**
     * @param anoModelo the anoModelo to set
     */
    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
    
}
