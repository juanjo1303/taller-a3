import java.util.Comparator;
public class Cliente implements Comparable<Cliente>{
    private String name;
    private int id;

    Cliente(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return this.id == cliente.id;
    }
    @Override
    public int compareTo(Cliente o) {
        if (this.id < o.id){
            return 1;
        } else if (this.id > o.id){
            return -1;
        } else  {
            return 0;
        }
    }
    public String toString(){
        return this.id + " - " + this.name;
    }
}
