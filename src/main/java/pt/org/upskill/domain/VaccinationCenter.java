package pt.org.upskill.domain;

import pt.org.upskill.auth.SNSUser;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class VaccinationCenter implements IOption<VaccinationCenter>, Serializable {

    private String name;
    private String location;
    private VaccineType vaccineType;
    private WaitingRoom waitingRoom;

    public VaccinationCenter(String name, String location, VaccineType vaccineType) {
        this.name = name;
        this.location = location;
        this.vaccineType = vaccineType;
        waitingRoom = new WaitingRoom();
    }

    public VaccinationCenter(String name, String location, VaccineType vaccineType, WaitingRoom waitingRoom) {
        this.name = name;
        this.location = location;
        this.vaccineType = vaccineType;
        this.waitingRoom = waitingRoom;
    }

    public VaccinationCenter(String name, String location, VaccineType vaccineType, List<SNSUser> usersWaiting) {
        this.name = name;
        this.location = location;
        this.vaccineType = vaccineType;
        this.waitingRoom = new WaitingRoom(usersWaiting);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WaitingRoom getWaitingRoom() {
        return waitingRoom;
    }

    public int getWaitingRoomSNSUserCount() {
        return waitingRoom.size();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public boolean addSNSUserToWaitingRoom(SNSUser user) {
        return waitingRoom.addUser(user);
    }

    public boolean removeSNSUserFromWaitingRoon(SNSUser user) {
        return waitingRoom.removeUser(user);
    }

    @Override
    public String getOptionDetails() {
        return String.format("%s, %s, Vaccine { %s }", name, location, vaccineType.getOptionDetails());
    }

    @Override
    public VaccinationCenter getOptionType() {
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VaccinationCenter { ");
        sb.append(name);
        sb.append(", location: '").append(location).append('\'');
        sb.append(", vaccineType: ").append(vaccineType.getOptionDetails());
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VaccinationCenter that = (VaccinationCenter) object;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location) && Objects.equals(vaccineType, that.vaccineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, vaccineType);
    }

    public void listWaitingRoom() {
        if (waitingRoom.size() == 0) {
            System.out.println("There are no SNS Users in the waiting room...");
            return;
        }

        for (int i = 0; i < waitingRoom.size(); i++) {
            System.out.println(waitingRoom.getAtIndex(i).getOptionDetails());
        }
    }

    public SNSUser selectSNSUserInWaitingRoom() {
        return waitingRoom.selectSNSUser();
    }
}
