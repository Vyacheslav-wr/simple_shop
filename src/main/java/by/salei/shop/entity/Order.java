package by.salei.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Date date;
    private OrderStatus status;
    private Long user;

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
