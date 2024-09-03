import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Optional;

class MainTest {

    private static final FileCabinet fileCabinet = new FileCabinet(new Mock().getOSFolders());

    @org.junit.jupiter.api.Test
    public void findFolderByName() {
        String name = "FOLDER 1";
        Optional<Folder> folder = fileCabinet.findFolderByName(name);

        Assertions.assertTrue(folder.isPresent());
        folder.ifPresent(value -> Assertions.assertEquals(value.getName(), name));
        Assertions.assertNotNull(folder.get());
    }

    @org.junit.jupiter.api.Test
    public void findFoldersBySize() {
        String sizeName = SizeEnum.SMALL.name();
        List<Folder> folders = fileCabinet.findFoldersBySize(sizeName);

        Assertions.assertEquals(folders.size(), 2);
    }

    @org.junit.jupiter.api.Test
    public void count() {
        int folderCount = fileCabinet.count();

        Assertions.assertEquals(folderCount, 6);
    }

}