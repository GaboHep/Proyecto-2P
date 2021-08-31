package com.mycompany.proyecto2p;

import java.util.ArrayList;

public class Vecindario {

    int radioVecindario = Configuracion.VECINDARIO;

    public ArrayList buscarVecindario(int indiceColumna, int indiceFila) {

        ArrayList <Integer> listaCeldasOcupadas = new ArrayList<>();

        if (indiceColumna - radioVecindario >= 0 && indiceFila - radioVecindario >= 0) {

            for (int x = indiceColumna - radioVecindario; x < indiceColumna + radioVecindario; x++) {

                for (int y = indiceFila - radioVecindario; y < indiceFila + radioVecindario; y++) {

//                    if (celda[x,y].isOcupada()) {
//
//                        listaCeldasOcupadas.add(celda[x,y]);
//
//                    }

                }

            }
            
            return listaCeldasOcupadas;

        }

        else if (indiceColumna - radioVecindario >= 0 && indiceFila - radioVecindario == 0) {

            for (int x = indiceColumna - radioVecindario; x < indiceColumna + radioVecindario; x++) {

                for (int y = indiceFila; y < indiceFila + radioVecindario; y++) {

//                    if (celda[x,y].isOcupada()) {
//
//                        listaCeldasOcupadas.add(celda[x,y]);
//
//                    }

                }

            }
            
            return listaCeldasOcupadas;

        }

        else if (indiceColumna - radioVecindario == 0 && indiceFila - radioVecindario >= 0) {

            for (int x = indiceColumna; x < indiceColumna + radioVecindario; x++) {

                for (int y = indiceFila - radioVecindario; y < indiceFila + radioVecindario; y++) {

//                    if (celda[x,y].isOcupada()) {
//
//                        listaCeldasOcupadas.add(celda[x,y]);
//
//                    }

                }

            }
            
            return listaCeldasOcupadas;

        }

        else {

            for (int x = indiceColumna; x < indiceColumna + radioVecindario; x++) {

                for (int y = indiceFila; y < indiceFila + radioVecindario; y++) {

//                    if (celda[x,y].isOcupada()) {
//
//                        listaCeldasOcupadas.add(celda[x,y]);
//
//                    }

                }

            }

        }
        
        return listaCeldasOcupadas;

    }

}
