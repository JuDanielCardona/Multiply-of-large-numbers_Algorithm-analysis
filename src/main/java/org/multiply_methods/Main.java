package org.multiply_methods;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.multiply_methods.methods.american.AmericanaIterativaDinamica;
import org.multiply_methods.methods.american.AmericanaIterativaEstatica;
import org.multiply_methods.methods.american.AmericanaRecursivaDinamica;
import org.multiply_methods.methods.american.AmericanaRecursivaEstatica;
import org.multiply_methods.methods.divide.DivideVenceras;
import org.multiply_methods.methods.english.InglesaIterativaDinamica;
import org.multiply_methods.methods.english.InglesaIterativaEstatica;
import org.multiply_methods.methods.english.InglesaRecursivaDinamica;
import org.multiply_methods.methods.english.InglesiaRecursivaEstatica;
import org.multiply_methods.methods.hindu.HinduIterativoEstatico;

public class Main {

    public static <CategoryPlot> void main(String[] args) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        TreeMap<Long, String> sortedTimes = new TreeMap<>();

        long start_time;
        long end_time;
        long time;

        int[] numberA;
        int[] numberB;
        ArrayList<Integer> numberArrayA;
        ArrayList<Integer> numberArrayB;

        int[] resultado;
        ArrayList<Integer> resultadoArray;
        List<Integer> resultadoList;

        boolean imprimir = true;

        generateNumber();

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Americana Iterativa Estatica------");
            AmericanaIterativaEstatica AIE = new AmericanaIterativaEstatica();
            start_time = System.nanoTime();
            resultado = AIE.multiplicar(numberA, numberB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Americana Iterativa Estatica");
            print(resultado, imprimir);
        } catch (Exception e) {
            System.out.println("Error en la multiplicación Americana Iterativa Estatica: ");
        }

        numberArrayA = readArrayList("numberA");
        numberArrayB = readArrayList("numberB");

