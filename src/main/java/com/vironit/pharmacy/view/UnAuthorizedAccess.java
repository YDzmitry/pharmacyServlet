package com.vironit.pharmacy.view;


import com.vironit.pharmacy.service.MedicineServiceImpl;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class UnAuthorizedAccess  {

    private  Scanner input = new Scanner(System.in);

    public void service()  {
        info();
        try {
            int valueChoice = input.nextInt();
            serviceAction(valueChoice);
        }catch (NoSuchElementException ex){
            System.out.println("Please make right choice");
        } catch (Exception ex) {
            //кастом генерик ексепшн
        }
        finally {

        }
    }

    private void serviceAction(int valueChoice) {
        if (valueChoice == 1) {
            MedicineServiceImpl medicineService = new MedicineServiceImpl();
            //medicineService.getListMedicine();
        } else if (valueChoice == 2) {

        } else if (valueChoice == 3){

        }else {
            System.out.println("");
        }
    }

    private void info() {
        System.out.println("Choose the destiny");
        System.out.println("1.Просмотр лекарств");
        System.out.println("2.Авторизация");
        System.out.println("3.Регистрация");
    }
}
