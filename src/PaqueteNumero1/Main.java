package PaqueteNumero1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    ArrayList<Automoviles> lista = new ArrayList();

    public static void main(String... args) throws IOException {
        Main ob1 = new Main();
        ob1.menu();
    }

    private void menu() throws IOException {
        int n;
        n = 0;
        boolean x = false;

        do {
            do {
                System.out.println("");
                System.out.println("::::::::::MENU::::::::::"
                        + "\n1.Agregar Automoviles"
                        + "\n2.Ordenar por precio"
                        + "\n3.Imprimir");
                System.err.print("R= ");
                try {
                    n = Integer.parseInt(bufer());
                } catch (NumberFormatException e) {
                    System.out.println("Debes de digitar un numero");
                }
                System.out.println("");
            } while (n < 1 || n > 3);

            switch (n) {
                case 1:
                    agregarAutomoviles();
                    break;
                case 2:
                    lista = ordenarPrecio();
                    break;
                case 3:
                    imprimir();
                    break;
            }

        } while (x == false);

    }

    private void agregarAutomoviles(String marca, String color, String matricula, int precio) {
        lista.add(new Automoviles(marca, color, matricula, precio));
    }

    private void agregarAutomoviles() throws IOException {
        String marca;
        String color;
        String id;
        int precio;

        System.out.print("Dame la marca del automovil : ");
        marca = bufer();
        
        if(!validarCadenas(marca)) agregarAutomoviles(); 
            
        System.out.print("Dame el color del automovil : ");
        color = bufer();
        
         if(!validarCadenas(color)) agregarAutomoviles(); 
         
        System.out.print("Dame la matricula del automovil : ");
        id = bufer();
        
         if(!validarCadenas(id)) agregarAutomoviles(); 
         
        System.out.print("Dame el precio del automovil : ");
        precio = Integer.parseInt(bufer());

        agregarAutomoviles(marca, color, id, precio);
    }

    private ArrayList<Automoviles> ordenarPrecio() {
        Collections.sort(lista, (Automoviles uno, Automoviles dos) -> new Integer(uno.getPrecio()).compareTo(dos.getPrecio()));
        return lista;
    }

    private String bufer() throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;

        entrada = bufer.readLine();

        return entrada;
    }

    private void imprimir() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    
    private boolean validarCadenas(String x){
        Pattern pat = Pattern.compile("[a-zA-Z]{1,20}");
        Matcher mat = pat.matcher(x);
        
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean validarId(String x){
        Pattern pat = Pattern.compile("[M-Z1-9]{5,20}");
        Matcher mat = pat.matcher(x);
        
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
}
