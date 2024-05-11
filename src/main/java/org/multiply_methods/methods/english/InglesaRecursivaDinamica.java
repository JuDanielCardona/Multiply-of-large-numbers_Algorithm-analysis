package org.multiply_methods.methods.english;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InglesaRecursivaDinamica {

    public List<Integer> multiplicar(List<Integer> arreglo1, List<Integer> arreglo2) {
        int tam = arreglo1.size() * 2;
        List<Integer> resultado = new ArrayList<>(Collections.nCopies(tam, 0));

        multiplicaRecursivo(arreglo1, arreglo2, resultado, arreglo2.size() - 1, tam - 1);

        return resultado;
    }

    private void multiplicaRecursivo(List<Integer> arreglo1, List<Integer> arreglo2, List<Integer> resultado, int indiceArreglo2, int indiceResultado) {

        if (indiceArreglo2 < 0) {
            return;
        }

        int digitoArreglo2 = arreglo2.get(indiceArreglo2);
        for (int j = arreglo1.size() - 1; j >= 0; j--) {
            resultado.set(indiceResultado - (arreglo1.size() - 1 - j), resultado.get(indiceResultado - (arreglo1.size() - 1 - j)) + arreglo1.get(j) * digitoArreglo2);
        }

        for (int k = indiceResultado; k > 0; k--) {
            int carry = resultado.get(k) / 10;
            resultado.set(k - 1, resultado.get(k - 1) + carry);
            resultado.set(k, resultado.get(k) % 10);
        }

        multiplicaRecursivo(arreglo1, arreglo2, resultado, indiceArreglo2 - 1, indiceResultado - 1);
    }

}
