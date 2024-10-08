import java.util.List;

public class Mock {
    public List<Folder> getOSFolders() {
        //todo get folders from OS
        return List.of(
                new MultiFolder() {
                    @Override
                    public List<Folder> getFolders() {
                        return List.of(new MultiFolder() {
                            @Override
                            public List<Folder> getFolders() {
                                return List.of(new Folder() {
                                    @Override
                                    public String getName() {
                                        return "FOLDER 1";
                                    }

                                    @Override
                                    public String getSize() {
                                        return SizeEnum.SMALL.name();
                                    }
                                }, new Folder() {
                                    @Override
                                    public String getName() {
                                        return "FOLDER 2";
                                    }

                                    @Override
                                    public String getSize() {
                                        return SizeEnum.LARGE.name();
                                    }
                                }, new MultiFolder() {
                                    @Override
                                    public List<Folder> getFolders() {
                                        return List.of(new Folder() {
                                            @Override
                                            public String getName() {
                                                return "FOLDER 3";
                                            }

                                            @Override
                                            public String getSize() {
                                                return SizeEnum.LARGE.name();
                                            }
                                        });
                                    }

                                    @Override
                                    public String getName() {
                                        return "MULTIFOLDER 3";
                                    }

                                    @Override
                                    public String getSize() {
                                        return SizeEnum.MEDIUM.name();
                                    }
                                });
                            }

                            @Override
                            public String getName() {
                                return "MULTIFOLDER 2";
                            }

                            @Override
                            public String getSize() {
                                return SizeEnum.LARGE.name();
                            }
                        });
                    }

                    @Override
                    public String getName() {
                        return "MULTIFOLDER 1";
                    }

                    @Override
                    public String getSize() {
                        return SizeEnum.SMALL.name();
                    }
                }
        );
    }
}
