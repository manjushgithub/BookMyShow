package com.BookMyShow.demo.DTO;

import com.BookMyShow.demo.Model.BookingResponsestatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {

    private Long bookingid;
    private int amount;
    private BookingResponsestatus bookingResponsestatus;


}
