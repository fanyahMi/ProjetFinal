/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.connexion;

/**
 *
 * @author Hasinjo
 */
public class Connexion_projet extends Connexion {

    public Connexion_projet(String base, String user, String password, String database) {
        super(base, user, password, database);
    }

    public Connexion_projet() {
        setBase("postgresql");
        setUser("avnadmin");
        setPassword("AVNS_REgdYZyuG2l4-P9Jkor");
        setDatabase("defaultdb");
        setHote("pg-33f46b02-toavinahasnii02-5d6a.a.aivencloud.com");
        setPort("20685");
    }

}
