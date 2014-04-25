import java.io.*;
import java.util.ArrayList;

/**
 * Created by Luciano on 26/03/14.
 */
public class ArBinApi {
    int suma;
    int suma3;
    int count;
    ArrayList<Object>frontera = new ArrayList<Object>();
    public int peso(ArBin a){
        if (a.isEmpty()){
            return 0;
        } else{
            return (1+peso(a.getLeft())+peso(a.getRight()));
        }
    }
    public int hojas(ArBin a){
        int num =0;
        if (a.isEmpty()){
            return 0;
        }else{
            if (a.getLeft().isEmpty()){
            if (a.getRight().isEmpty()){
                num++;
                return num;
            }   else{
                num++;
                num = num +(hojas(a.getRight()));
            }
        } else{
             num++;
             num = num+hojas(a.getLeft());
             if (a.getRight().isEmpty()){
                 return num;
            }else{
                 num = num+hojas(a.getRight());
             }
        }
        }
        return num;
    }
    public int appearances(ArBin arbolAnalizado, Object buscado){
        int appe = 0;
        if (arbolAnalizado.isRoot()==buscado){
           appe++;
        }
        if (arbolAnalizado.getLeft()!=null){
            appearances(arbolAnalizado.getLeft(), buscado);
        }
        if (arbolAnalizado.getRight()!=null){
            appearances(arbolAnalizado.getRight(), buscado);
        }
        return appe;
    }
    public int levelElements(ArBin a){
        int elements = 0;
        if (a.isRoot()!=null){
            elements++;
        }
        if (a.getRight()!=null){
            levelElements(a.getRight());
        }
        if (a.getLeft()!=null){
            levelElements(a.getLeft());
        }
        return elements;
    }
    public int height(ArBin a){
        if (a.isEmpty()){
            return -1;
        }else{
            if (a.getLeft().isEmpty()&&a.getRight().isEmpty()){
                return 0;
            }else{
                return 1+ (Math.max(height(a.getRight()), height(a.getLeft())));
            }
        }
    }
    public int sum(ArBin a){
        if (a.isEmpty()){
            return 0;
        }else{
            if (a.getLeft().isEmpty()&&a.getRight().isEmpty()){
                return (Integer) a.isRoot();
            }else{
                int b = (Integer) a.isRoot();
                suma = suma+b;
                suma = suma+ sum(a.getLeft());
                suma = suma +sum(a.getRight());
            }
        }
        return suma;
    }
    public int sum3(ArBin a){
        if (a.isEmpty()){
            return 0;
        }else{
            if (a.getLeft().isEmpty()&&a.getRight().isEmpty()){
                int b = (Integer) a.isRoot();
                if (b%3 == 0){
                    return b;
                }else{
                    return 0;
                }
            }else{
                int b = (Integer) a.isRoot();
                if (b%3==0){
                    suma3 = suma3+b;
                }
                suma3 = suma3+ sum3(a.getLeft());
                suma3 = suma3 +sum3(a.getRight());
            }
        }
        return suma3;
    }
    public boolean areEqual(ArBin a1, ArBin a2){
        if (a1.isEmpty()&&a2.isEmpty()){
            return true;
        }else{
            if ((a1.isEmpty())||(a2.isEmpty())){
                return false;
            }else{
                if (a1.isRoot().equals(a2.isRoot())){
                    return ((areEqual(a1.getLeft(),a2.getLeft()))&&(areEqual(a1.getRight(),a2.getRight())));
                }
                return false;
            }
        }
    }
    public boolean areIsomorf(ArBin a1, ArBin a2){
        if ((a1.isEmpty())&&(a2.isEmpty())){
            return true;
        }else{
            if ((!(a1.isEmpty()))&&(!(a2.isEmpty()))){
                return ((areIsomorf(a1.getLeft(), a2.getLeft()))&&(areIsomorf(a1.getRight(),a2.getRight())));
            }else{
                return false;
            }
        }
    }
    public boolean semejante(ArBin a1, ArBin a2){
        if ((a1.isEmpty())&&(a2.isEmpty())){
            return true;
        }else{
            if (peso(a1)==peso(a2)){
                return (checkSemejante(a1,a2));
            }else{
                return false;
            }
        }
    }
    private boolean checkSemejante(ArBin a1, ArBin a2){
        if (a1.isEmpty()){
            return true;
        }else if((appearances(a2,a1.isRoot()))==1){
            return checkSemejante(a1.getLeft(),a2)&&(checkSemejante(a1.getRight(),a2));
            }else{
                return false;
                }
        }
    public boolean complete(ArBin a1){
        if (a1.isEmpty()){
            return true;
        }else{
            if ((a1.getLeft().isEmpty())&&(a1.getRight().isEmpty())){
                return true;
            }else{
                if ((!(a1.getLeft().isEmpty()))&&(!(a1.getRight().isEmpty()))){
                    return ((complete(a1.getLeft())&&(complete(a1.getRight()))));
                }else{
                   return false;
                }
            }
        }
    }
    public boolean lleno(ArBin a1){
        int alt  = height(a1);
        if (a1.isEmpty()){
            return true;
        }else{
            if ((a1.getLeft().isEmpty())&&(a1.getRight().isEmpty())){
                return true;
            }else{
               int nivelIzq = isLleno(a1.getLeft(),alt);
               count = 0;
               int nivelDer = isLleno(a1.getRight(),alt);
               if (nivelIzq==nivelDer){
                   return true;
               }else{
                   return false;
               }
            }
        }
    }
    private int isLleno(ArBin a1,int altura){
        if ((a1.getLeft().isEmpty())&&(a1.getRight().isEmpty())){
             return count;
        }else{
            count++;
            int temp = count;
            int izq = isLleno(a1.getLeft(),altura);
            count = temp;
            int der = isLleno(a1.getRight(),altura);
            if (izq>der){
                return izq;
            }else{
                return der;
            }
        }
    }
    public boolean stable(ArBin a1){
        if (a1.isEmpty()){
            return true;
        }else{
            if ((a1.getLeft().isEmpty())&&(a1.getRight().isEmpty())){
                return true;
            }else{
                int dad = (Integer) a1.isRoot();
                return checkStable(a1,dad);
            }
        }
    }
    private boolean checkStable(ArBin a1, int dad){
        if ((((Integer)a1.getLeft().isRoot())>=dad)||(((Integer)a1.getRight().isRoot())>=dad)){
            return false;
        }else{
            return ((checkStable(a1.getLeft(),dad))&&(checkStable(a1.getRight(),dad)));
        }
    }
    public boolean ocurreArBin(ArBin a1, ArBin a2){
        if ((a1.isEmpty())&&(a2.isEmpty())){
            return true;
        }else{
            if ((a1.isEmpty())||(a2.isEmpty())){
                return true;
            }else{
                if (a2.equals(a1)){
                    return true;
                }else{
                    return ((ocurreArBin(a1.getLeft(),a2))||(ocurreArBin(a1.getRight(),a2)));
                }
            }
        }
    }
    public void viewFrontier(ArBin a){
        if (a.isEmpty()){
            System.out.println("Empty tree");
        }else{
            if ((a.getLeft().isEmpty())&&(a.getRight().isEmpty())){
                System.out.println(a.isRoot());
            }else{
                viewFrontier(a.getLeft());
                viewFrontier(a.getRight());
            }

        }
    }
    public ArrayList<Object> frontier(ArBin a,Object elem){
        if (a.isEmpty()){
            return null;
        }else{
            if ((a.getLeft().isEmpty())&&(a.getRight().isEmpty())){
                frontera.add(a.isRoot());
            }else{
                viewFrontier(a.getLeft());
                viewFrontier(a.getRight());
            }

        }
        return frontera;}
    public void preorder(ArBin a){
        if(!(a.isEmpty())){
            System.out.print(a.isRoot() + " ");
            preorder(a.getLeft());
            preorder(a.getRight());
        }
    }
    public void inorder(ArBin a){
        if (!(a.isEmpty())){
            inorder(a.getLeft());
            System.out.println(a.isRoot());
            inorder(a.getRight());
            }
        }
    public void postorder(ArBin a){
        if (!(a.isEmpty())){
            postorder(a.getLeft());
            postorder(a.getRight());
            System.out.println(a.isRoot());
        }
    }
    public void levelOrder(ArBin a){
        QueueD cola = new QueueD();
        ArBin aux = a;
        ArBin root = a;
        if (!(a.isEmpty())){
            cola.enqueue(a.isRoot());
            ArBin i = a.getLeft();
            ArBin d = a.getRight();
            while ((!(i.isEmpty()))&&(!(d.isEmpty()))){
                if(!(i.isEmpty())){
                    cola.enqueue(i.isRoot());
                }
                if (!(d.isEmpty())){
                    cola.enqueue(d.isRoot());
                }
                a = a.getLeft();
                i = a.getLeft();
                d = a.getRight();
                if ((!(aux.getRight().getLeft().isEmpty()))||(!(aux.getRight().getRight().isEmpty()))){
                    ArBin temp = aux.getLeft().getLeft();
                    boolean cnd;
                    cnd = i.isEmpty() || i.isRoot() == temp.isRoot();
                    if (!(cnd)){
                        a = aux.getRight();
                        i = a.getLeft();
                        d = a.getRight();
                    }
                }
                if ((!(aux.getRight().getLeft().isEmpty()))||(!(aux.getRight().getRight().isEmpty()))){
                    boolean cnd = a.isRoot() == aux.getLeft().isRoot();
                    if (!cnd){
                        a = aux.getRight();
                        aux = aux.getRight();
                        i = a.getLeft();
                        d = a.getRight();
                    }
                }
            }
        }
        while(!(cola.isEmpty())){
            System.out.println(cola.dequeue());
        }
    }
    public void saveTree(ArBin a){
        try{
            FileOutputStream file = new FileOutputStream("Tree.ser");
            ObjectOutputStream ob = new ObjectOutputStream(file);
            ob.writeObject(a);
            ob.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public ArBin loadTree(){
        try{
            FileInputStream file = new FileInputStream("Tree.ser");
            ObjectInputStream ob = new ObjectInputStream(file);
            ArBin a = (ArBin) ob.readObject();
            ob.close();
            return a;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException i){
            i.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        return null;
    }
}
