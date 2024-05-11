package org.multiply_methods.methods.english;

import java.util.ArrayList;

//ADAPTADO DE: Divide y Venceras.pdf - Estrategias de programación - Pag. 33
        //Extraído: https://drive.google.com/file/d/1jnIIbTxZAzNdnTpKL1E8fcjlNkFSaDOY/view

public class InglesaIterativaDinamica {
    public ArrayList<Integer> multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
        int tam = arreglo1.size() + arreglo2.size();
        ArrayList<Integer> resultado = new ArrayList<>(tam);

        for (int i = 0; i < tam; i++) {
            resultado.add(0);
        }

        for (int i = 0; i < arreglo2.size(); i++) {
            for (int j = 0; j < arreglo1.size(); j++) {
                resultado.set(i + j + 1, resultado.get(i + j + 1) + arreglo1.get(j) * arreglo2.get(i));
            }
        }

        for (int k = tam - 1; k > 0; k--) {
            resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
            resultado.set(k, resultado.get(k) % 10);
        }

        return resultado;
    }
}
