package com.emrebulak.business.dto;

import com.emrebulak.auditing.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

public class TodoDto extends AuditingAwareBaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    @NotEmpty(message = "{title.validation.constraints.NotNull.message}")
    private String title;

    @NotEmpty(message = "{done.validation.constraints.NotNull.message}")
    private String done;

}
