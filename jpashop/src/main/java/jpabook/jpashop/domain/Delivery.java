package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Address address;
    private DeliveryStatus staus;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
}
