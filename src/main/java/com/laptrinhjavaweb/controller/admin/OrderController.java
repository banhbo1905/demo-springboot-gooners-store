package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.ItemService;
import com.laptrinhjavaweb.service.impl.OrderService;
import com.laptrinhjavaweb.service.impl.ProductService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;


@Controller(value = "orderControllerOfAdmin")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @Autowired
    private ItemService itemService;



    @RequestMapping(value = "/admin/order/list", method = RequestMethod.GET)
    public ModelAndView orderListPage(@ModelAttribute("model") OrderDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/order/list");
        int pageIndex = 1;
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        Pageable pageable = PageRequest.of(pageIndex-1, model.getMaxPageItems());
        model.setListResult(orderService.findAll(pageable));
        model.setTotalItems(orderService.getTotalItem(pageable));
        mav.addObject("model", model);
        request.setAttribute("pageIndex", pageIndex);
        return mav;
    }

    @RequestMapping(value = "/admin/order/search", method = RequestMethod.GET)
    public ModelAndView orderSearchPage(@ModelAttribute("model") OrderDTO model, HttpServletRequest request, @RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("admin/order/search");
        int pageIndex = 1;
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        Pageable pageable = PageRequest.of(pageIndex-1, model.getMaxPageItems());
        model.setListResult(orderService.searchOrder(keyword, pageable));
        model.setTotalItems(orderService.getTotalItem(keyword));
        mav.addObject("model", model);
        request.setAttribute("pageIndex", pageIndex);
        return mav;
    }

    @RequestMapping(value = "/admin/order/update", method = RequestMethod.GET)
    public String  orderUpdatePage(HttpServletRequest request) {
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        long orderId = Long.parseLong(request.getParameter("orderId"));
        OrderDTO orderDTO = orderService.findById(orderId);
        orderDTO.setStatus("SUCCESS");
        orderService.save(orderDTO);
        return "redirect:/admin/order/list?pageIndex=" + pageIndex;
    }
    @RequestMapping(value = "/admin/order/details", method = RequestMethod.GET)
    public ModelAndView  orderDetailPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/order/detail");
        long orderId = Long.parseLong(request.getParameter("orderId"));
        request.setAttribute("items", itemService.findAllByOrderId(orderId));
        request.setAttribute("order", orderService.findById(orderId));
        return mav;
    }

