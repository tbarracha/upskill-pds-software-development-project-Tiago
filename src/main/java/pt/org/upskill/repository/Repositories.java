package pt.org.upskill.repository;

import pt.org.upskill.domain.VaccineCode;

public class Repositories {

    private static final Repositories instance = new Repositories();
    public static Repositories getInstance() {
        return instance;
    }

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;

    private final VaccineCodeRepository vaccineCodeRepository;
    private final VaccineTechRepository vaccineTechRepository;
    private final VaccineTypeRepository vaccineTypeRepository;
    private final VaccineRepository vaccineRepository;

    private Repositories() {
        // roles and users
        roleRepository = new RoleRepository();
        userRepository = new UserRepository();

        // vaccine things
        brandRepository = new BrandRepository();
        vaccineCodeRepository = new VaccineCodeRepository();
        vaccineTechRepository = new VaccineTechRepository();
        vaccineTypeRepository = new VaccineTypeRepository();
        vaccineRepository = new VaccineRepository();
    }


    public RoleRepository roleRepository() {
        return roleRepository;
    }
    public UserRepository userRepository() {
        return userRepository;
    }

    public BrandRepository brandRepository() { return brandRepository; }
    public VaccineCodeRepository vaccineCodeRepository() { return vaccineCodeRepository; }
    public VaccineTechRepository vaccineTechRepository() { return vaccineTechRepository; }
    public VaccineTypeRepository vaccineTypeRepository() { return vaccineTypeRepository; }
    public VaccineRepository vaccineRepository() { return vaccineRepository; }

}