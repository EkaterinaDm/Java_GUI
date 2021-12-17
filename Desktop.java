package pr6;

class Desktop extends Computer
{
    private static String name = "настольный компьютер"; //статическая пере-менная
    int cost;
    int k;
    public Desktop(int cost){
        this.cost =cost;
    }
    
    public int cost(){
        return cost;
    }
    
    public String name(){
        return name;
    }
    
    public String put(){
        return (" - " + cost + " руб. - " + text + '\n');
        
    }
}
