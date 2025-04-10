
/**
 *
 * @author MauroEnseña
 * https://www.youtube.com/@mauroensena3690?sub_confirmation=1
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    private ArbolBinario abin = new ArbolBinario();

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menu();
    }

    public void menu() {
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("""
                    Arbol binario de busqueda
                    Seleccione una opcion.
                    1. Ingresar un elemento.
                    2. Recorrer el arbol.
                    3. Buscar un elemento.
                    4. Eliminar un elemento.
                    5. Operaciones.
                    6. Salir."""));
            switch (op) {
                case 1: {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:"));
                    if (abin.ingresar_nodo(numero) == true) {  //LLamamos metodo ingresar un nodo 
                        JOptionPane.showMessageDialog(null, "Elemento guardado"); // Elemento guardado ya que comprobamos con el metodo boolean.
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento no guardado");
                    }

                }
                break;
                case 2: {
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog("""                                                                              
                            Seleccione un recorrido
                                    1. Preorden.
                                    2. Inorden.
                                    3. Posorden.
                                    4. salir.
                            """));
                        abin.recorridos(op);
                    } while (op != 4);
                }
                break;
                case 3: {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero a buscar:"));

                    try {
                        Nodo r = abin.buscar_elemento(numero);
                        System.out.println("Valor encontrado: " + r.getNumero());
                        JOptionPane.showMessageDialog(null, "Si existe el elemento.");
                    } catch (Exception e) {
                        System.out.println("El nodo no existe.");
                        JOptionPane.showMessageDialog(null, "No existe el elemento.");
                    }
                }

                break;
                case 4: {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el elemento a eliminar :"));
                    try {
                        abin.eliminar(numero);
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente el elemento.");
                    } catch (Exception e) {
                        System.out.println("El nodo no existe.");
                        JOptionPane.showMessageDialog(null, "No existe el elemento.");
                    }
                }
                break;
                case 5: {
                    contador_pos = 0;
                    positivos(abin.getRaiz());
                    System.out.println("Positivos: "+contador_pos);

                }
                break;
            }
        } while (op != 6);
    }
    int contador_pos = 0;
    //Hacer que el contador este dentro del metodo.
    private void positivos(Nodo raiz_actual){
        if (raiz_actual != null) {
            positivos(raiz_actual.izquierda);
            if (raiz_actual.getNumero() > 0) {
                contador_pos++;
            }
            positivos(raiz_actual.derecha);
        }
    }
    
    
}
