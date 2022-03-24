package es.amangil.listalibros;

public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private int numPaginas;
    private float Precio;
    private String fechaPublicacion;
    
    public Libro(){
        
    }
    
    public Libro(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    
    public Libro(String titulo, String autor, String ISBN, int numPaginas, float Precio, String fechaPublicacion){
        this.titulo = titulo.toUpperCase();
        this.autor = autor;
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
        this.Precio = Precio;
        this.fechaPublicacion = fechaPublicacion;
        
    }
    //
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    //
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    //
    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    //
    public int getnumPaginas() {
        return numPaginas;
    }
    
    public void setnumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    //
    public float getPrecio() {
        return Precio;
    }
    
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    //
    public String getfechaPublicacion() {
        return fechaPublicacion;
    }
    
    public void setfechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    //
    @Override
    public String toString(){
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "Autor: " + autor + "\n";
        
        return r;
    }
    
}
