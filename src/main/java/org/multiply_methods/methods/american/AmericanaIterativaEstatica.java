package org.multiply_methods.methods.american;

public class AmericanaIterativaEstatica {

    //FUENTE: Divide y Venceras.pdf - Estrategias de programación
    //Extraído: https://drive.google.com/file/d/1jnIIbTxZAzNdnTpKL1E8fcjlNkFSaDOY/view

    public int[] multiplicar(int arreglo1[], int arreglo2[])
    {
        int k = arreglo1.length+arreglo2.length-1;
        int pos= arreglo1.length+arreglo2.length-1;
        int resultado[]= new int[arreglo1.length+arreglo2.length];
        for(int i=arreglo1.length-1;i>=0;i--)
        {
            for(int j=arreglo2.length-1;j>=0;j--)
            {

                resultado[k] = resultado[k] + arreglo1[i]*arreglo2[j];
                if(resultado[k]>9)
                {

                    resultado[k-1]+=resultado[k]/10;
                    resultado[k]=resultado[k]%10;

                }
                k--;

            }
            k = pos;
            pos--;
            k--;

        }
        return resultado;
    }
}
