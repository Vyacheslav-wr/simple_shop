package by.salei.shop.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {

    private Long id;
    private Date date;
    private OrderStatus status;

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
