package org.multiply_methods.methods.english;

public class InglesaIterativaEstatica {

    //FUENTE: Divide y Venceras.pdf - Estrategias de programación - Pag. 33
    //Extraído: https://drive.google.com/file/d/1jnIIbTxZAzNdnTpKL1E8fcjlNkFSaDOY/view

    public int[] multiplicar(int[] arreglo1, int[] arreglo2)
    {

        int tam = arreglo1.length + arreglo2.length;
        int[] resultado = new int [tam];
        for (int i=0; i< arreglo2.length; i++)
        {

            for(int j=0; j< arreglo1.length; j++)
            {

                resultado[i+j+1]+= arreglo1[j]* arreglo2[i];

            }

        }
        for (int k=tam-1; k>0; k--)
        {

            resultado[k-1]+= resultado[k]/10;
            resultado [k]%=10;

        }
        return resultado;

    }
}
    