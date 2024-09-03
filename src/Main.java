import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            FileCabinet folderFinded = new FileCabinet();
            Folder folder = folderFinded.findFolderByName("FOLDER 1").get();
            List<Folder> test = folderFinded.findFoldersBySize("small");
            folderFinded.count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}