/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.workersorganizationandmanagementapp;

/**
 *
 * @author رهف
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class WorkersOrganizationAndManagementApp {
    
    public String viewRankedAvailableWorkers(String service)
            throws FileNotFoundException {

        Scanner input = new Scanner(new File("workers.txt"));

        ArrayList<String[]> workers = new ArrayList<>();

        while (input.hasNextLine()) {

            String[] data = input.nextLine().split(",");

            if (data[1].equalsIgnoreCase(service)
                    && !data[3].equals("No available times")) {

                workers.add(data);
            }
        }

        input.close();

        if (workers.isEmpty()) {
            return "No available workers";
        }

        workers.sort((a, b) -> Double.compare(
            Double.parseDouble(b[2]),
            Double.parseDouble(a[2])));

        String result = "";

        for (String[] worker : workers) {

            result += worker[0]
                + " - Rating: " + worker[2]
                + " - Available Times: " + worker[3] + "\n";
        }

        return result;
    
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        WorkersOrganizationAndManagementApp system = new WorkersOrganizationAndManagementApp();
        System.out.print("Enter service: ");
        String service = scanner.nextLine();
        System.out.println(system.viewRankedAvailableWorkers(service));
    }
}
