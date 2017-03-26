/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "corretor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Corretor extends Pessoa implements Serializable{
    //perentualComissao
    @NotNull(message = "O percentual de comissão deve ser informado")
    @Column(name = "percentualComissao", columnDefinition = "numeric(3,1)")
    private Double percentualComissao;
    //nomeUsuario
    @Length(max = 30, message = "O nomeUusario não pode ter mais que {max} caracteres")
    @NotNull(message = "O nomeUsuario deve ser informado")
    @NotBlank(message = "O nomeUsuario não pode ser em branco")
    @Column(name = "nomeUsuario", length = 30, nullable = false)
    private String nomeUsuario;
    //senha
    @Length(max = 30, message = "A senha não pode ter mais que {max} caracteres")
    @NotNull(message = "A senha deve ser informado")
    @NotBlank(message = "A senha não pode ser em branco")
    @Column(name = "senha", length = 30, nullable = false)
    private String senha;
    
    public Corretor(){
        
    }

    /**
     * @return the percentualComissao
     */
    public Double getPercentualComissao() {
        return percentualComissao;
    }

    /**
     * @param percentualComissao the percentualComissao to set
     */
    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
