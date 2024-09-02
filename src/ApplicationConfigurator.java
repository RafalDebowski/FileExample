class ApplicationConfigurator {
    private Cabinet factory;

    Application init() throws Exception {
        String OS = System.getProperty("os.name").toLowerCase();


        if (OS.contains("windows")) {
            factory = new WindowsFactory();
            return new Application(factory);
        } else if (OS.contains("mac")) {
            factory = new MacFactory();
            return new Application(factory);
        } else if (OS.contains("linux")) {
            factory = new LinuxFactory();
            return new Application(factory);
        } else {
            throw new Exception("Error! Unknown operating system.");
        }
    }
}
