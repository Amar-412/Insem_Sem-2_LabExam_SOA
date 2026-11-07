package com.tourist.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.*;
	import org.springframework.web.bind.annotation.*;

	import com.tourist.service.Tourist;
	import com.tourist.service.TouristRepository;

	import java.util.List;

	@RestController
	@RequestMapping("/api")
	public class TouristController {

	    @Autowired
	    private TouristRepository repository;

	    private final String validToken = "ABC123";

	    @GetMapping("/tourists")
	    public ResponseEntity<?> getAllTourists(
	            @RequestHeader(value = "Token", required = false) String token) {

	        if (token == null || !token.equals(validToken)) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Unauthorized: Invalid Token Provided");
	        }

	        List<Tourist> tourists = repository.findAll();

	        return ResponseEntity.ok(tourists);
	    }
	}
	
	
	

