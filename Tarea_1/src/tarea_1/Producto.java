
package tarea_1;

import java.awt.Color;
import java.util.Date;


public class Producto {
   
     private int codigo;
    private String descrip;
    private String nombre;
    private Color color;
    private double precio;
    private Date fechaExp;

    public Producto(String nombre, int codigo, String descrip, double precio, Color color, Date fechaExp) {
        this.codigo = codigo;
        this.descrip = descrip;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.fechaExp = fechaExp;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaexp() {
        return fechaExp;
    }

    public void setFechaexp(Date fechaexp) {
        this.fechaExp = fechaexp;
    }
    
}
