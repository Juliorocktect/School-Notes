public class Lorenz extends Student {
    private String name;
    private Integer age;
    private static int[] liste = {1,3,65,45,4,7,3,3,4,6778,567};

    public Lorenz(String name,int age,String school,int schoolYear) {
        super(school,schoolYear);
        this.name = name;
        this.age = age;
    }

    public static void lorenzIchKannNichtMehr(int zahl, int zahl2){
        int summe = zahl+zahl2;
        System.out.println(summe);
    }
    public static String lorenz(){
        return "Lorenz";
    }

    public void suui(String name){

    }
    public static int maximum(){
        int max = liste[0];
        for (int i = 0; i < liste.length;i++){
            if (liste[i] > max){
                max = liste[i];
            }
        }
        return max;
    }
    public static void swap(int i,int j){
        int tmp = liste[i];
        liste[i] = liste[j];
        liste[j] = tmp;
    }
    public static int[] selectionSort(){
        for (int i = 0; i < liste.length;i++) {
        }
        return null;
    }

    public static int multiplizieren(int zahl1, int zahl2){
        return zahl1 * zahl2;
    }


    public static void main(String args[]){
        int lorenz2 = 22;
        Lorenz lorenz1 = new Lorenz("Lorenz",15,"rsg",10);
        lorenzIchKannNichtMehr(3, 3);
        System.out.println(lorenz1.getSchool());
        System.out.println(maximum());
        int produkt = multiplizieren(2, 3);
        System.out.println(produkt);
    }
}
