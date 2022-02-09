public class Main {
        static MyList myList = new MyList();
    public static void main(String[] args) {
        
        if(!myList.readFromFile("C:\\Users\\LENOVO\\Desktop\\CSD201\\LinkedListPerson\\src\\Input.txt")) System.out.println("Can not read the file!");
        else myList.traverse();
        myList.addBefore(myList.search("Trong"), new Person("Nga", 49));
        show();
        myList.sortByName();
        show();
        myList.sortByAge();
        show();
        myList.deleBaseOnIndex(1);
        show();
        myList.deleBaseOnName("Nga");
        show();
        myList.writeToFile("C:\\Users\\LENOVO\\Desktop\\CSD201\\LinkedListPerson\\src\\Output.txt");
    }
    
    static void show(){
        myList.traverse();
    }
    
}
