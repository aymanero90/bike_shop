package com.globomatics.bike.Controllers;

import com.globomatics.bike.Models.Bike;
import com.globomatics.bike.Repositories.BikeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/app/bikes")
public class BikeController {

    @Autowired // inject the repository in the controller
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list(){
        List<Bike> bikes = bikeRepository.findAll();
        return bikes;
    }

    @RequestMapping("{id}")
    public Bike get(@PathVariable("id") Long id) {
        Bike bike = bikeRepository.getOne(id);
        return bike;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Bike create(@RequestBody Bike bike ){
        return bikeRepository.saveAndFlush(bike);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Bike update (@RequestBody Bike bike, @PathVariable Long id){
        Bike current_bike = bikeRepository.getOne(id);
        BeanUtils.copyProperties(bike, current_bike, "id"); // copy the new bike to the existing one without changeing the id
        return bikeRepository.saveAndFlush(current_bike);
    }
}
