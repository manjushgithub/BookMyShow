package com.BookMyShow.demo.Service;

import com.BookMyShow.demo.Exception.InvalidUserException;
import com.BookMyShow.demo.Exception.ShowSeatnotavailaleException;
import com.BookMyShow.demo.Model.*;
import com.BookMyShow.demo.Repositeries.ShowRepositiries;
import com.BookMyShow.demo.Repositeries.ShowSeatRepository;
import com.BookMyShow.demo.Repositeries.UserRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService {

    private UserRepository userRepository;
    private ShowRepositiries showRepositiries;
    private ShowSeatRepository showSeatRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepositiries showRepositiries,
                          ShowSeatRepository  showSeatRepository )
    {
        this.userRepository=userRepository;
        this.showRepositiries=showRepositiries;
        this.showSeatRepository=showSeatRepository;
    }



    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds)
    {

       // return null;
        //Implement the movie booking logic here
        //multiple people shoudn't be able to book th same seat--multi threading part
        /*steps to book movie ticket
         ----acquire lock-----
        1.get the user from user id from db
        2.get rhe show from showid from db
        3.get the list of showseats from showseatids from db
        4.check if all the seats are available or not

        5.if not,throw an exception
        6.if yes, mark the status as blocked.
        7.save the status of seats in the DB as well

        8.create the booking object
        9.save the booking to DB
        10.return the booking
             ---release lock

         */

        Optional<User> optionalUser=userRepository.findById(userId);
        //this method userrespos.findbyid query the database and find user object.
        if(optionalUser.isEmpty())
        {
            throw new InvalidUserException("invalid user");
        }
        User bookedby=optionalUser.get();


        Optional<Show> optionalShow=showRepositiries.findById(showId);
        if(optionalShow.isEmpty())
        {
            throw new InvalidUserException("invalid show");
        }


            Show bookedshow=optionalShow.get();

        List<ShowSeat> showSeats=showSeatRepository.findAllById(showSeatIds)
        //4.check if all the seats are available or not

       // 5.if not,throw an exception;

        for(ShowSeat showSeat:showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatnotavailaleException("showseat with ids " +showSeat.getId() + " isnot available");
            }
        }
        // 6.if yes, mark the status as blocked.

        for(ShowSeat showSeat:showSeats)
        {
            showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED);
            // 7.save the status of seats in the DB as well
            showSeatRepository.save(showSeat);
        }
      //  8.create the booking object
        Booking booking=new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setUser(bookedby);
        booking.setPayments(new ArrayList<>());
        booking.setBookedDate(new Date());
        booking.setCreatedAt(new Date());
        booking.setShowSeats(showSeats);
        booking.setAmount();//here the price logic will be different













        return null;

    }

}
