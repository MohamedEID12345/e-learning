package qp.elearning.payment_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private String orderId;
    private Double amount;
    private String currency;
    private String status;
    private Double adminCommission; // عمولة الإداري
    private Double instructorAmount; // مبلغ المدرب
    private String iban; // رقم الـ IBAN للإداري
}
