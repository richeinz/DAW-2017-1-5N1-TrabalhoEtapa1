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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "acessorios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Acessorios implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_acessorio", sequenceName = "seq_acessorio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorio", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @Length(max = 50, message = "A descrção não pode ter mais que {max} caracteres")
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "possuiAcessorio",
            joinColumns = @JoinColumn(name = "acessorio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false))
    private List<Carro> possuiAcessorio = new ArrayList<>();
    
    
    public Acessorios(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrcao() {
        return descricao;
    }

    public void setDescrcao(String descrcao) {
        this.descricao = descrcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
