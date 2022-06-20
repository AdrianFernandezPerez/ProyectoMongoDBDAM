package main.java.view;

import main.java.model.entity.TipoVehiculo;

import java.util.Scanner;

public class View {
    Scanner scan = new Scanner(System.in);
    public void muestraMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public  String pideString(String mensaje) {
        String texto = "";
        scan.useDelimiter("\n");
        System.out.print(mensaje);
        texto = scan.next();

        return texto;
    }

    public TipoVehiculo tipoVehiculo(String mensaje) {
        String texto = "";
        scan.useDelimiter("\n");
        System.out.print(mensaje);
        texto = scan.next();
        if (texto.equals("Coche")) {
            return TipoVehiculo.Coche;
        } else if (texto.equals("Moto")) {
            return TipoVehiculo.Moto;
        } else if (texto.equals("Tractor")) {
            return TipoVehiculo.Tractor;
        } else {
            System.out.println("Error, dato no válido");
        }
        return null;
    }

    public int pideInt(String mensaje) {
        int num = 0;
        boolean ok = false;
        do {
            try {
                System.out.print(mensaje);
                num = scan.nextInt();
                ok = true;
            } catch (java.util.InputMismatchException e) {
                ok = false;
                System.out.println("Error, introduce un numero");
                scan.useDelimiter("\n");
                scan.next();
            }
        } while (!ok);

        return num;
    }
}
