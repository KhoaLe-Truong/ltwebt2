package vn.iostar.controller.admin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;
import vn.iostar.entity.Category;
import vn.iostar.model.CategoryModel;
import vn.iostar.services.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String list(Model model) {
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("categories", listCategory);
        return "admin/categories/list";  // Điều chỉnh đường dẫn
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setIsEdit(false);
        model.addAttribute("category", categoryModel);
        return "admin/categories/addOrEdit";  // Điều chỉnh đường dẫn
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel cateModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("admin/categories/addOrEdit");  // Điều chỉnh đường dẫn
        }
        Category entity = new Category();
        BeanUtils.copyProperties(cateModel, entity);
        categoryService.save(entity);
        String message = "";
        if (cateModel.getIsEdit() == true) {
            message = "Category is Edited!!!!";
        } else {
            message = "Category is saved!!!!!";
        }
        model.addAttribute("message", message);
        return new ModelAndView("forward:/admin/categories", model);  // Điều chỉnh đường dẫn
    }

    @GetMapping("edit/{categoryId}")
    public ModelAndView edit(ModelMap model, @PathVariable("categoryId") int categoryId) {
        Optional<Category> optCategory = categoryService.findById(categoryId);
        CategoryModel cateModel = new CategoryModel();
        if (optCategory.isPresent()) {
            Category entity = optCategory.get();
            BeanUtils.copyProperties(entity, cateModel);
            cateModel.setIsEdit(true);
            model.addAttribute("category", cateModel);
            return new ModelAndView("admin/categories/addOrEdit", model);  // Điều chỉnh đường dẫn
        }
        model.addAttribute("message", "Category is not exited!!!");
        return new ModelAndView("forward:/admin/categories", model);  // Điều chỉnh đường dẫn
    }
}
