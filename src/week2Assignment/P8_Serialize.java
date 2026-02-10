package week2Assignment;

import java.io.*;

/*
* Create a class User that implements Serializable with fields: -
• username
• password (marked as transient)
• email
• Serialize the object to a file.
• Deserialize it and print all field values.
• Explain why the password value is not restored.
* */


class TestSerialize implements Serializable{
    String userName = "Michael";
    transient String password = "123455555556789";
    String email = "michael@goat.com";

}

public class P8_Serialize {
    public static void main(String[] args) {


        TestSerialize testSerialize = new TestSerialize();
        String fileName = "ClientData.md";
        // this is below code is to serialize the class
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){

            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            out.writeObject(testSerialize);

            out.close();

            System.out.println("the object is serialized");


        } catch (IOException e) {
            System.out.println(e);
        }

        // this below code is to deSerialize the class

        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
            ObjectInputStream in = new ObjectInputStream(fileInputStream);

            testSerialize = (TestSerialize) in.readObject();

            System.out.println(testSerialize.email);
            System.out.println(testSerialize.password);
            System.out.println(testSerialize.userName);

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}


/*
*  OutPut:
*           the object is serialized
*           michael@goat.com
*           null
*           Michael
*   you can also access the Markdown file generated (ClientData)
* */