package arquisoft.ms.Exercises_2B.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "exercises")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long leccion;

    @NotBlank
    private String enunciado;

    @NotBlank
    private String respuesta;

    private String opc1;
    private String opc2;
    private String opc3;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
// id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
// leccion
    public Long getLeccion() {
        return leccion;
    }
    public void setLeccion(Long leccion) {
        this.leccion = leccion;
    }
// enunciado
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

//opc1
    public String getOpc1() {
        return opc1;
    }
    public void setOpc1(String opc1) {
        this.opc1 = opc1;
    }
//opc2
        public String getOpc2() {
        return opc2;
    }
    public void setOpc2(String opc2) {
        this.opc2 = opc2;
    }
//opc3
    public String getOpc3() {
        return opc3;
    }
    public void setOpc3(String opc3) {
        this.opc3 = opc3;
    }

    public String  getRespuesta(){return respuesta;}
    public void setResouesta(String respuesta){this.respuesta=respuesta;}

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}