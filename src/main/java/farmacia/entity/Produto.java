
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
* Classe que representa a tabela PRODUTO
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"PRODUTO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.Produto")
@EntityListeners({cronapi.database.HistoryListener.class})
@CronappTable(role=CronappTableRole.AUTO)
public class Produto implements Serializable {
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
    @CronappColumn(attributeType="INTEGER", label="Código")
    @Column(name = "codigo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer codigo;


    /**
    * @generated
    */
    @CronappColumn(attributeType="DOUBLE", label="Preço de custo")
    @Column(name = "precoCusto", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double precoCusto;


    /**
    * @generated
    */
    @CronappColumn(attributeType="DOUBLE", label="Preço de Venda")
    @Column(name = "precoVenda", nullable = false, unique = false, precision=10, scale=2, insertable=true, updatable=true)
        
        private java.lang.Double precoVenda;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="fk_fornecedor", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Fornecedor fornecedor;


    /**
    * @generated
    */
    @CronappColumn(attributeType="IMAGE_DATABASE", label="Foto")
    @Column(name = "foto", nullable = true, unique = false, insertable=true, updatable=true)
        
        private byte[] foto;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="categoria", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Categoria categoria;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="marca", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Marca marca;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Controlado", defaultValue = "false")
    @Column(name = "controlado", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean controlado = false;


    /**
    * Construtor
    * @generated
    */
    public Produto(){
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
    public Produto setId(java.lang.String id) {
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
    public Produto setNome(java.lang.String nome) {
        this.nome = nome;
        return this;
    }
    /**
    * Obtém codigo
    * return codigo
    * @generated
    */
    public java.lang.Integer getCodigo() {
        return this.codigo;
    }

    /**
    * Define codigo
    * @param codigo codigo
    * @generated
    */
    public Produto setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
        return this;
    }
    /**
    * Obtém precoCusto
    * return precoCusto
    * @generated
    */
    public java.lang.Double getPrecoCusto() {
        return this.precoCusto;
    }

    /**
    * Define precoCusto
    * @param precoCusto precoCusto
    * @generated
    */
    public Produto setPrecoCusto(java.lang.Double precoCusto) {
        this.precoCusto = precoCusto;
        return this;
    }
    /**
    * Obtém precoVenda
    * return precoVenda
    * @generated
    */
    public java.lang.Double getPrecoVenda() {
        return this.precoVenda;
    }

    /**
    * Define precoVenda
    * @param precoVenda precoVenda
    * @generated
    */
    public Produto setPrecoVenda(java.lang.Double precoVenda) {
        this.precoVenda = precoVenda;
        return this;
    }
    /**
    * Obtém fornecedor
    * return fornecedor
    * @generated
    */
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    /**
    * Define fornecedor
    * @param fornecedor fornecedor
    * @generated
    */
    public Produto setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        return this;
    }
    /**
    * Obtém foto
    * return foto
    * @generated
    */
    public byte[] getFoto() {
        return this.foto;
    }

    /**
    * Define foto
    * @param foto foto
    * @generated
    */
    public Produto setFoto(byte[] foto) {
        this.foto = foto;
        return this;
    }
    /**
    * Obtém categoria
    * return categoria
    * @generated
    */
    public Categoria getCategoria() {
        return this.categoria;
    }

    /**
    * Define categoria
    * @param categoria categoria
    * @generated
    */
    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }
    /**
    * Obtém marca
    * return marca
    * @generated
    */
    public Marca getMarca() {
        return this.marca;
    }

    /**
    * Define marca
    * @param marca marca
    * @generated
    */
    public Produto setMarca(Marca marca) {
        this.marca = marca;
        return this;
    }
    /**
    * Obtém controlado
    * return controlado
    * @generated
    */
    public java.lang.Boolean getControlado() {
        return this.controlado;
    }

    /**
    * Define controlado
    * @param controlado controlado
    * @generated
    */
    public Produto setControlado(java.lang.Boolean controlado) {
        this.controlado = controlado;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Produto object = (Produto)obj;
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
