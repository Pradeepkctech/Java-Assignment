package com.gcit.pradeep;
import java.util.Scanner;

public class Assesment2 {
    public static void main(String[] args) {
        System.out.println("\t\t\t**Marshelling and Unmarshelling**\nPress 1 to Marshelling\nPress 2 to UnMarshelling\nPress 3 to Exit\nEnter your option: ");
        Scanner get = new Scanner(System.in);
        int Menu = get.nextInt();
        switch(Menu){
            case 1:
                Marshelling();
                break;
            case 2:
                UnMarshelling();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println(Menu + " is not a valid option, please try again");
                main(null);

        }
    }
    public static void Marshelling() {
        try{
        String fileName;
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        System.out.println("Please enter Name: ");
        p.setName(sc.nextLine());

        System.out.println("Please Enter the Age: ");
        p.setAge(sc.nextInt());

        System.out.println("Please Enter the Gender by M or F : " );
        p.setSex(sc.next().charAt(0));

        System.out.println("Please Enter the year of birth: ");
        p.setYOB(sc.nextInt());

        fileName = p.getName() + "_"+ p.getYOB();
        System.out.println("Successfully saved to" + fileName + ".xml");
        System.out.println(p.Write(fileName));
        main(null);
        }
        catch
            (Exception e) {
                e.printStackTrace();
            }
    }

    public static void UnMarshelling() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter the Person name: ");
            String Name = sc.nextLine();
            System.out.println("Please Enter the Person YOB: ");
            String YOB = sc.nextLine();
            Person p = Person.Read(Name + "_" + YOB);

            if (p.getName() == null)
            {
              System.out.println("Record not found!");
            }
            else {
                System.out.println(p.toString());
            }
            main(null);

        } catch
        (Exception e) {
            e.printStackTrace();
        }
    }
}