package tutorial_run;

import java.io.IOException;

import afu.org.checkerframework.checker.units.qual.Length;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class AccessingDBObjects{

    public AccessingDBObjects() throws IOException{}

    public static void main(String[] args)throws IOException {

        Table storeData = Table.read().csv("C:/Users/Lee/Documents/JavaProjects/Data/storedata-cleaned.csv");

        //Check out some ways to interact with columns:
        InteractingWithColumns(storeData);
        //Check out some ways to interact with rows:
        InteractingWithRows(storeData);

    }

    //#region Interact With Columns
    static void InteractingWithColumns(Table storeData){
                //get the structure:
                Table localStructure = storeData.structure();
                System.out.println(localStructure);
        
                System.out.println(storeData.shape());
        
                Table nameAndSales = storeData.select("Product Name", "Sales");
                System.out.println(nameAndSales.columnNames());
        
                //retrieve a single column form the table
                DoubleColumn profit = (DoubleColumn) storeData.column("Discount");
                System.out.println(profit);
        
                //add a new column:
                //We can make a row that provides an index for each entry.
                double[] indices = new double[nameAndSales.rowCount()];
                for(int ii = 0; ii < indices.length; ii++){
                    indices[ii] = ii;
                }
                DoubleColumn myIndexColumn = DoubleColumn.create("indices",indices);
                storeData.insertColumn(0, myIndexColumn);
                System.out.println(storeData.columnNames());
        
                //Now, let's remove that new column:
                storeData.removeColumns("indices");
                System.out.println(storeData.columnNames());
        
                //All well and good but I would like to sort the table by a specific column
                //We do this by making a new table:
                Table mostSold = storeData.sortAscendingOn("Sales");
                System.out.println(mostSold.first(10));
    }
    //#endregion

    //#region Rows
    static void InteractingWithRows(Table storeData){
        //Let's look at the first five rows.
        System.out.println(storeData.first(5));
    }
    //#endregion
}
