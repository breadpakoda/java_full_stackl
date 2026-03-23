


public class Testing {

    public static void main(String[] args) {
        Sql_connection obj= new Sql_connection ();
        obj.create_conntection("javadb","root","12345","insert into details values(1,'aditya')");
    }
    
}
