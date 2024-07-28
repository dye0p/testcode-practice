package sample.cafekiosk.spring.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AbstractMethodError.class)
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime creatDateTime;

    @LastModifiedDate
    private LocalDateTime modifiedDateTime;
}
