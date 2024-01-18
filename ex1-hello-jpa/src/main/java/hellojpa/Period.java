package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}