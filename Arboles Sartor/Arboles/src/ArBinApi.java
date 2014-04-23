/**
 * Created by Luciano on 26/03/14.
 */
public class ArBinApi {
    int suma;
    int suma3;
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
            //if ()
        }
       return false;
    }
}
