package com.BookMyShow.demo.Controller;

import com.BookMyShow.demo.DTO.BookMovieResponseDTO;
import com.BookMyShow.demo.DTO.BookMoviewRequestDTO;
import com.BookMyShow.demo.Model.Booking;
import com.BookMyShow.demo.Model.BookingResponsestatus;
import com.BookMyShow.demo.Service.BookingService;

public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService)
    {
        this.bookingService=bookingService;
    }
     BookMovieResponseDTO bookMovieResponseDTO=new BookMovieResponseDTO();


    public BookMovieResponseDTO bookMovie(BookMoviewRequestDTO bookMoviewRequestDTO)
    {

        try{

            Booking booking=bookingService.bookMovie(bookMoviewRequestDTO.getUserid(),
                    bookMoviewRequestDTO.getShowId(),bookMoviewRequestDTO.getShowSeatIds());
            bookMovieResponseDTO.setBookingid(booking.getId());
        bookMovieResponseDTO.setAmount(booking.getAmount());
 bookMovieResponseDTO.setBookingResponsestatus(BookingResponsestatus.SUCCESS);

        }catch(Exception exception)
        {
            bookMovieResponseDTO.setBookingResponsestatus(BookingResponsestatus.FAILURE);
        }

        return bookMovieResponseDTO;


    }

}
