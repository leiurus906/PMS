import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pass_Manager_Admin {

    private int currentPolicy [];
    private ArrayList<int[]> policies = new ArrayList<>();
    private final int defaultPolicy [] = new int [] {18,4,6,3,5};
    private Password_Generator password_generator;
    private String path;
    private static final String KEY = "";
    private static final String SALTVALUE = "";

    Pass_Manager_Admin() {
        policies.add(defaultPolicy);
        currentPolicy = defaultPolicy;
        this.password_generator = new Password_Generator();
    }

    public void setCurrentPolicy(int[] currentPolicy) {
        this.currentPolicy = currentPolicy;
        this.password_generator = new Password_Generator(currentPolicy[0],currentPolicy[1],currentPolicy[2],currentPolicy[3],currentPolicy[4]);
    }

    public void addNewPolicy(int [] policy){
        this.policies.add(policy);
    }

    public String generatePassword(){
        return this.password_generator.generatePassword();
    }

    public void generateBatchPasswords(int numberOfPasswordsToBeGenerated, String path){
        this.path = path;
        File file = new File(path);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = { "Password policy: " + "Password Length: " + currentPolicy[0] + ", Number of UpperCase Characters: " + currentPolicy[1] + ", Number of LowerCase Characters: "+currentPolicy[2]+", Number of Decimal Characters: "+currentPolicy[3]+", Number of Special Characters: "+currentPolicy[4]};
            writer.writeNext(header);

            for(int i = 0;i<numberOfPasswordsToBeGenerated;i++){
            String data [] = {this.password_generator.generatePassword()};
            writer.writeNext(data);
            }
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayAllPasswords(String path){
        if (!path.equals(this.path)&& !path.isEmpty())
            this.path = path;
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(this.path);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