        try {
            System.out.println("\n\n------Multiplicación Americana Iterativa Dinamica------");
            AmericanaIterativaDinamica AID = new AmericanaIterativaDinamica();
            start_time = System.nanoTime();
            resultadoArray = AID.multiplicar(numberArrayA, numberArrayB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Americana Iterativa Dinamica");
            print(resultadoArray, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Americana Iterativa Dinamica: ");
        }

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Americana Recursiva Estatica------");
            AmericanaRecursivaEstatica ARE = new AmericanaRecursivaEstatica();
            start_time = System.nanoTime();
            resultado = ARE.multiplicar(numberA, numberB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Americana Recursiva Estatica");
            print(resultado, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Americana Recursiva Estatica: ");
        }

        numberArrayA = readArrayList("numberA");
        numberArrayB = readArrayList("numberB");

        try {
            System.out.println("\n\n------Multiplicación Americana Recursiva Dinamica------");
            AmericanaRecursivaDinamica ARD = new AmericanaRecursivaDinamica();
            start_time = System.nanoTime();
            resultadoList = ARD.multiplicar(numberArrayA, numberArrayB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Americana Recursiva Dinamica");
            print(resultadoList, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Americana Recursiva Dinamica: ");
        }

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Inglesa Iterativa Estatica------");
            InglesaIterativaEstatica IIE = new InglesaIterativaEstatica();
            start_time = System.nanoTime();
            resultado = IIE.multiplicar(numberA, numberB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Inglesa Iterativa Estatica");
            print(resultado, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Inglesa Iterativa Estatica: ");
        }

        numberArrayA = readArrayList("numberA");
        numberArrayB = readArrayList("numberB");

        try {
            System.out.println("\n\n------Multiplicación Inglesa Iterativa Dinamica------");
            InglesaIterativaDinamica IID = new InglesaIterativaDinamica();
            start_time = System.nanoTime();
            resultadoArray = IID.multiplicar(numberArrayA, numberArrayB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Inglesa Iterativa Dinamica");
            print(resultadoArray, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Inglesa Iterativa Dinamica: ");
        }

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Inglesa Recursiva Estatica------");
            InglesiaRecursivaEstatica IRE = new InglesiaRecursivaEstatica();
            start_time = System.nanoTime();
            resultado = IRE.multiplicar(numberA, numberB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Inglesa Recursiva Estatica");
            print(resultado, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Inglesa Recursiva Estatica: ");
        }

        numberArrayA = readArrayList("numberA");

        numberArrayB = readArrayList("numberB");

        try {
            System.out.println("\n\n------Multiplicación Inglesa Recursiva Dinamica------");
            InglesaRecursivaDinamica IRD = new InglesaRecursivaDinamica();
            start_time = System.nanoTime();
            resultadoList = IRD.multiplicar(numberArrayA, numberArrayB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Inglesa Recursiva Dinamica");
            print(resultadoList, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Inglesa Recursiva Dinamica: ");
        }

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Hindu Iterativo Estatico------");
            HinduIterativoEstatico HIE = new HinduIterativoEstatico();
            start_time = System.nanoTime();
            resultado = HIE.multiplicar(numberA, numberB);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Hindu Iterativo Estatico");
            print(resultado, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Hindu Iterativo Estatico: ");
        }

        numberA = readArray("numberA");
        numberB = readArray("numberB");

        try {
            System.out.println("\n\n------Multiplicación Divide y Venceras------");
            DivideVenceras DV = new DivideVenceras();
            start_time = System.nanoTime();
            resultado = DV.multiplicar(numberA, numberB, numberA.length);
            end_time = System.nanoTime();
            time = executionTime(end_time, start_time);
            sortedTimes.put(time, "Divide y Venceras");
            print(resultado, imprimir);
        } catch (
                Exception e) {
            System.out.println("Error en la multiplicación Divide y Venceras: ");
        }


        for (
                Long t : sortedTimes.descendingKeySet()) {
            dataset.addValue(t, "Tiempo (ns)", sortedTimes.get(t));
        }

        generateReport(sortedTimes);

        JTable table = new JTable(createTableModel(sortedTimes));
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);


        JFreeChart chart = ChartFactory.createBarChart("Tiempo de ejecución de algoritmos de multiplicación", "Algoritmo", "Tiempo (ns)", dataset, PlotOrientation.VERTICAL, true, true, false);

        JFrame frame = new JFrame("Gráfico de Barras y Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new

                BorderLayout());
        frame.add(new

                ChartPanel(chart), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    public static DefaultTableModel createTableModel(TreeMap<Long, String> sortedTimes) {

        String[] columnNames = {"Algoritmo", "Tiempo (ns)"};
        Set<Map.Entry<Long, String>> entrySet = sortedTimes.entrySet();
        Object[][] data = new Object[sortedTimes.size()][2];

        int row = 0;
        for (Map.Entry<Long, String> entry : entrySet) {
            data[row][0] = entry.getValue();
            data[row][1] = entry.getKey();
            row++;
        }

        return new DefaultTableModel(data, columnNames);
    }


    public static void generateNumber() {

        String input = JOptionPane.showInputDialog("Ingrese el tamaño del número:");
        int size = Integer.parseInt(input);
        Random rand = new Random();
        int[] numberA = new int[size];
        int[] numberB = new int[size];

        numberA[0] = rand.nextInt(9) + 1;
        numberB[0] = rand.nextInt(9) + 1;

        for (int i = 1; i < size; i++) {
            numberA[i] = rand.nextInt(10);
            numberB[i] = rand.nextInt(10);
        }

        writeArray(numberA, "numberA");
        writeArray(numberB, "numberB");

        System.out.println("\nNumber [" + size + "] generated correctly.\n");
    }

    public static long executionTime(long end, long start) {
        long totalTime;
        totalTime = end - start;
        long milliseconds = totalTime / 1_000_000;
        long seconds = milliseconds / 1000;
        System.out.println("Tiempo de ejecución: " + totalTime + " ns");
        System.out.println("Tiempo de ejecución: " + milliseconds + " ms");
        System.out.println("Tiempo de ejecución: " + seconds + " s");
        return totalTime;
    }


    public static void writeArray(int[] arreglo, String name) {
        String nombreArchivo = "src/main/resources/" + name + ".txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            File file = new File(nombreArchivo);
            if (file.exists()) {
                file.delete();
            }

            for (int num : arreglo) {
                writer.write(String.valueOf(num));
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int[] readArray(String name) {
        List<Integer> arrayList = new ArrayList<>();
        String fileName = "src/main/resources/" + name + ".txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                arrayList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public static ArrayList<Integer> readArrayList(String name) {
        List<Integer> arrayList = new ArrayList<>();
        String fileName = "src/main/resources/" + name + ".txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                arrayList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(arrayList);
    }

    public static void generateReport(TreeMap<Long, String> sortedTimes) {
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = dateTime.format(formatter);

        String nombreArchivo = "src/main/java/reports/Report_" + formattedDateTime + ".txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            File file = new File(nombreArchivo);
            if (file.exists()) {
                file.delete();
            }

            for (Map.Entry<Long, String> entry : sortedTimes.entrySet()) {
                writer.write(entry.getValue() + ": " + entry.getKey() + " ns\n");
            }
            System.out.println("\n\nGenerado reporte: " + nombreArchivo + " correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(Object array, boolean imprimir) {
        if (imprimir) {
            if (array instanceof int[]) {
                int[] intArray = (int[]) array;
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int num : intArray) {
                    if (count < 30) {
                        sb.append(num).append(" ");
                    } else if (count == 30) {
                        sb.append(" + Otros ").append(intArray.length - 30).append(" digitos");
                        break;
                    }
                    count++;
                }
                System.out.println(sb.toString().trim());
            } else if (array instanceof ArrayList<?>) {
                ArrayList<Integer> arrayList = (ArrayList<Integer>) array;
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int num : arrayList) {
                    if (count < 30) {
                        sb.append(num).append(" ");
                    } else if (count == 30) {
                        sb.append(" + Otros ").append(arrayList.size() - 30).append(" digitos");
                        break;
                    }
                    count++;
                }
                System.out.println(sb.toString().trim());
            } else if (array instanceof List<?>) {
                List<Integer> list = (List<Integer>) array;
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int num : list) {
                    if (count < 30) {
                        sb.append(num).append(" ");
                    } else if (count == 30) {
                        sb.append(" + Otros ").append(list.size() - 30).append(" digitos");
                        break;
                    }
                    count++;
                }
                System.out.println(sb.toString().trim());
            } else {
                System.out.println("Tipo de dato no compatible");
            }
        }
    }

}