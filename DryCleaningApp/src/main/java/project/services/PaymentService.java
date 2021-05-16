package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.models.Payment;
import project.repository.IPaymentRepository;

public class PaymentService implements IPaymentService{
	@Autowired
	private IPaymentRepository paymentRepository;
	
	public Payment addPayment(Payment payment) {
		return paymentRepository.addPayment(payment);	
	}
	
	public Payment removePayment(long id) {
		return paymentRepository.removePayment(id);
	}
	
	public Payment updatePayment(long id, Payment payment) {
		return paymentRepository.updatePayment(id, payment);
	}
	
	public Payment getPaymentDetails(long id) {
		return paymentRepository.getPaymentDetails(id);
	}
	
	public List<Payment> getAllPaymentDetails(){
		return paymentRepository.getAllPaymentDetails();
	}
}