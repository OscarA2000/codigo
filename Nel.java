package nel;

import javax.swing.JOptionPane;
public class Nel {
    public static void main(String[] args) {
       int eleccion; 

        eleccion= Integer.parseInt(JOptionPane.showInputDialog(" 1. Octal a binario\n 2. Decimal a binario\n 3. Hexadecimal a binario\n Seleccione: "));
        
        
        if (eleccion < 1 || eleccion > 3) {
            JOptionPane.showMessageDialog(null,"Elección no válida");
            return;
        }
       
        switch (eleccion) {
            case 1:
                int numero;
                numero= Integer.parseInt(JOptionPane.showInputDialog("Ingrese número octal:"));
                int octal = numero;
                if (!validarOctal(octal)) {
                    JOptionPane.showMessageDialog(null,"Número no válido");
                    return;
                }
            int decimal = octalADecimal(octal);
                String binarioResultante = decimalABinario(decimal);
                JOptionPane.showInputDialog(null,"El binario es " + binarioResultante);
                break;

            
            case 2:
                int numeros;
                numeros= Integer.parseInt(JOptionPane.showInputDialog("Ingrese número decimal:"));
                decimal = numeros;
                if (!validarDecimal(decimal)) {
                    JOptionPane.showMessageDialog(null,"Número no válido");
                    return;
                }
                binarioResultante = decimalABinario(decimal);
                JOptionPane.showMessageDialog(null,"El binario es " + binarioResultante);
                break;
           
            case 3:
                String num;
                num= JOptionPane.showInputDialog("Ingrese número hexadecimal:");
                String hexadecimal = num.toUpperCase();
                if (!validarHexadecimal(hexadecimal)) {
                    JOptionPane.showMessageDialog(null,"Número no válido");
                    return;
                }
                decimal = hexadecimalADecimal(hexadecimal);
                binarioResultante = decimalABinario(decimal);
                JOptionPane.showMessageDialog(null,"El binario es " + binarioResultante);
                break;   
        }
        
    }
               
    
    public static boolean validarDecimal(int decimal) {
        return true;
    }

    public static boolean validarOctal(int octal) {
        
        String octalComoCadena = String.valueOf(octal);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            if (caracteresOctales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarHexadecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            if (caracteresHexadecimales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String decimalABinario(int decimal) {
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
    }

    public static int octalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int hexadecimalADecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
        }
        return decimal;
    }

}
