package org.multiply_methods.methods.american;
import java.util.*;

public class AmericanaIterativaDinamica {

    //ADAPTACIÓN DE: Divide y Venceras.pdf - Estrategias de programación - Pag 30
    //Extraído: https://drive.google.com/file/d/1jnIIbTxZAzNdnTpKL1E8fcjlNkFSaDOY/view

    public ArrayList<Integer> multiplicar(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        int k = lista1.size() + lista2.size() - 1;
        int pos = lista1.size() + lista2.size() - 1;
        ArrayList<Integer> resultado = new ArrayList<>(lista1.size() + lista2.size());

        for (int i = 0; i < lista1.size() + lista2.size(); i++) {
            resultado.add(0);
        }

        for (int i = lista1.size() - 1; i >= 0; i--) {
            for (int j = lista2.size() - 1; j >= 0; j--) {
                resultado.set(k, resultado.get(k) + lista1.get(i) * lista2.get(j));
                if (resultado.get(k) > 9) {
                    resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
                    resultado.set(k, resultado.get(k) % 10);
                }
                k--;
            }
            k = pos;
            pos--;
            k--;
        }

        while (resultado.get(0) == 0 && resultado.size() > 1) {
            resultado.remove(0);
        }
        return resultado;
    }

}
