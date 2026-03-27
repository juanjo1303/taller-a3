public class Usuario {
    private LinkedDoubleList<String> paginas = new LinkedDoubleList();

    public Usuario() {}

    public void addPage(String pagina) {
        paginas.addFirst(pagina);
    }

    public void visitPage(){}

    public void paginaPosterior(){
        paginas.forward();
    }

    public void paginaAnterior(){
        paginas.backward();
    }
}
