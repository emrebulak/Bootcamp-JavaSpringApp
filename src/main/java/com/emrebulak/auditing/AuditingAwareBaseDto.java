package com.emrebulak.auditing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
abstract public class AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    private Long id;

    @Builder.Default
    private Date systemDate = new Date(System.currentTimeMillis());

    @JsonIgnore
    protected String createdUser;
    @JsonIgnore
    protected Date createdDate;
    @JsonIgnore
    protected String updatedUser;
    @JsonIgnore
    protected Date updatedDate;

}
