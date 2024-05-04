package com.BookMyShow.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMoviewRequestDTO {
    private Long userid;
    private Long showId;
    private List<Long> showSeatIds;
}
