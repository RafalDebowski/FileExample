//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Application app = new ApplicationConfigurator().init();

            app.getFactory().findFolderByName("Test");
            app.getFactory().findFoldersBySize("small");
            app.getFactory().count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}