package project.services;
import java.time.LocalDate;
import java.util.List;

import project.exception.NotFoundException;
import project.models.*;

public interface IBookingService {
	Booking addBooking(Booking booking);
	Booking removeBooking(long bookingId) throws Exception;
	Booking updateBooking(long bookingId, Booking booking)throws NotFoundException;
	Booking getBooking(long bookingId) throws Exception;
	List<Booking> getAllBookings();
	List<Booking> getBookingsByDate(LocalDate date);
	List<Booking>getBookingsByCustomer(String customerId)throws Exception;
}
