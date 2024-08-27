package qp.elearning.payment_service.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String orderId;
    private Double amount;
    private String currency;
    private String paymentMethod; // e.g., credit_card, paypal, vodafone_cash
}
