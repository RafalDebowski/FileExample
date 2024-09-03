import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {

    private List<Folder> folders;

    public FileCabinet() {
        this.folders = new Mock().getOSFolders();
    }

    private Stream<Folder> flatten() {
        ArrayList<Folder> flatmapList = new ArrayList<>();
        checkMultifolder(folders, flatmapList);
        return flatmapList.stream();
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        try {
            return flatten()
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
            return flatten()
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
        return (int) flatten().count();
    }

    private void checkMultifolder(List<Folder> multiFolder, ArrayList<Folder> flatMapList) {
        multiFolder.forEach(folder -> {
            flatMapList.add(folder);
            if (folder instanceof MultiFolder) {
                checkMultifolder(((MultiFolder) folder).getFolders(), flatMapList);
            }
        });
    }
}
