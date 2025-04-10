
public class ArbolBinario {

    Nodo raiz = null;

    public Nodo getRaiz() {
        return raiz;
    }
    boolean ingresado = false;

    public boolean ingresar_nodo(int num) {
        ingresado = false;
        raiz = ingresar_nodo(raiz, num);
        return ingresado;

    }

    //SObrecarga, distinto conjunto de metodos.
    private Nodo ingresar_nodo(Nodo raiz_actual, int key) {
        if (raiz_actual == null) {
            ingresado = true;
            raiz_actual = new Nodo(key);
            return raiz_actual;
        } else if (key < raiz_actual.getNumero()) {
            raiz_actual.izquierda = ingresar_nodo(raiz_actual.izquierda, key);
        } else if (key > raiz_actual.getNumero()) {
            raiz_actual.derecha = ingresar_nodo(raiz_actual.derecha, key);
        }

        return raiz_actual;
    }

    public void recorridos(int forma) {
        switch (forma) {
            case 1:
                System.out.println("INICIO PREORDEN");
                preorden(raiz);
                System.out.println("FIN PREORDEN");
                break;
            case 2:
                System.out.println("INICIO INORDEN");
                inorden(raiz);
                System.out.println("FIN INORDEN");
                break;
            case 3:
                System.out.println("INICIO POSORDEN");
                posorden(raiz);
                System.out.println("FIN POSORDEN");
                break;
        }

    }

    private void preorden(Nodo raiz_actual) {
        if (raiz_actual != null) {
            System.out.println(raiz_actual.toString());
            preorden(raiz_actual.izquierda);
            preorden(raiz_actual.derecha);

        }
    }

    private void inorden(Nodo raiz_actual) {
        if (raiz_actual != null) {
            inorden(raiz_actual.izquierda);
            System.out.println(raiz_actual.toString());
            inorden(raiz_actual.derecha);
        }
    }

    private void posorden(Nodo raiz_actual) {
        if (raiz_actual != null) {
            posorden(raiz_actual.izquierda);
            posorden(raiz_actual.derecha);
            System.out.println(raiz_actual.toString());
        }
    }

    private Nodo buscar_elemento(Nodo raiz_actual, int num) {
        if (raiz_actual != null) {
            if (raiz_actual.getNumero() == num) {
                return raiz_actual;
            } else if (num < raiz_actual.getNumero()) {
                return buscar_elemento(raiz_actual.izquierda, num);
            } else if (num > raiz_actual.getNumero()) {
                return buscar_elemento(raiz_actual.derecha, num);
            }
        }
        return null;
    }

    public Nodo buscar_elemento(int data) {
        Nodo r = buscar_elemento(raiz, data);
        return r;
    }

    /*
        Tenemos 3 casos:
        1. Que sea un nodo hoja (sin hijos)
        2. Que tenga un solo hijo
        3. Que tenga 2 hijos
    
        Para el caso 3 se siguen estos pasos:
    
        -Encontrar el minimo de la derecha o  el maximo de la izquierda
        -guardar el valor en el nodo raiz nodo
        -eliminar el duplicado de la derecha del subarbol o de la izquierda.
     */
    public void eliminar(int num) 
    {
        raiz = eliminar(raiz,num);
        
    }
    private Nodo eliminar(Nodo raiz, int num){
        if (raiz == null) {
            return null;
        }
        else if(num < raiz.getNumero())
        {
            // 3 < 12
            // 3 < 5
            // lo encontramos
            //Me regresa num 1
            //raiz.izquierda = 1;
            raiz.izquierda = eliminar(raiz.izquierda, num);
        }
        else if(num > raiz.getNumero()){
                
            raiz.derecha = eliminar(raiz.derecha, num);
        }
        else{
            //Caso 1: Nodo Hoja.
            if (raiz.izquierda == null && raiz.derecha == null) 
            {
                raiz = null;
            }
            //Caso 2: Tiene un hijo por la izquierda o tiene un hijo por la derecha.
            else if(raiz.izquierda == null)
            {
                raiz = raiz.derecha;
            }
            else if(raiz.derecha == null){
                raiz = raiz.izquierda;
            }
            //Caso 3: Tiene dos hijos
            else
            {
               Nodo temp = min(raiz);
               raiz.setNumero(temp.getNumero());
               raiz.derecha = eliminar(raiz.derecha,temp.getNumero());
            }
        }
        return raiz;
    }
    
    //Buscar del lado derecho
    private Nodo min(Nodo raiz)
    {
        while (raiz.izquierda != null)
        {            
            raiz = raiz.izquierda;
        }
        return raiz;
    }
    
    
    //Buscar del lado izquierda
    private Nodo max(Nodo raiz)
    {
        while(raiz.derecha != null){
            raiz = raiz.derecha;
        }
        return raiz;
    }

}
