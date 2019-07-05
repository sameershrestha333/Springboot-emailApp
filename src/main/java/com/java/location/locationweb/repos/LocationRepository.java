package com.java.location.locationweb.repos;

import com.java.location.locationweb.entites.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query(value = "select type , count(type) from location Group by type",nativeQuery = true)
    List<Object[]> findTypeAndTypeCount();
}
