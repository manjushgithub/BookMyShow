package com.BookMyShow.demo.Repositeries;

import com.BookMyShow.demo.Model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);
    //find the all the showseats by the showsetaids


    @Override
 ShowSeat  save(ShowSeat showSeat);
    //save=update+insert
    //if the showseat objects that we are passing in the input,isnt there in the DB
    //then insert it in the db
    //if showseat object is present in the DB,then update the object in the DB

}
