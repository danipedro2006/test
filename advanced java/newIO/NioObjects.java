package main.advanced.newIO;

import main.fundamentals.dictionary.Translations;
import main.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class NioObjects {


    final String wordsFileLanguageFrom = "Resource/Fundamentals/Dictionary/romanian_words.txt";
    final String wordsFileLanguageTo = "Resource/Fundamentals/Dictionary/english_words.txt";

    final String roEnDictionaryFile = "Resource/Advanced/NewIO/roEnDictionary.map";


    Map<String, String> roEnDictionary;


    @BeforeEach
    public void create_dictionaries_from_files() throws Exception {

        roEnDictionary = Translations.getDictionary(
                wordsFileLanguageFrom,
                wordsFileLanguageTo);

    }


    @Test
    public void create_dictionary_test() throws Exception {

        System.out.println(roEnDictionary);

        roEnDictionary.put("zebra", "zebra");
        System.out.println(roEnDictionary);


        final Path outFilePath = Paths.get(
                "C:/Users/dan.rusu.IN/Desktop/SDA/learnJava/",
                roEnDictionaryFile);

        System.out.println(outFilePath.toString());

        FileUtils.write(
                outFilePath,
                roEnDictionary);
    }


    @Test
    public void read_dictionary_test() throws Exception {

        roEnDictionary = FileUtils.read(
                FileUtils.getLocalPath(roEnDictionaryFile),
                new TreeMap<String, String>()
        );

        System.out.println(roEnDictionary);
    }

}
