
package farmacia.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela FORNECEDOR
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"FORNECEDOR\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.Fornecedor")
@EntityListeners({cronapi.database.HistoryListener.class})
@CronappTable(role=CronappTableRole.AUTO)
public class Fornecedor implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Nome")
    @Column(name = "nome", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Cnpj", mask="99.999.999/9999-99;0")
    @Column(name = "cnpj", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cnpj;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Telefone")
    @Column(name = "telefone", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String telefone;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Email")
    @Column(name = "email", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String email;


    /**
    * Construtor
    * @generated
    */
    public Fornecedor(){
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
    public Fornecedor setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome
    * return nome
    * @generated
    */
    public java.lang.String getNome() {
        return this.nome;
    }

    /**
    * Define nome
    * @param nome nome
    * @generated
    */
    public Fornecedor setNome(java.lang.String nome) {
        this.nome = nome;
        return this;
    }
    /**
    * Obtém cnpj
    * return cnpj
    * @generated
    */
    public java.lang.String getCnpj() {
        return this.cnpj;
    }

    /**
    * Define cnpj
    * @param cnpj cnpj
    * @generated
    */
    public Fornecedor setCnpj(java.lang.String cnpj) {
        this.cnpj = cnpj;
        return this;
    }
    /**
    * Obtém telefone
    * return telefone
    * @generated
    */
    public java.lang.String getTelefone() {
        return this.telefone;
    }

    /**
    * Define telefone
    * @param telefone telefone
    * @generated
    */
    public Fornecedor setTelefone(java.lang.String telefone) {
        this.telefone = telefone;
        return this;
    }
    /**
    * Obtém email
    * return email
    * @generated
    */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
    * Define email
    * @param email email
    * @generated
    */
    public Fornecedor setEmail(java.lang.String email) {
        this.email = email;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Fornecedor object = (Fornecedor)obj;
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
