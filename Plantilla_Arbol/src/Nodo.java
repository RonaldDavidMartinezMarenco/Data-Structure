/**
 *
 * @author MauroEnseña
 * https://www.youtube.com/@mauroensena3690?sub_confirmation=1
 *
 */

public class Nodo {

    private int numero;
    public Nodo izquierda = null;
    public Nodo derecha = null;
    
    Nodo(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nodo{" + "numero=" + numero + '}';
    }
}
