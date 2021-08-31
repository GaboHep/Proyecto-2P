/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.FileNotFoundException;

/**
 *
 * @author ggabo
 */
public class Main {
    public static void main(String[] args) {
        try {
            App.main(args);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
