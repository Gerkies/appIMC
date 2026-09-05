package app;

import modelo.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Persona> listaPersonas = new ArrayList();
    private static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
            int opcion = -1;
            //MENU
            do {
            System.out.println("// SISTEMA DE EVALUACION");
            System.out.println("-----------------------");
            System.out.println("1. Registrar persona");
            System.out.println("2. Mostra personas registradas");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion");
            
            // Validar entrada numerica
            if (entrada.hasNextInt()){
            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpia buffer
            }
            else {
                System.out.println("Debe ingresar una opcion valida.");
                entrada.nextLine();
                continue;
            }
            
            switch(opcion){
                case 1: registrarPersona();
                        break;
                case 2: mostrarPersona();
                        break;
                case 3: buscarPersona();
                        break;
                case 4: System.out.println("Presione una tecla para salir...");
                        break;
            default: System.out.println("Ingrese una opcion valida");
            
}
            }while (opcion !=4); //finaliza do while
            
            entrada.close();
            
} //Finaliza metodo main

public static void registrarPersona() {
        Persona personal = new Persona();
        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("Nombre completo: ");
        personal.setNombreCompleto(entrada.nextLine());
        System.out.println("Fecha de nacimiento (AAAA-MM-DD): ");
        personal.setFechaNacimiento(LocalDate.parse(entrada.nextLine()));

        // Validacion de mayoria de edad segunel caso
        if (!personal.esMayorEdad()) {
            System.out.println("Aviso: Solo se permite registrar a personas mayores de edad.");
            return;
        }

        System.out.println("Peso: ");
        personal.setPeso(entrada.nextDouble());
        System.out.println("Altura: ");
        personal.setAltura(entrada.nextDouble());
        entrada.nextLine(); // Limpiar buffer

        System.out.println("Direccion: ");
        personal.setDireccion(entrada.nextLine());
        System.out.println("Telefono: ");
        personal.setTelefono(entrada.nextLine());
        System.out.println("Correo: ");
        personal.setCorreo(entrada.nextLine());

        // Para insertar en el ArrayList
        listaPersonas.add(personal);
        System.out.println("Persona registrada con exito.");
    }

    public static void mostrarPersona() {
        System.out.println("LISTA DE PERSONAS REGISTRADAS");
        System.out.println("------------------------------");
        for (int i = 0; i < listaPersonas.size(); i++) {
            listaPersonas.get(i).mostrarDatos();
            System.out.println("--------------------");
            System.out.println(); // Salto de linea limpio
        }
    }

    public static void buscarPersona() {
        System.out.println("BUSCAR POR NOMBRE");
        System.out.println("------------------------------");
        System.out.println("Ingrese el nombre: ");
        String nombreBuscado = entrada.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < listaPersonas.size(); i++) {
            // Compara ignorando mayusculas y minusculas
            if (listaPersonas.get(i).getNombreCompleto().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Registro encontrado:");
                listaPersonas.get(i).mostrarDatos();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Persona no encontrada.");
        }
    }
}