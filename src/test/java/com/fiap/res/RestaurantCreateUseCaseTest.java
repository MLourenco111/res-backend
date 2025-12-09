package com.fiap.res;

import com.fiap.res.domain.Address;
import com.fiap.res.domain.Restaurant;
import com.fiap.res.usercase.RestaurantCreateUserCase;
import com.fiap.res.interfaces.RestauranteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RestaurantCreateUseCaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;

    @InjectMocks
    private RestaurantCreateUserCase useCase;

    @Captor
    private ArgumentCaptor<Restaurant> restaurantCaptor;

    private RestaurantCreateDto createDto (){
        return new RestaurantCreateDto("Pizzaria",
                CuisineType.BRAZILIAN,
                LocalTime.of(9,0),
                LocalTime.of(18,0),
                "BR-000111222333",
                "001",
                10L,
                "Rua A",
                "100",
                "Curitiba",
                "PR",
                "Brazil",
                "00000-000");
    }

    @Test
    @DisplayName("Persist restaurant success")
    void shouldCreateRestaurantSuccessfully() {
        // Arrange
        RestaurantCreateDto dto = createDto();

        when(restauranteGateway.existsByTaxIdAndBranchCode("BR000111222333", "001")).thenReturn(false);

        Address address = new Address(null, dto.street(), dto.number(), dto.city(), dto.state(), dto.country(), dto.zipCode());
        Restaurant saved = Restaurant.withId(
                99L,
                dto.name(),
                "BR000111222333",
                "001",
                dto.cuisineType(),
                dto.openingTime(),
                dto.closingTime(),
                dto.ownerId(),
                address
        );

        when(restauranteGateway.save(any(Restaurant.class))).thenReturn(saved);

        // Act
        Restaurant result = useCase.persist(dto);

        // Assert
        assertNotNull(result);
        assertEquals(99L, result.getId());
        verify(restauranteGateway).existsByTaxIdAndBranchCode("BR000111222333", "001");
        verify(restauranteGateway).save(restaurantCaptor.capture());

        Restaurant passedToSave = restaurantCaptor.getValue();
        assertEquals("BR000111222333", passedToSave.getTaxId());
        assertEquals("001", passedToSave.getBranchCode());
    }


    @Test
    @DisplayName("Restaurant Already Exists")
    void shouldThrowWhenAlreadyExists() {
        // Arrange
        RestaurantCreateDto dto = createDto();

        when(restauranteGateway.existsByTaxIdAndBranchCode("BR000111222333", "001")).thenReturn(true);

        // Act
        assertThrows(RestaurantAlreadyExistsException.class, () -> useCase.persist(dto));

        //assert
        verify(restauranteGateway).existsByTaxIdAndBranchCode("BR000111222333", "001");
        verify(restauranteGateway, never()).save(any());
    }
}
