package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.WaitingRoom;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccinationCenterRepository;
import pt.org.upskill.ui.BaseUI.ListUI;

import java.util.List;

public class ListSNSUsersWaitingUI extends ListUI<User> {

    protected void ListSNSUserWaitingRoom() {
        // check if any Vaccination Centers
        VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().getVaccinationCenterRepository();

        if (vaccinationCenterRepository.size() == 0) {
            System.out.println("There are no Vaccination Centers...");
            return;
        }

        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepository.getContentList();
        VaccinationCenter vaccinationCenter = TiUtils.Lists.selectFromListOptions(vaccinationCenters, "Select Vaccination Center (-1 to exit): ", false);

        printTitle(String.format("Waiting Room of %s", vaccinationCenter.getName()));
        vaccinationCenter.listWaitingRoom();
    }

    @Override
    public void run() {
        printTitle("LIST WAITING ROOM");

        try {
            ListSNSUserWaitingRoom();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
