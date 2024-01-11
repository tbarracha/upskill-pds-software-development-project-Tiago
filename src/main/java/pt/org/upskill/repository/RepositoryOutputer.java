package pt.org.upskill.repository;

import TiWorks.TiUtils;
import pt.org.upskill.domain.IOption;

import java.util.List;

public class RepositoryOutputer<T> {
    protected Repository<T> repository;

    public RepositoryOutputer(Repository<T> repository) {
        this.repository = repository;
    }

    public RepositoryOutputer() {}

    public void listContent() {
        System.out.println(repository.getContentListToString());
    }

    public List<IOption> getOptionTypes() {
        return TiUtils.Lists.getClassObjectsFromArray(repository.getContentList().toArray(), IOption.class);
    }

    public void listOptionTypes() {
        listOptionTypes(getOptionTypes());
    }

    public void listOptionTypes(List<IOption> options) {
        if (options.size() > 0) {
            for (int i = 0; i < options.size(); i++) {
                System.out.println(String.format("%d - %s", i, options.get(i).getOptionDetails()));
            }
        } else {
            System.out.println("There are no options...");
        }
    }

    public T selectOptionType(boolean listOptions) {
        List<IOption> options = getOptionTypes();

        if (listOptions) {
            listOptionTypes(options);
        }

        return (T) TiUtils.ConsoleIn.selectOptionFromList(options).getOptionType();
    }

    public void listRepositoryContent(String header) {
        TiUtils.ConsoleOut.printSubTitle(header, true);
        listOptionTypes();
    }
}
