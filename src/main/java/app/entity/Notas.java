
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela NOTAS
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"NOTAS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Notas")
public class Notas implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "texto", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String texto;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data = Calendar.getInstance().getTime();


    /**
    * Construtor
    * @generated
    */
    public Notas(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Notas setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém texto
    * return texto
    * @generated
    */
    public java.lang.String getTexto() {
        return this.texto;
    }

    /**
    * Define texto
    * @param texto texto
    * @generated
    */
    public Notas setTexto(java.lang.String texto) {
        this.texto = texto;
        return this;
    }
    /**
    * Obtém data
    * return data
    * @generated
    */
    public java.util.Date getData() {
        return this.data;
    }

    /**
    * Define data
    * @param data data
    * @generated
    */
    public Notas setData(java.util.Date data) {
        this.data = data;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Notas object = (Notas)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}