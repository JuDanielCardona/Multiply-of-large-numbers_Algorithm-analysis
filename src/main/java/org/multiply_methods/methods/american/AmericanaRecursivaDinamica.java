package org.multiply_methods.methods.american;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmericanaRecursivaDinamica {

    public List<Integer> multiplicar(List<Integer> numero1, List<Integer> numero2) throws Exception {
        int m = numero1.size();
        int n = numero2.size();

        List<Integer> resultado = new ArrayList<>(Collections.nCopies(m + n, 0));

        multiplicarAux(numero1, numero2, resultado, m, n);

        int i = 0;
        while (i < resultado.size() - 1 && resultado.get(i) == 0) {
            i++;
        }

        if (i > 0) {
            return resultado.subList(i, resultado.size());
        } else {
            return resultado;
        }
    }

    private void multiplicarAux(List<Integer> num1, List<Integer> num2, List<Integer> resultado, int m, int n) throws Exception {
        try {


            if (m == 0 || n == 0) {
                return;
            }

            int iN = n - 1;
            int iM = m - 1;
            int carry = 0;

            for (int i = n + m - 1; i >= 0; i--) {
                int prod = resultado.get(i) + carry;
                if (iN >= 0) {
                    prod += num1.get(iM) * num2.get(iN);
                    iN--;
                }
                resultado.set(i, prod % 10);
                carry = prod / 10;
            }

            multiplicarAux(num1, num2, resultado, m - 1, n);
        }catch (Exception e) {
            System.out.println("Falló");
        }
    }
}
