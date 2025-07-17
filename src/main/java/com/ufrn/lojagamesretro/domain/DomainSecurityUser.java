package com.ufrn.lojagamesretro.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import com.ufrn.lojagamesretro.core.base.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE pessoa SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class DomainSecurityUser extends BaseEntity {
    @NotBlank
    String nome;
    int idade;
    boolean isAdmin = false;
}
