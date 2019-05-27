package main.advanced.newIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NioTest {


    @Test
    public void test() throws IOException {

        Path luckyFolderPath = Paths.get(
                System.getProperty("user.dir"), //  C:\Users\dan.rusu.IN\Desktop\SDA\learnJava
                "Resource",
                "Fundamentals",
                "Lucky");

        Path luckyTask = luckyFolderPath.resolve("_task.txt");
        System.out.println("luckyTask.getParent: " + luckyTask.getParent());
        System.out.println("luckyTask filename: " + luckyTask.getFileName());

        Path luckyTaskCopy = luckyFolderPath
                .resolve( "output")
                .resolve( "_taskCopy.txt");

        Path luckyTaskCopy2 = luckyFolderPath
                .resolve( "output")
                .resolve( "_taskCopy2.txt");


        System.out.println("luckyTask : " +luckyTask);
        // C:\Users\dan.rusu.IN\Desktop\SDA\learnJava\Resource\Fundamentals\Lucky\_task.txt

        System.out.println("luckyTaskCopy : " +luckyTaskCopy);
        //C:\Users\dan.rusu.IN\Desktop\SDA\learnJava\Resource\Fundamentals\Lucky\output\_taskCopy.txt

        System.out.println("File size in bytes: " + Files.size(luckyTask));

        byte[] bytes = Files.readAllBytes(luckyTask);
        System.out.println(bytes.length);

        //System.out.println(Arrays.toString(bytes));


        List<String> lines = Files.readAllLines(luckyTask);
        // create file
        //Files.write(luckyTaskCopy, lines);
        final Path outputDirectory = luckyFolderPath.resolve("output");

        if (false == Files.exists(outputDirectory)) {
            Files.createDirectory(outputDirectory);
        }

        // try/catch
        if (false == Files.exists(luckyTaskCopy)) {
            Files.createFile(luckyTaskCopy);
        }

        Files.write(luckyTaskCopy, lines, StandardOpenOption.APPEND);
        // append
        Files.write(luckyTaskCopy, lines, StandardOpenOption.APPEND);

        Files.copy(luckyTask, luckyTaskCopy2);

    }


}
