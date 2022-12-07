package com.hvs.basics.subpackage;

public class AccesoProtegido {

    private Modificadores modificadores;

    public void acesso(){
        modificadores = new Modificadores();

        System.out.println(modificadores.atributoPublic);
        System.out.println(modificadores.atributoProtegido);
        System.out.println(modificadores.atributoPrivado);

    }


}
