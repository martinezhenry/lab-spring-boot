package com.hvs.basics.subpackage;

public class Modificadores {

    private String atributoPrivado;
    public String atributoPublic;
    protected String atributoProtegido;

    public void acesso(){

        System.out.println(atributoPublic);
        System.out.println(atributoProtegido);
        System.out.println(atributoPrivado);

    }

}
