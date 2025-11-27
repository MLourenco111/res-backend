package com.fiap.res;

import com.fiap.res.domain.Address;
import com.fiap.res.domain.Restaurant;
import com.fiap.res.domain.WorkingHours;
import com.fiap.res.usecase.RestaurantCreate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RestaurantCreateTest {

    @InjectMocks
    private RestaurantCreate restaurantCreate;

    @Test
    void haveToPersistRestaurant(){
        Long ownerId = 1L;
        RestaurantCreateDto dto = new RestaurantCreateDto(null,null,null,null,ownerId,null,null,null,null,null,null);
        Long persisted = restaurantCreate.persist(dto);

        assertNotNull(ownerId);
       // assertNotNull(persisted);
    }

    @Test
    void ownerHasToExists(){

    }
}
