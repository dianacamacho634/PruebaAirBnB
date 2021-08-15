package Prueba;

import org.testng.annotations.DataProvider;

public class dataProvider {

    @DataProvider(name = "busqueda")
    public Object[][] datosBusqueda() {
        return new  Object[][]{
            { "Medellin, Antioquia"},
            //{ "Manizales, Caldas", "14ago", "16ago", "2 huespedes"},
            //{ "Miami,FL", "14ago", "16ago", "2 huespedes" }
        };
    }
}


//"14ago", "16ago"