//    @RequestMapping(value = "/admin/product/search", method = RequestMethod.GET)
//    public ModelAndView searchListPage(@ModelAttribute("modelSearch") ProductDTO modelSearch, HttpServletRequest request, @RequestParam("keyword") String keyword) {
//        ModelAndView mav = new ModelAndView("admin/product/search");
//        int pageIndex = 1;
//        if (request.getParameter("pageIndex") != null) {
//            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//        }
//        Pageable pageable = PageRequest.of(pageIndex-1, modelSearch.getMaxPageItems());
//        modelSearch.setListResult(productService.searchProducts(keyword, pageable));
//        modelSearch.setTotalItems(productService.getTotalItem(keyword));
//        mav.addObject("modelSearch", modelSearch);
//        request.setAttribute("pageIndex", pageIndex);
//        request.setAttribute("keyword", keyword);
////        modelSearch.getTotalPages();
//        return mav;
//    }
//
//
//    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.GET)
//    public ModelAndView productEditPage(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
//        ModelAndView mav = new ModelAndView("admin/product/edit");
//        request.setAttribute("categories", categoryService.findAll());
//        return mav;
//    }
//
//
//
//    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
//    public ModelAndView productEdit(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId,
//                                    @RequestParam(name = "productName") String productName,
//                                    @RequestParam(name = "description") String description,
//                                    @RequestParam(name = "price") float price,
//                                    @RequestParam(name = "quantity") int quantity,
//                                    @RequestParam(name = "imageFile") Part imageFile) throws IOException {
//
//        ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
//
//
//        String realPath = request.getServletContext().getRealPath("/template/web/assets/images/products");
//        String fileName = Path.of(imageFile.getSubmittedFileName()).getFileName().toString();
//        imageFile.write(realPath+"/"+fileName);
//
//        CategoryDTO categoryDTO = categoryService.findById(categoryId);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setCategoryCode(categoryDTO.getCode());
//        productDTO.setName(productName);
//        productDTO.setDescription(description);
//        productDTO.setPrice(price);
//        productDTO.setQuantity(quantity);
//        productDTO.setImage(fileName);
//
//        productService.save(productDTO);
//        return mav;
//    }
//
//    @RequestMapping(value = "/admin/product/update", method = RequestMethod.GET)
//    public ModelAndView productUpdatePage(HttpServletRequest request, @RequestParam(value = "productId", required = false) Long productId) {
//        ModelAndView mav = new ModelAndView("admin/product/update");
//        request.setAttribute("categories", categoryService.findAll());
//        request.setAttribute("product", productService.findById(productId));
//        return mav;
//    }
//
//    @RequestMapping(value = "/admin/product/update", method = RequestMethod.POST)
//    public ModelAndView productUpdate(HttpServletRequest request, @RequestParam(name = "newPrice", required = false) String newPrice,
//                                      @RequestParam(name = "imageFile", required = false) Part imageFile) throws IOException {
//
//        ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
//
//        long productId = Long.parseLong(request.getParameter("productId"));
//        long categoryId = Long.parseLong(request.getParameter("categoryId"));
//        float oldprice = Float.parseFloat(request.getParameter("oldPrice"));
//        String productName = request.getParameter("productName");
//        String description = request.getParameter("description");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String image = request.getParameter("image");
//        String saleId = request.getParameter("saleId");
//
//
//
//        CategoryDTO categoryDTO = categoryService.findById(categoryId);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setId(productId);
//        productDTO.setCategoryCode(categoryDTO.getCode());
//        productDTO.setName(productName);
//        productDTO.setDescription(description);
//        productDTO.setQuantity(quantity);
//
//        if (newPrice == null || newPrice.equals("")) {
//            productDTO.setPrice(oldprice);
//        } else {
//            productDTO.setPrice(Float.parseFloat(newPrice));
//        }
//
//        if (imageFile != null && imageFile.getSize() > 0) {
//            String realPath = request.getServletContext().getRealPath("/template/web/assets/images/products");
//            String fileName = Path.of(imageFile.getSubmittedFileName()).getFileName().toString();
//            imageFile.write(realPath+"/"+fileName);
//            productDTO.setImage(fileName);
//        }
//        else {
//            productDTO.setImage(image);
//        }
//
//        productService.save(productDTO);
//        return mav;
//    }
//
//
//    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.GET)
//    public String productDelete(HttpServletRequest request) {
//        String[] productIds = request.getParameterValues("productId");
//        long [] productDelete = Arrays.stream(productIds).mapToLong(Long::parseLong).toArray();
//        productService.delete(productDelete);
//
//
//        return "redirect:/admin/product/list";
//    }
//





