import java.util.*;
import java.util.stream.Collectors;

public class WindowsFactory implements Cabinet{

    private List<Folder> folders;

    public WindowsFactory(){
        this.folders = getOSFolders();
    }

    @Override
    public List<Folder> getOSFolders() {
        //todo get folders from OS
        return null;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        try {
            return folders
                    .stream()
                    .filter(folder ->
                            Objects.equals(folder.getName(), name)
                    ).findFirst();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        try {

            return folders
                    .stream()
                    .filter(folder ->
                            Objects.equals(folder.getSize(), size)
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public int count() {
        return folders.size();
    }
}
