package org.multiply_methods.methods.english;

public class InglesiaRecursivaEstatica {

    public int[] multiplicar(int[] arreglo1, int[] arreglo2) {
        int tam = arreglo1.length * 2;
        int[] resultado = new int[tam];

        multiplicaRecursivo(arreglo1, arreglo2, resultado, arreglo2.length - 1, tam - 1);

        return resultado;
    }

    private void multiplicaRecursivo(int[] arreglo1, int[] arreglo2, int[] resultado, int indiceArreglo2, int indiceResultado) {

        if (indiceArreglo2 < 0) {
            return;
        }

        int digitoArreglo2 = arreglo2[indiceArreglo2];
        for (int j = arreglo1.length - 1; j >= 0; j--) {
            resultado[indiceResultado - (arreglo1.length - 1 - j)] += arreglo1[j] * digitoArreglo2;
        }

        for (int k = indiceResultado; k > 0; k--) {
            resultado[k - 1] += resultado[k] / 10;
            resultado[k] %= 10;
        }

        multiplicaRecursivo(arreglo1, arreglo2, resultado, indiceArreglo2 - 1, indiceResultado - 1);
    }
}