//    @RequestMapping(value = "/admin/product", method = RequestMethod.GET)
//    public ModelAndView productListPage(@ModelAttribute("model") ProductDTO model, HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("admin/product/list");
//        int pageIndex = 1;
//        if (request.getParameter("pageIndex") != null) {
//            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//        }
//        Pageable pageable = PageRequest.of(pageIndex-1, model.getMaxPageItems());
//        model.setListResult(productService.findAll(pageable));
//        model.setTotalItems(productService.getTotalItem(pageable));
//        mav.addObject("model", model);
//        request.setAttribute("pageIndex", pageIndex);
//        return mav;
//    }
//
//
//    @RequestMapping(value = "/admin/product-edit", method = RequestMethod.GET)
//    public ModelAndView productEditPage(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
//        ModelAndView mav = new ModelAndView("admin/product/edit");
//        request.setAttribute("categories", categoryService.findAll());
//        return mav;
//    }
//
//
//
//    @RequestMapping(value = "/admin/product-edit", method = RequestMethod.POST)
//    public ModelAndView productEdit(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId,
//                                                @RequestParam(name = "productName") String productName,
//                                                @RequestParam(name = "description") String description,
//                                                @RequestParam(name = "price") float price,
//                                                @RequestParam(name = "quantity") int quantity,
//                                                @RequestParam(name = "imageFile") Part imageFile) throws IOException {
//
//        ModelAndView mav = new ModelAndView("redirect:/admin/product");
//
//
//        String realPath = request.getServletContext().getRealPath("/template/web/assets/images/products");
//        String fileName = Path.of(imageFile.getSubmittedFileName()).getFileName().toString();
//        imageFile.write(realPath+"/"+fileName);
//
//        CategoryDTO categoryDTO = categoryService.findById(categoryId);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setCategoryCode(categoryDTO.getCode());
//        productDTO.setName(productName);
//        productDTO.setDescription(description);
//        productDTO.setPrice(price);
//        productDTO.setQuantity(quantity);
//        productDTO.setImage(fileName);
//
//        productService.save(productDTO);
//        return mav;
//    }
//
//    @RequestMapping(value = "/admin/product-update", method = RequestMethod.GET)
//    public ModelAndView productUpdatePage(HttpServletRequest request, @RequestParam(value = "productId", required = false) Long productId) {
//        ModelAndView mav = new ModelAndView("admin/product/update");
//        request.setAttribute("categories", categoryService.findAll());
//        request.setAttribute("product", productService.findById(productId));
//        return mav;
//    }
//
//    @RequestMapping(value = "/admin/product-update", method = RequestMethod.POST)
//    public ModelAndView productUpdate(HttpServletRequest request, @RequestParam(name = "newPrice", required = false) String newPrice,
//                                            @RequestParam(name = "imageFile", required = false) Part imageFile) throws IOException {
//
//        ModelAndView mav = new ModelAndView("redirect:/admin/product");
//
//        long productId = Long.parseLong(request.getParameter("productId"));
//        long categoryId = Long.parseLong(request.getParameter("categoryId"));
//        float oldprice = Float.parseFloat(request.getParameter("oldPrice"));
//        String productName = request.getParameter("productName");
//        String description = request.getParameter("description");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String image = request.getParameter("image");
//        String saleId = request.getParameter("saleId");
//
//
//
//        CategoryDTO categoryDTO = categoryService.findById(categoryId);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setId(productId);
//        productDTO.setCategoryCode(categoryDTO.getCode());
//        productDTO.setName(productName);
//        productDTO.setDescription(description);
//        productDTO.setQuantity(quantity);
//
//        if (newPrice == null || newPrice.equals("")) {
//            productDTO.setPrice(oldprice);
//        } else {
//            productDTO.setPrice(Float.parseFloat(newPrice));
//        }
//
//        if (imageFile != null && imageFile.getSize() > 0) {
//            String realPath = request.getServletContext().getRealPath("/template/web/assets/images/products");
//            String fileName = Path.of(imageFile.getSubmittedFileName()).getFileName().toString();
//            imageFile.write(realPath+"/"+fileName);
//            productDTO.setImage(fileName);
//        }
//        else {
//            productDTO.setImage(image);
//        }
//
//        productService.save(productDTO);
//        return mav;
//    }
//
//
//    @RequestMapping(value = "/admin/product-delete", method = RequestMethod.GET)
//    public String productDelete(HttpServletRequest request) {
//        String[] productIds = request.getParameterValues("productId");
//        long [] productDelete = Arrays.stream(productIds).mapToLong(Long::parseLong).toArray();
//        productService.delete(productDelete);
//
//
//        return "redirect:/admin/product";
//    }

}
