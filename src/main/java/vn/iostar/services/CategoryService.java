package vn.iostar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iostar.entity.Category;


public interface CategoryService {

	Page<Category> findByNameContaining(String name, Pageable pageable);

	List<Category> findByNameContaining(String name);

	void deleteById(Integer id);

	long count();

	Optional<Category> findById(Integer id);

	List<Category> findAllById(Iterable<Integer> ids);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	<S extends Category> Optional<S> findOne(Example<S> example);

	List<Category> findAll();

	<S extends Category> S save(S entity);

	
	
}
