package com.company.services;

import com.company.books.LightNovel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LightNovelCSVService {

    private static LightNovelCSVService single_instance = null;

    private List<LightNovel> lightNovels = new ArrayList<LightNovel>();

    public static LightNovelCSVService getInstance()
    {
        if (single_instance == null)
            single_instance = new LightNovelCSVService();
        return single_instance;
    }

    public void setLightNovels(List<LightNovel> publishers) {
        this.lightNovels = lightNovels;
    }

    public List<LightNovel> getLightNovels() {
        return lightNovels;
    }


    public static void writeLightNovel(LightNovel lightNovel) throws FileNotFoundException {
        File csvOutputFile = new File("src/main/java/com/company/resources/lightnovel.csv");
        String formattedLightNovel = lightNovel.toCSV();

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedLightNovel);
        }
        catch (FileNotFoundException e){
            System.out.println("No file exists");
        }
    }
}
