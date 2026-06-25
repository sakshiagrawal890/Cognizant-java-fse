public class DependencyInjectionExample {
    interface CustomerRepository {
        String findCustomerNameById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerNameById(int id) {
            return "Customer-" + id;
        }
    }

    static class CustomerService {
        private final CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void printCustomer(int id) {
            System.out.println("Customer found: " + repository.findCustomerNameById(id));
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.printCustomer(42);
    }
}