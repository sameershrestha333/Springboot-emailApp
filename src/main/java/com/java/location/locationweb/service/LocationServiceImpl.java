package com.java.location.locationweb.service;

import com.java.location.locationweb.entites.Location;
import com.java.location.locationweb.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);

    }

    @Override
    public Optional<Location> getLocationById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAllLocation() {
        locationRepository.findAll();
        return locationRepository.findAll();
    }

    @Override
    public List<Object[]> findTypeAndTypeCount() {
        return locationRepository.findTypeAndTypeCount();
    }
}
