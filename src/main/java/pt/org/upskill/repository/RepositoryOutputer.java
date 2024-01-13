package pt.org.upskill.repository;

import TiWorks.TiUtils;
import pt.org.upskill.domain.IOption;

import java.util.ArrayList;
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
        if (options.isEmpty()) {
            System.out.println("There are no options...");
        } else {
            for (int i = 0; i < options.size(); i++) {
                System.out.println(String.format("%d - %s", i, options.get(i).getOptionDetails()));
            }
        }
    }

    public <T1> void listOptionTypes(List<IOption> options, Class<T1> type) {
        if (options.isEmpty()) {
            System.out.println("There are no options...");
        } else {
            for (int i = 0; i < options.size(); i++) {
                IOption option = options.get(i);
                if (type.isInstance(option)) {
                    System.out.println(String.format("%d - %s", i, option.getOptionDetails()));
                }
            }
        }
    }

    public T selectOptionType(boolean listOptions) {
        List<IOption> options = getOptionTypes();

        if (listOptions) {
            listOptionTypes(options);
        }

        return (T) TiUtils.ConsoleIn.selectOptionFromList(options).getOptionType();
    }

    public <TT> TT selectOptionType(boolean listOptions, Class<TT> type) {
        List<IOption> options = getOptionTypes();

        if (listOptions && !options.isEmpty()) {
            int index = 0;
            for (int i = 0; i < options.size(); i++) {
                IOption option = options.get(i);
                if (type.isInstance(option)) {
                    System.out.println(String.format("%d - %s", index, option.getOptionDetails()));
                    index++;
                }
            }
        }

        try {
            return (TT) TiUtils.ConsoleIn.selectOptionFromList(options).getOptionType();
        } catch (Exception e) {
            System.out.println("Didn't find option. Returning null");
            return null;
        }
    }

    public void listRepositoryContent(String header) {
        TiUtils.ConsoleOut.printSubTitle(header, true);
        listOptionTypes();
    }
}
