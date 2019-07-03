package guru.springframework.bootstrap;

import guru.springframework.Domain.Category;
import guru.springframework.Domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();

        loadCustomers();

    }

    private void loadCustomers() {
        Customer michel = new Customer();
        michel.setId(1L);
        michel.setFirstName("Michel");
        michel.setLastName("Max");

        Customer angela = new Customer();
        angela.setId(2L);
        angela.setFirstName("Angela");
        angela.setLastName("Max");

        Customer marrella = new Customer();
        marrella.setId(3L);
        marrella.setFirstName("marrella");
        marrella.setLastName("Max");

        customerRepository.save(michel);
        customerRepository.save(angela);
        customerRepository.save(marrella);

        System.out.println("Customers Loaded = "+ customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category exotic = new Category();
        exotic.setName("Exotic");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        System.out.println("Categories Loaded = "+ categoryRepository.count());
    }
}
