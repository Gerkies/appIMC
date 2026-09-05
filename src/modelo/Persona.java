
package modelo;

import java.time.LocalDate;

public class Persona {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private double peso;
    private double altura;
    private String direccion;
    private String telefono;
    private String correo;

    public Persona(String nombreCompleto, LocalDate fechaNacimiento, double peso, String direccion, String telefono, String correo, int calcularEdad) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
// metodo constructor vacio
public Persona () {
}

//Getters

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
    
//Setters

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

// Para calcular edad
public int calcularEdad() {
    LocalDate fechaActual = LocalDate.now();
    int edad = fechaActual.getYear() - fechaNacimiento.getYear();
    return edad;
}

// Verificar edad
public boolean esMayorEdad(){
    if (calcularEdad() >= 18) {
    return true;
}
    else {
        return false;
    }
}

// Masa corporal
public double calcularIMC(){
    double imc = peso / (altura * altura);
    return imc;
}

// Clasificacion por edad
public String clasificarIMC() {
    double imc = calcularIMC();
    if (imc < 18.5) {
        return "Bajo";
    }
    else if (imc <= 24.9){
        return "Normal";
    }
    else if (imc <= 29.9){
        return "Sobrepeso";
    }
    else {
        return "Obeso";
    }
}

public void mostrarDatos(){
    System.out.println("Nombre: "+nombreCompleto);
    System.out.println("Fecha de nacimiento: "+fechaNacimiento);
    System.out.println("Edad: "+calcularEdad()+" anos");
    System.out.println("Peso: "+peso+" kg");
    System.out.println("Altura: "+altura+" mt");
    System.out.println("IMC: "+calcularIMC());
    System.out.println("Clasificacion: "+clasificarIMC());
    System.out.println("Direccion: "+direccion);
    System.out.println("Telefono: "+telefono);
    System.out.println("Correo: "+correo);
    
}
}