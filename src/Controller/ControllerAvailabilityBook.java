/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.ControllerBook.listBook;
import Model.Book;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipecunha
 */
public class ControllerAvailabilityBook {

    public void gererateAvailabilityBookFile() {
        
        String IdBook;
        String AvalabilityBook;

        try{
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/listAvailableBook_table.csv", false));
            
            myWriter.write("Id Book" + "," + "Avalability ");
            myWriter.newLine();
            for (int i =0; i<ControllerBook.listAvailableBook.size(); i++) {
                
                 IdBook = ControllerBook.listAvailableBook.get(i).getIdBook();
                 AvalabilityBook = Boolean.toString(ControllerBook.listAvailableBook.get(i).isIsAvailable());
                 
                 myWriter.write(IdBook + "," + AvalabilityBook);
                 myWriter.newLine();

              

            }
            myWriter.close();

        }catch (Exception e){

            System.out.println("Error writing on txt! ");
        }
    }

    public boolean checkBookAvailability() {

        ControllerBook myCB = new ControllerBook();

        //call the method to search book by title
          Book myBook = myCB.searchBookByTitle();
        
        for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++) {

            if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())) {

                if (ControllerBook.listAvailableBook.get(i).isIsAvailable() == false) {
                    return  false;
                }
            } 
        }
        return true;
    }
    
    
}
