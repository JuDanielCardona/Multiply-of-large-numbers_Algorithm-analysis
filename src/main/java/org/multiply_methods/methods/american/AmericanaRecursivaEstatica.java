package org.multiply_methods.methods.american;

public class AmericanaRecursivaEstatica {

    public int[] multiplicar(int[] numero1, int[] numero2) {
        int m = numero1.length;
        int n = numero2.length;

        int[] resultado = new int[m + n];

        multiplicarAux(numero1, numero2, resultado, m, n);

        int i = 0;
        while (i < resultado.length - 1 && resultado[i] == 0) {
            i++;
        }

        if (i > 0) {
            int[] nuevoResultado = new int[resultado.length - i];
            System.arraycopy(resultado, i, nuevoResultado, 0, nuevoResultado.length);
            return nuevoResultado;
        } else {
            return resultado;
        }
    }

    private void multiplicarAux(int[] num1, int[] num2, int[] resultado, int m, int n) {
        if (m == 0 || n == 0) {
            return;
        }
    
        int iN = n - 1;
        int iM = m - 1;
        int carry = 0;
    
        for (int i = n + m - 1; i >= 0; i--) {
            int prod = resultado[i] + carry;
            if (iN >= 0) {
                prod += num1[iM] * num2[iN];
                iN--;
            }
            resultado[i] = prod % 10;
            carry = prod / 10;
        }
    
        multiplicarAux(num1, num2, resultado, m - 1, n);
    }
    
    
}
