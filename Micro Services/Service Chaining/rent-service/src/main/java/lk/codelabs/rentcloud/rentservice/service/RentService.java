package lk.codelabs.rentcloud.rentservice.service;

import lk.codelabs.rentcloud.model.rent.Rent;
import lk.codelabs.rentcloud.rentservice.model.DetailedResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailedResponse findDetailedResponse(int id) throws ExecutionException, InterruptedException;
}