package pt.org.upskill.controller;

public class Controllers {
    private static final Controllers instance = new Controllers();
    public static Controllers getInstance() {
        return instance;
    }

    private final LoginController loginController;
    private final UserController userController;
    private final RoleController roleController;
    private final EmployeeController employeeController;
    private final EmployeePositionController employeePositionController;

    private final BrandController brandController;

    private final VaccineCodeController vaccineCodeController;
    private final VaccineTechController vaccineTechController;
    private final VaccineTypeController vaccineTypeController;
    private final VaccineController vaccineController;
    private final VaccinationController vaccinationController;
    private final VaccineAdministrationController vaccineAdministrationController;
    private final VaccinationCenterController vaccinationCenterController;

    private Controllers() {
        loginController = new LoginController();
        roleController = new RoleController();
        userController = new UserController();

        employeeController = new EmployeeController();
        employeePositionController = new EmployeePositionController();

        brandController = new BrandController();
        vaccineCodeController = new VaccineCodeController();
        vaccineTechController = new VaccineTechController();
        vaccineTypeController = new VaccineTypeController();
        vaccineController = new VaccineController();

        vaccinationCenterController = new VaccinationCenterController();

        vaccinationController = new VaccinationController();
        vaccineAdministrationController = new VaccineAdministrationController();
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public UserController getUserController() {
        return userController;
    }

    public RoleController getRoleController() {
        return roleController;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    public EmployeePositionController getEmployeePositionController() {
        return employeePositionController;
    }

    public BrandController getBrandController() {
        return brandController;
    }

    public VaccineCodeController getVaccineCodeController() {
        return vaccineCodeController;
    }

    public VaccineTechController getVaccineTechController() {
        return vaccineTechController;
    }

    public VaccineTypeController getVaccineTypeController() {
        return vaccineTypeController;
    }

    public VaccineController getVaccineController() {
        return vaccineController;
    }

    public VaccinationCenterController getVaccinationCenterController() {
        return vaccinationCenterController;
    }

    public VaccinationController getVaccinationController() {
        return vaccinationController;
    }

    public VaccineAdministrationController getVaccineAdministrationController() {
        return vaccineAdministrationController;
    }
}