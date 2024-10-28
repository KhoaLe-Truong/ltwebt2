package vn.iostar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	//Tìm kiếm theo nội dung tên
	List<Category> findByNameContaining(String name);
	
	//Tìm kiếm vè phân trang
	Page<Category> findByNameContaining(String name, Pageable pageable);	
}
