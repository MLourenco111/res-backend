    package com.fiap.res.controllers;
    
    import com.fiap.res.RestaurantCreateDto;
    import com.fiap.res.RestaurantDto;
    import com.fiap.res.exceptions.BaseBusinessException;
    import com.fiap.res.gateways.OwnerGateway;
    import com.fiap.res.gateways.RestaurantGateway;
    import com.fiap.res.interfaces.IDataSource;
    import com.fiap.res.interfaces.IRestauranteGateway;
    import com.fiap.res.presenters.RestaurantPresenter;
    import com.fiap.res.usercases.RestaurantCreateUserCase;
    
    public class RestaurantController {
    
        private final IDataSource iDataSource;
    
        private RestaurantController(IDataSource iDataSource){
            this.iDataSource = iDataSource;
        }
    
        public static RestaurantController create(IDataSource dataSource){
            return  new RestaurantController(dataSource);
        }

        public RestaurantDto persist(RestaurantCreateDto restaurantCreateDto){
            var restaurantGateway = RestaurantGateway.create(this.iDataSource);
            var ownerGateway = OwnerGateway.create(this.iDataSource);
            var useCase = RestaurantCreateUserCase.create(restaurantGateway, ownerGateway);
    
            try{
                var restaurant = useCase.persist(restaurantCreateDto);
                return RestaurantPresenter.toRestaurantDto(restaurant);
            }catch (BaseBusinessException b){
               // implementar a logica
                return null;
            }
        }
    }
