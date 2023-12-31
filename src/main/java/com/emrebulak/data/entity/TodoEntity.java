package com.emrebulak.data.entity;

import com.emrebulak.auditing.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "todos")
public class TodoEntity extends AuditingAwareBaseEntity implements Serializable {
    //Kullanıcının kayıt ekleme vs değerlerini tutmak için extends AuditingAwareBaseEntityi eklememiz lazım
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",unique = true, nullable = false, insertable = true,updatable = false)
    private Long id;

    @Column(name = "Title",length = 500, columnDefinition = "varchar(500) default 'Değer girilmedi'")
    private String title;

    @Column(name = "Done", length = 10, columnDefinition = "varchar(10) default 'Boş'")
    private String done;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;
}
