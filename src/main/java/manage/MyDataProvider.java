package manage;

import model.Card;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> dataCardCSV() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
       // reader.readLine();
        String line= reader.readLine();
        while (line!=null){
            String[] split= line.split(",");
            list.add(new Object[]{Card.builder().cardName(split[0]).color(split[1]).build()});
            line=reader.readLine();
        }

        return list.iterator();
    }

}
