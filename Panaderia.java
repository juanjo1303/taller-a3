public class Panaderia {
    LinkedSimpleList<Cliente> clientes = new LinkedSimpleList<>();

    public Panaderia(){}

    public void agregar(Cliente cliente){
        clientes.addLast(cliente);
    }

    public void atender(Cliente cliente){
        clientes.removeFirst();
        System.out.println("El cliente: "+cliente+" ha sido atendido.");
    }
}
