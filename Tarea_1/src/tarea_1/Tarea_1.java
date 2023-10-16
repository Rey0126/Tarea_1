package tarea_1;

import java.util.ArrayList;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class Tarea_1 {

    static ArrayList<Producto> array = new ArrayList<>();

    public static void main(String[] args) {

        boolean menu = true;

        while (menu) {

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                               == Menú ==
                               1. Agregar Producto
                               2. Listar producto
                               3. Buscar producto
                               4. Modificar producto
                               5. Eliminar producto
                               6. Salir 
                               Ingrese una opcion:  """));

            switch (opcion) {

                case 1:

                    agregarProducto();

                    break;

                case 2:

                    printArray();

                    break;

                case 3:

                    System.out.println("");
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a buscar: ");
                    buscar(nombre);

                    break;

                case 4:

                    printArray();
                    int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del producto que desea modificar: "));
                    JOptionPane.showMessageDialog(null, "Has seleccionado el producto " + array.get(index - 1).getNombre());
                    modificar(index);

                    break;

                case 5:

                    printArray();
                    int index2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del producto que desea eliminar: "));
                    JOptionPane.showMessageDialog(null, "Has seleccionado el producto " + array.get(index2 - 1).getNombre());
                    eliminar(index2 - 1);

                    break;

                case 6:

                    menu = false;

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "¡Opción Inválida!");

            }

        }

    }

    public static void agregarProducto() {

        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto: ");

        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del producto: "));

        String descrip = JOptionPane.showInputDialog(null, "Ingrese la descripcion del producto: ");

        double precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del producto: "));

        while (precio <= 0) {
            JOptionPane.showMessageDialog(null, "¡El precio del producto no puede ser 0!");
            precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del producto: "));
        }

        Color color = JColorChooser.showDialog(null, "Ingrese el color del producto:", Color.yellow);

        int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de expiracion: "));

        while (year < 2023) {
            JOptionPane.showMessageDialog(null, "¡El año de expiracion no puede ser menor al actual!");
            year = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de expiracion: "));
        }

        int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de expiracion: "));

        while (month <= 0 || month > 12) {
            JOptionPane.showMessageDialog(null, "¡El mes de expiracion es invalido!");
            month = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de expiracion: "));
        }

        int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dìa de expiracion: "));

        while (day <= 0 || day > 31) {
            JOptionPane.showMessageDialog(null, "¡El dia de expiracion es invlaido!");
            day = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de expiracion: "));
        }

        Date fechaExp = new Date(year - 1900, month - 1, day);

        JOptionPane.showMessageDialog(null, "¡Producto agregado exitosamente!");

        array.add(new Producto(name, codigo, descrip, precio, color, fechaExp));

    }

    public static void printArray() {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < array.size(); i++) {

            JOptionPane.showMessageDialog(null, "Producto " + (i + 1) + ": " + array.get(i).getNombre() + "\nCodigo producto: " + array.get(i).getCodigo() + "\nDescripcion: " + array.get(i).getDescrip() + "\nPrecio: " + array.get(i).getPrecio() + "\nColor: " + array.get(i).getColor() + "\nFecha de expiracion: " + "[" + df.format(array.get(i).getFechaexp()) + "]" + "\n");

        }

    }

    public static void modificar(int index) {

        int atributo = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué atributo deseas modificar?\n1. Nombre\n2. Codigo\n3. Descripcion\n4. Precio\n5. Color\n6. Fecha de expiracion\n Ingrese una opcion: "));

        switch (atributo) {

            case 1:

                String name2 = JOptionPane.showInputDialog(null, "Modificara el nombre del producto, ingrese un nuevo nombre:");
                array.get(index - 1).setNombre(name2);
                JOptionPane.showMessageDialog(null, "¡Nombre modificado exitosamente!");

                break;

            case 2:

                int codigo2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Modificara el codigo del producto, ingrese un nuevo codigo:"));
                array.get(index - 1).setCodigo(codigo2);
                JOptionPane.showMessageDialog(null, "¡Codigo modificado exitosamente!");

                break;

            case 3:

                String descrip2 = JOptionPane.showInputDialog(null, "Modificara la desccripcion del producto, ingrese una nueva descripcion:");
                array.get(index - 1).setDescrip(descrip2);
                JOptionPane.showMessageDialog(null, "¡Descripcion modificada exitosamente!");

                break;

            case 4:

                int precio2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Modificara el precio del producto, ingrese un nuevo precio:"));
                array.get(index - 1).setPrecio(precio2);
                JOptionPane.showMessageDialog(null, "¡Precio modificado exitosamente!");

                break;

            case 5:

                Color color2 = JColorChooser.showDialog(null, "Modificara el color del producto, ingrese un nuevo color:", Color.white);
                array.get(index - 1).setColor(color2);
                JOptionPane.showMessageDialog(null, "¡Color modificado exitosamente!");

                break;

            case 6:

                int year2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo año de expiracion: "));

                while (year2 < 2023) {
                    JOptionPane.showMessageDialog(null, "¡El año de expiracion no puede ser menor al actual!");
                    year2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de expiracion: "));
                }

                int month2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo mes de expiracion: "));

                while (month2 <= 0 || month2 > 12) {
                    JOptionPane.showMessageDialog(null, "¡El mes de expiracion es invalido!");
                    month2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de expiracion: "));
                }

                int day2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dìa de expiracion: "));

                while (day2 <= 0 || day2 > 31) {
                    JOptionPane.showMessageDialog(null, "¡El dia de expiracion es invlaido!");
                    day2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de expiracion: "));
                }

                Date fechaExp2 = new Date(year2 - 1900, month2 - 1, day2);

                array.get(index - 1).setFechaexp(fechaExp2);
                JOptionPane.showMessageDialog(null, "¡Fecha modificada exitosamente!");

                break;

            default:
                JOptionPane.showMessageDialog(null, "¡Opción Inválida!");
        }

    }

    public static void buscar(String nombre) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean hay = false;

        for (int i = 0; i < array.size(); i++) {

            if (nombre.equalsIgnoreCase(array.get(i).getNombre())) {

                JOptionPane.showMessageDialog(null, "Producto " + (i + 1) + ": " + array.get(i).getNombre() + "\nCodigo producto: " + array.get(i).getCodigo() + "\nDescripcion: " + array.get(i).getDescrip() + "\nPrecio: " + array.get(i).getPrecio() + "\nColor: " + array.get(i).getColor() + "\nFecha de expiracion: " + "[" + df.format(array.get(i).getFechaexp()) + "]" + "\n");
                hay = true;
            }

        }
        if (!hay) {
            JOptionPane.showMessageDialog(null, "No hay productos con ese nombre");

        }

    }

    public static ArrayList<Producto> eliminar(int index2) {

        array.remove(index2);

        return array;
    }

}
