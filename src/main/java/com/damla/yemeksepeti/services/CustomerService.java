package com.damla.yemeksepeti.services;

import com.damla.yemeksepeti.dto.request.ActivateRequestDto;
import com.damla.yemeksepeti.dto.request.LoginRequestDto;
import com.damla.yemeksepeti.dto.request.RegisterRequestDto;
import com.damla.yemeksepeti.exceptions.ErrorType;
import com.damla.yemeksepeti.exceptions.YemekSepetiException;
import com.damla.yemeksepeti.mapper.ICustomerMapper;
import com.damla.yemeksepeti.repository.ICustomerRepository;
import com.damla.yemeksepeti.repository.entity.Customer;
import com.damla.yemeksepeti.repository.entity.EStatus;
import com.damla.yemeksepeti.utility.CodeGenerator;
import com.damla.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Customer register(RegisterRequestDto dto){
        Customer customer = ICustomerMapper.INSTANCE.fromSaveDto(dto);
        customer.setActivationcode(CodeGenerator.generateCode());
        String email = dto.getEmail();
        Optional<Customer> optionalemail = repository.findOptionalCustomerByEmail(email);
        if(optionalemail.isPresent())
            throw new YemekSepetiException(ErrorType.REGISTER_KULLANICI_ZATEN_KAYITLI);
        return repository.save(customer);
    }

    public Boolean login(LoginRequestDto dto) {
        Optional<Customer> optionalCustomer = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalCustomer.isEmpty()) {
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        if(!optionalCustomer.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemekSepetiException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
        return true;
    }

    public Boolean activateStatus(ActivateRequestDto dto) {
        Optional<Customer> optionalCustomer = findById(dto.getId());
        if (optionalCustomer.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        if(optionalCustomer.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemekSepetiException(ErrorType.ALREADY_ACTIVE);
        }
        if(dto.getActivationCode().equals(optionalCustomer.get().getActivationcode())){
            optionalCustomer.get().setStatus(EStatus.ACTIVE);
            update(optionalCustomer.get());
            return true;
        }else {
            throw new YemekSepetiException(ErrorType.INVALID_CODE);
        }
    }
}
