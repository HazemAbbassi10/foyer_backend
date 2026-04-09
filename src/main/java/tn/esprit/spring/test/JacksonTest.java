package tn.esprit.spring.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.spring.test.entities.Foyer;

public class JacksonTest {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = "{\"nomFoyer\": \"Foyer esprit 2\",\"capacityFoyer\": 500,\"blocs\": [{\"nomBloc\": \"Bloc A2\",\"capaciteBloc\": 150},{\"nomBloc\": \"Bloc B2\",\"capaciteBloc\": 350}]}";
            Foyer f = mapper.readValue(json, Foyer.class);
            System.out.println("Success! Foyer: " + f.nomFoyer);
            System.out.println("Bloc 0 foyer ref: " + (f.blocs.get(0).foyer == f ? "Correct" : "Null/Wrong"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
