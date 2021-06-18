package gmibank.utilities;


import gmibank.pojos.Customer;
import gmibank.pojos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ReadText {

    public static void main(String[] args) {
        String a = "USAWeldon, King,com.github.javafaker.Name@68dd39d2@gmail.com, 476-41-8903";

        String arr[] = a.split(", ");
        System.out.println(arr[0]);
    }

    static String[] each;

    public static List<Customer> returnCustomer(String filePath) {
        List<Customer> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader((filePath)))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                Customer customer = new Customer();
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

                if (!(line == null)) {
                    each = line.split(", ");
                }
                /*customer.setFirstName(each[0]);
                customer.setLastName(each[1]);
                customer.setSsn(each[3]);
                customer.setEmail(each[2]);*/
                all.add(customer);
            }
            String everything = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Applicants> returnCustomerSNN(String filePath) {
        List<Applicants> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Applicants applicants = new Applicants();
                applicants.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(applicants);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Customer> readTxtData(String filePath) throws Exception {
        List<Customer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            Customer customer = new Customer();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
//                customer.setSsn(line);

            }
            String everything = sb.toString();

            //customer.setSsn(everything);
            list.add(customer);
        } finally {
            br.close();
        }
        return list;

    }

    public static List<StatesObject> returnAllStates(String filePath) {
        List<StatesObject> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                StatesObject state = new StatesObject();
                String[] allLine = line.split(",");

                int id = Integer.parseInt(allLine[1].trim());
                state.setId(id);
                state.setName(allLine[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(state);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCustomerSNNList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[2]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                i++;

                all.add(customer.getSsn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountryIdList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                CountryObject country = new CountryObject();
         //       country.setId(line.split(", ")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                i++;
       //         all.add(country.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCountryNameList(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                CountryObject country = new CountryObject();
                country.setName(line.split(", ")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                i++;
                all.add(country.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<StatesObject> returnAllStates2(String filePath) {
        List<StatesObject> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                StatesObject states = new StatesObject();
                states.setName(line.split(",")[0].trim());
                states.setId(Integer.parseInt(line.split(",")[1].trim()));
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(states);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnAllStates3(String filePath) {
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                String temp = "";
                temp = line.split(",")[0].trim();

                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }
}
