package org.multiply_methods.methods.hindu;

public class HinduIterativoEstatico {

    public int[] multiplicar(int[] arreglo1, int[] arreglo2) {

        int tam = arreglo1.length + arreglo2.length;
        int[] resultado = new int[tam];

        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = 0; j < arreglo2.length; j++) {
                int producto = arreglo1[i] * arreglo2[j];
                int posicion1 = i + j;
                int posicion2 = posicion1 + 1;
                resultado[posicion1] += producto / 10;
                resultado[posicion2] += producto % 10;
            }
        }

        for (int i = resultado.length - 1; i > 0; i--) {
            resultado[i - 1] += resultado[i] / 10;
            resultado[i] %= 10;
        }

        return resultado;
    }
}