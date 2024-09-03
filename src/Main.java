public class Main {
    public static void main(String[] args) {
        try {
            FileCabinet folderFinded = new FileCabinet(new Mock().getOSFolders());

            folderFinded.findFolderByName("FOLDER 1").ifPresent(it -> {
                System.out.println(it.getName());
            });


            folderFinded.findFoldersBySize(SizeEnum.SMALL.name()).forEach(it -> {
                System.out.println(it.getName() + " | " + it.getSize());
            });

            System.out.println(folderFinded.count());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}