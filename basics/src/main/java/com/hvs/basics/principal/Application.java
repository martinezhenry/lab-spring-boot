package com.hvs.basics.principal;

//import com.hvs.basics.subpackage.Modificadores;

public class Application {

    private static ITesting testing;
    private static IVehiculo vehiculo;

    //private static Modificadores modificadores;
    public static void main(String[] args) {

        /*System.out.println(modificadores.atributoPublic);
        System.out.println(modificadores.atributoProtegido);
        System.out.println(modificadores.atributoPrivado);*/


        testing = new TestingService();

        vehiculo = vehiculeTest("1");

    }


    public static IVehiculo vehiculeTest(String vehicleType) {
        if ("1".equals(vehicleType)) {
            return new Bicicleta();
        } else {
            return new Car();
        }
    }
}
