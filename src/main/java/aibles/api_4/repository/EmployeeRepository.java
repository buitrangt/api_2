package aibles.api_4.repository;

import aibles.api_4.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartmentID(int departmentID);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByBirthDate(Date birthDate);
}
