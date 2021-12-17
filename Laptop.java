package pr6;

class Laptop extends Computer
{
    private static String name = "ноутбук"; //статическая переменная
    int cost;
    int k;
    public Laptop(int cost){
        this.cost = cost;
    }
    
    public int cost(){
        return cost;
    }
    
    public String name(){
        return name;
    }
    
    public String put2(){
        return (" - " + cost + " руб. - " + text + '\n');
    }
}
