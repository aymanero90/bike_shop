package com.globomatics.bike.Repositories;

import com.globomatics.bike.Models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike , Long> {
}
