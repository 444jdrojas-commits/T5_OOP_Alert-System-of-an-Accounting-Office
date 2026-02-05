package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.*;

/**
 *
 * @author Paulo Ramos
 */
public class TaxConfig {

    private static TaxConfig instance;
    private double iva;

    private static final String FILE_PATH = "config/config.json";

    private TaxConfig() {
        load();
    }

    public static synchronized TaxConfig getInstance() {
        if (instance == null) {
            instance = new TaxConfig();
        }
        return instance;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
        save();
    }

    private void load() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            JsonObject json = new Gson().fromJson(reader, JsonObject.class);
            iva = json.get("iva").getAsDouble();
        } catch (Exception e) {
            iva = 0.15;
            save();
        }
    }

    private void save() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            JsonObject json = new JsonObject();
            json.addProperty("iva", iva);
            new Gson().toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
