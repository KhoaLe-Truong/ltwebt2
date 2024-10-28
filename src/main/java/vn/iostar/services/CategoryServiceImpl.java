package vn.iostar.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import vn.iostar.entity.Category;
import vn.iostar.repository.CategoryRepository;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public <S extends Category> S save(S entity) {
		if(entity!=null) {
			Optional<Category> opt = findById(entity.getId());
			if (opt.isPresent() ) {
				if (StringUtils.isEmpty(entity.getName())) {
					entity.setName(opt.get().getName());
				} else {
					//lấy lại images cũ
					entity.setName(entity.getName());
				}
			}
			return categoryRepository.save(entity);
			
		} else {
			return categoryRepository.save(entity);
		}
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAllById(Iterable<Integer> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}

	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}
		
}
