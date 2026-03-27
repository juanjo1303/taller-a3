package CircularLinkedList;

public class ReproductorMusica {

    private CircularLinkedList<String> lista;
    private Node<String> actual;

    public ReproductorMusica() {
        lista = new CircularLinkedList<>();
        actual = null;
    }

    public static void main(String[] args) {
        ReproductorMusica reproductor = new ReproductorMusica();

        // Agregar canciones
        reproductor.agregarCancion("Canción 1");
        reproductor.agregarCancion("Canción 2");
        reproductor.agregarCancion("Canción 3");
        reproductor.agregarCancion("Canción 4");

        System.out.println("🎵 Lista de reproducción:");
        reproductor.mostrarLista();

        // Mostrar actual
        System.out.println("\n▶ Reproduciendo: " + reproductor.obtenerActual());

        // Avanzar canciones
        reproductor.siguiente();
        System.out.println("⏭ Siguiente: " + reproductor.obtenerActual());

        reproductor.siguiente();
        System.out.println("⏭ Siguiente: " + reproductor.obtenerActual());

        reproductor.siguiente();
        System.out.println("⏭ Siguiente: " + reproductor.obtenerActual());

        // Aquí se demuestra lo circular
        reproductor.siguiente();
        System.out.println("🔁 Vuelve al inicio: " + reproductor.obtenerActual());

        // Eliminar canción
        System.out.println("\n❌ Eliminando 'Canción 2'...");
        reproductor.eliminarCancion("Canción 2");

        System.out.println("\n🎵 Lista actualizada:");
        reproductor.mostrarLista();

        // Seguir reproduciendo después de eliminar
        System.out.println("\n▶ Reproduciendo: " + reproductor.obtenerActual());
        reproductor.siguiente();
        System.out.println("⏭ Siguiente: " + reproductor.obtenerActual());
    }

    // Agregar canción
    public void agregarCancion(String cancion) {
        lista.addFirst(cancion);

        if (actual == null) {
            actual = lista.getFirst(); // empezamos desde la primera
        }
    }

    // Avanzar a la siguiente canción
    public void siguiente() {
        if (actual != null) {
            actual = actual.getNext(); // clave: es circular
        }
    }

    // Obtener canción actual
    public String obtenerActual() {
        if (actual == null) {
            return "No hay canciones";
        }
        return actual.getData();
    }

    // Eliminar una canción
    public void eliminarCancion(String cancion) {
        if (lista.isEmpty()) return;

        Node<String> aux = lista.getFirst();
        Node<String> anterior = null;

        do {
            if (aux.getData().equals(cancion)) {

                // Si es el actual, avanzamos
                if (aux == actual) {
                    actual = actual.getNext();
                }

                lista.removeData(cancion);
                return;
            }

            anterior = aux;
            aux = aux.getNext();

        } while (aux != lista.getFirst());
    }

    // Mostrar toda la lista
    public void mostrarLista() {
        if (lista.isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        Node<String> aux = lista.getFirst();

        do {
            System.out.println(aux.getData());
            aux = aux.getNext();
        } while (aux != lista.getFirst());
    }
    
}
