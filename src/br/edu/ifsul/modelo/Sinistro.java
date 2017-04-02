package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "sinistro")
public class Sinistro implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_sinistro", sequenceName = "seq_sinistro_id", allocationSize = 1)
    private Integer id;
    
    @NotNull(message = "A descrição deve ser informado")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "A cidade deve ser informada")
    @NotBlank(message = "A cidade não pode ser em branco")
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @NotNull(message = "O estado deve ser informado")
    @NotBlank(message = "O estado não pode ser em branco")
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @NotNull(message = "O seguro deve ser informada")
    @ManyToOne
    @JoinColumn(name = "seguro_id", referencedColumnName = "id", nullable = false)
    private Seguro seguro;
    
    public Sinistro(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
