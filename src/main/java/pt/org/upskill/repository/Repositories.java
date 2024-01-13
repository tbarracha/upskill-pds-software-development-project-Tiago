package pt.org.upskill.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    public static Repositories getInstance() {
        return instance;
    }

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeePositionRepository employeePositionRepository;

    private final BrandRepository brandRepository;

    private final VaccineCodeRepository vaccineCodeRepository;
    private final VaccineTechRepository vaccineTechRepository;
    private final VaccineTypeRepository vaccineTypeRepository;
    private final VaccineRepository vaccineRepository;

    private final VaccinationCenterRepository vaccinationCenterRepository;
    private final VaccinationRepository vaccinationRepository;
    private final VaccineAdministrationRepository vaccineAdministrationRepository;

    private Repositories() {
        // roles and users
        roleRepository = new RoleRepository();
        userRepository = new UserRepository();

        employeeRepository = new EmployeeRepository();
        employeePositionRepository = new EmployeePositionRepository();

        // vaccine things
        brandRepository = new BrandRepository();
        vaccineCodeRepository = new VaccineCodeRepository();
        vaccineTechRepository = new VaccineTechRepository();
        vaccineTypeRepository = new VaccineTypeRepository();
        vaccineRepository = new VaccineRepository();

        // vaccine centers & administration
        vaccinationRepository = new VaccinationRepository();
        vaccinationCenterRepository = new VaccinationCenterRepository();
        vaccineAdministrationRepository = new VaccineAdministrationRepository();
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public EmployeePositionRepository getEmployeePositionRepository() {
        return employeePositionRepository;
    }

    public BrandRepository getBrandRepository() {
        return brandRepository;
    }

    public VaccineCodeRepository getVaccineCodeRepository() {
        return vaccineCodeRepository;
    }

    public VaccineTechRepository getVaccineTechRepository() {
        return vaccineTechRepository;
    }

    public VaccineTypeRepository getVaccineTypeRepository() {
        return vaccineTypeRepository;
    }

    public VaccineRepository getVaccineRepository() {
        return vaccineRepository;
    }

    public VaccinationCenterRepository getVaccinationCenterRepository() {
        return vaccinationCenterRepository;
    }

    public VaccinationRepository getVaccinationRepository() {
        return vaccinationRepository;
    }

    public VaccineAdministrationRepository getVaccineAdministrationRepository() {
        return vaccineAdministrationRepository;
    }
}