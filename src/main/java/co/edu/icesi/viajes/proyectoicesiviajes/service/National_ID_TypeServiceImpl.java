package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.National_ID_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class National_ID_TypeServiceImpl implements National_ID_TypeService{

    @Autowired
    private National_ID_TypeRepository repository;
    @Override
    public List<National_ID_Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<National_ID_Type> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public National_ID_Type save(National_ID_Type entity) throws Exception {
        return null;
    }

    @Override
    public National_ID_Type update(National_ID_Type entity) throws Exception {
        return null;
    }

    @Override
    public void delete(National_ID_Type entity) throws Exception {

    }

    @Override
    public void deleteById(Long aLong) throws Exception {

    }

    @Override
    public void validate(National_ID_Type entity) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }
}
