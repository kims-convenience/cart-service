package com.kims_convenience.cart_service.repositories;

import com.kims_convenience.cart_service.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends JpaRepository<Cart, String> {

}
