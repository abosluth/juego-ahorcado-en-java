
import java.util.Scanner;
public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);

        //declaraciones 
        String palabraSecreta = "roca";
        int intentosMaximos = 10;
        int intentos=0;
        boolean palabraAdivinada = false;

        //arreglo
        char [] letrasAdivinadas = new char [palabraSecreta.length()];

        //recorres el array para crear los guiones
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            
        }

        while (!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("Palabra a Adivinar: " + String.valueOf(letrasAdivinadas)+  " (" + palabraSecreta.length() + " letras)");
            System.out.println("ingrese una letra por favor: ");

            //ingresa el character o la letra
            char letra = Character.toLowerCase(sc.next().charAt(0));
            
            // variable de verificacion
            boolean yaAdivinada = false;

            //comprobamos si la letra ya existe dentro del array
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                if (letrasAdivinadas[i] == letra) {
                    yaAdivinada= true;
                    break;
                }
            }

            // verificacion completa si existe
            if(yaAdivinada){
                intentos++;
                System.out.println("¡ya has adivinado esta letra! intentos restantes: "+ (intentosMaximos - intentos));
                continue;
            }

             // variable de letra 
             boolean letraCorrecta = false;

            //game 
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra ){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta= true;
                } 
            }

            // descuenta si dices una letra incorrecta
            if(!letraCorrecta){
                intentos++;
                System.out.println("¡incorrecto! intentos restantes: "+ (intentosMaximos - intentos));
            }


            //gana

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades! has adivinado la palabra secreta: "+ palabraSecreta);
            
            }

        }
        
        //se te acaban los intentos y pierdes
        if(!palabraAdivinada){
            System.out.println("¡Que pena has gastado todos los intentos! GAME OVER");

        }

        sc.close();



        
    }
}
