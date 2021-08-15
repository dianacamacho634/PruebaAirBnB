package Prueba;

import org.testng.annotations.Factory;

public class FabricaAirbnb {

    @Factory
    public Object factory_Airbnb(){
        return new Object[]{
                new PruebaSelenium(),
                new PruebaSelenium()
        };
    }

}
