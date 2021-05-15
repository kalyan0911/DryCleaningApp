package project.repository;

import java.time.LocalDate;
import java.util.List;

import project.models.Booking;

public interface IBookingRepository {
	Booking addBooking(Booking booking);
	Booking removeBooking(long bookingId);
	Booking updateBooking(long bookingId, Booking booking);
	Booking getBooking(long bookingId);
	List<Booking> getAllBookings();
	List<Booking> getBookingsByDate(LocalDate date);
	List<Booking> getBookingsByCustomer(long customerId);
}