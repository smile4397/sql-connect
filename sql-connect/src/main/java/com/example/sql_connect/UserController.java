package com.example.sql_connect;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Customer customer) {
        customer.lowerEmail();

        if (!customer.getEmail_address().contains("@")){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Not a valid email");
        }
        try {
            System.out.println("Incoming request: " + customer);

            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(savedCustomer);

        } catch (DataIntegrityViolationException e) {
            System.err.println("Database constraint violation: " + e.getMessage());
            Throwable cause = e.getCause();
            if (cause instanceof ConstraintViolationException){
                String constraintName = ((ConstraintViolationException) cause).getConstraintName();
                if ("customers.email_address_UNIQUE".equals(constraintName)){
                    return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("This email is already registered");
                }
            }
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Some fields are incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred");
        }
    }
}
