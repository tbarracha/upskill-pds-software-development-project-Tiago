package pt.org.upskill.repository;

import pt.org.upskill.domain.Brand;

public class BrandRepository extends Repository<Brand> {

    public Brand createBrand(String name) {
        return new Brand(name);
    }
}
