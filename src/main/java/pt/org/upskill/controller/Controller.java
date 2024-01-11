package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.repository.Repository;
import pt.org.upskill.repository.RepositoryOutputer;

public abstract class Controller<T, R extends Repository<T>> {

    protected final int modelCount = 5;

    protected R repository;
    protected T repositoryItem;
    protected RepositoryOutputer<T> repositoryOutputer;

    public Controller() {
        setRepository();
        repositoryOutputer = new RepositoryOutputer(repository);
        generateContentModels();
    }

    public Controller(R repository) {
        this.repository = repository;
        repositoryOutputer = new RepositoryOutputer(repository);
        generateContentModels();
    }

    public boolean confirm() {
        if (repositoryItem != null) {
            repository.save(repositoryItem);
            return true;
        }

        return false;
    }

    public void listRepositoryItem() {
        if (repositoryItem != null) {
            System.out.println(repositoryItem.toString());
        } else {
            System.out.println("Repository item is null...");
        }
    }

    public void listRepositoryContents(String header, boolean useSubTitle) {
        if (useSubTitle) {
            TiUtils.ConsoleOut.printSubTitle(header, true);
        } else {
            TiUtils.ConsoleOut.printSubSubTitle(header, true);
        }

        repositoryOutputer.listContent();
    }

    public void listRepositoryOptions(String header, boolean useSubTitle) {
        if (useSubTitle) {
            TiUtils.ConsoleOut.printSubTitle(header, true);
        } else {
            TiUtils.ConsoleOut.printSubSubTitle(header, true);
        }
        repositoryOutputer.listOptionTypes();
    }

    public T selectRepositoryOption(String header) {
        TiUtils.ConsoleOut.printSubSubTitle(header, false);
        return repositoryOutputer.selectOptionType(true);
    }

    protected boolean areContentModelsCreated() {
        return repository.size() > 0;
    }

    public abstract void generateContentModels();
    protected abstract void setRepository();
}
