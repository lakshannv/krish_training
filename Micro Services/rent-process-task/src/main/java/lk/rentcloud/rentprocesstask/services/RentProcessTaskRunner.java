package lk.rentcloud.rentprocesstask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RentProcessTaskRunner implements CommandLineRunner {

    @Autowired
    RentProcessService rentProcessService;

    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0) {
            if (rentProcessService.validateDL(args[0])) {
                System.out.println("Valid Driving License");
            } else {
                System.out.println("Invalid Driving License");
            }
        } else {
            System.out.println("Task Running Without Arguments");
        }
    }
}
