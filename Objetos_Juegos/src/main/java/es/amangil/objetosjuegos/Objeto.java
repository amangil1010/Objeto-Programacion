package es.amangil.objetosjuegos;

public class Objeto {

    private String Nombre;
    private String Propietario;
    private String Calidad;
    private int numUnidades;
    private float Precio;
    private String fecha;
    
    public Objeto(){
        
    }
    
    public Objeto(String Nombre){
        this.Nombre = Nombre;
    }
    
    public Objeto(String Nombre, String Propietario, String Calidad, int numUnidades, float Precio, String fecha){
        this.Nombre = Nombre;
        this.Propietario = Propietario;
        this.Calidad = Calidad;
        this.numUnidades = numUnidades;
        this.Precio = Precio;
        this.fecha = fecha;
    }
    //
    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    //
    public String getPropietario() {
        return Propietario;
    }
    
    public void setPropietario(String Propietario) {
        this.Propietario = Propietario;
    }
    //
    public String getCalidad() {
        return Calidad;
    }
    
    public void setCalidad(String Calidad) {
        this.Calidad = Calidad;
    }
    //
    public int getnumPaginas() {
        return numUnidades;
    }
    
    public void setnumPaginas(int numPaginas) {
        this.numUnidades = numPaginas;
    }
    //
    public float getPrecio() {
        return Precio;
    }
    
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    //
    public String getfecha() {
        return fecha;
    }
    
    public void setfecha(String fecha) {
        this.fecha = fecha;
    }
    //
    @Override
    public String toString(){
        String r = "";
        r += "Nombre: " + Nombre + "\n";
        r += "Propietario: " + Propietario + "\n";
        
        return r;
    }
    
}
