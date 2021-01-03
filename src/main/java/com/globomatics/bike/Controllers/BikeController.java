package com.globomatics.bike.Controllers;

import com.globomatics.bike.Models.Bike;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/app/bikes")
public class BikeController {

    @GetMapping
    public List<Bike> list(){
        List<Bike> bikes = new ArrayList<Bike>();
        return bikes;
    }

    @RequestMapping("{id}")
    public Bike get(@PathVariable("id") Long id) {
        Bike bike = new Bike();
        return bike;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike, @PathVariable Long id ){
    }
}
