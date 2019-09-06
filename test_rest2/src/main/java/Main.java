import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.data.Data;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = new Data();
        data.setId(1);
        data.setName("Jon");
        data.setVoting(true);

        String result = objectMapper.writeValueAsString(data);

        //System.out.println(result);

        final File FILENAME = new File("/home/cardinal/ext-test-project/test_rest2/src/main/resources/test.json");

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(FILENAME, data);
            // here i read the position from the *.json file
            Data readValue = mapper.readValue(FILENAME, Data.class);
            System.out.println(readValue.getId() + "N, " + readValue.getName() + "E" );
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }