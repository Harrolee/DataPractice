package tutorial_run;

import java.io.IOException;

import afu.org.checkerframework.checker.units.qual.Length;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class CleaningData{
    public CleaningData() throws IOException{}
    public static void main(String[] args)throws IOException {

        Table data = Table.read().csv("C:/Users/Lee/Documents/JavaProjects/Data/volcano_data_2010.csv");
        //create a sub table to work with specific columns:
        System.out.println(data.structure());
        //Table subTable

    }

}