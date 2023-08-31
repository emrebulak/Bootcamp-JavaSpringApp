package com.emrebulak.auditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties(value = {"created_date,updated_date"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
abstract public class AuditingAwareBaseEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "created_user")
    protected String createdUser;

    @CreatedDate
    @Column(name = "created_date")
    protected Date createdDate;

    @CreatedBy
    @Column(name = "updated_user")
    protected String updatedUser;
    @CreatedDate
    @Column(name = "updated_date")
    protected Date updatedDate;

}
