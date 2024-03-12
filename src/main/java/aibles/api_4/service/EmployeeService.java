package aibles.api_4.service;

import aibles.api_4.Employee;
import aibles.api_4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByDepartment(int departmentID) {
        return employeeRepository.findByDepartmentID(departmentID);
    }

    public List<Employee> getEmployeesByName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<Employee> getEmployeesByBirthDate(Date birthDate) {
        return employeeRepository.findByBirthDate(birthDate);
    }
}
