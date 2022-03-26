
public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.readFromFile("C:\\Users\\LENOVO\\Desktop\\CSD201\\Song\\src\\Data\\song.txt");
        myList.traverse();
        System.out.println("Display the average of all rated in the list: " + myList.average());
        myList.deleteThird();
        myList.writeToFile("C:\\Users\\LENOVO\\Desktop\\CSD201\\Song\\src\\Data\\output.txt");
        myList.removeDuplicatedSong();
        myList.traverse();
        
    }
    //C:\Users\LENOVO\Desktop\CSD201\Song\src\Data
}
