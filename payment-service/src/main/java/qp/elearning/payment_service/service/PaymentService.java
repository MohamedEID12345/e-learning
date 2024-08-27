package qp.elearning.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.payment_service.model.Payment;
import qp.elearning.payment_service.model.PaymentRequest;
import qp.elearning.payment_service.model.PaymentResponse;
import qp.elearning.payment_service.repository.PaymentRepository;

@Service
public class PaymentService {

    private static final double ADMIN_COMMISSION_PERCENTAGE = 0.05;
    private static final String ADMIN_IBAN = "YOUR_ADMIN_IBAN_HERE"; // Replace with actual IBAN

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        double totalAmount = paymentRequest.getAmount();
        double adminCommission = totalAmount * ADMIN_COMMISSION_PERCENTAGE;
        double instructorAmount = totalAmount - adminCommission;



        switch (paymentRequest.getPaymentMethod().toLowerCase()) {
            case "paypal":
                // Integrate with PayPal API
                break;
            case "visa":
            case "mastercard":
                // Integrate with credit card payment gateway
                break;
            case "vodafone_cash":
                // Integrate with Vodafone Cash API
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment method");
        }

        // Simulate saving payment details
        Payment payment = new Payment();
        payment.setOrderId(paymentRequest.getOrderId());
        payment.setAmount(totalAmount);
        payment.setCurrency(paymentRequest.getCurrency());
        payment.setStatus("SUCCESS"); // Or "FAILURE"
        payment.setAdminCommission(adminCommission);
        payment.setInstructorAmount(instructorAmount);
        payment.setIban(ADMIN_IBAN);

        paymentRepository.save(payment);

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId().toString());
        response.setStatus(payment.getStatus());
        response.setMessage("Payment processed successfully");

        return response;
    }
}
