public class Main {
        static MyList myList = new MyList();
    public static void main(String[] args) {
        
        if(!myList.readFromFile("src\\Input.txt")) System.out.println("Can not read the file!");
        else myList.traverse();
        myList.addBefore(myList.search("Trong"), new Person("Nga", 49));
        show();
        myList.sortByName();
        show();
        myList.sortByAge(0, 3);
        show();
        myList.deleBaseOnIndex(1);
        show();
        myList.deleBaseOnName("Nga");
        show();
        myList.writeToFile("src\\Output.txt");
    }
    
    static void show(){
        myList.traverse();
    }
    
}
