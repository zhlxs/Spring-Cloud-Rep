package com.sell.product.controller;

import com.sell.product.entity.ProductCategory;
import com.sell.product.entity.ProductInfo;
import com.sell.product.service.CategoryService;
import com.sell.product.service.ProductService;
import com.sell.product.utils.ResultVoUtil;
import com.sell.product.vo.ProductInfoVO;
import com.sell.product.vo.ProductVo;
import com.sell.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController
{

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	/**
	 * 1.查询所有在架商品
	 * 2.查询类目type列表
	 * 3.查询类目
	 * 4.构造数据
	 *
	 * @return
	 */
	@GetMapping("/queryUpAllList")
	public ResultVo<ProductVo> queryUpAllList()
	{
		List<ProductInfo> upAll = productService.findUpAll();
		List<Integer> typeList = upAll.stream().
				map(ProductInfo::getCategoryType).
				collect(Collectors.toList());
		List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(typeList);
		List<ProductVo> productVoList = new ArrayList<>();
		ProductVo vo = null;
		List<ProductInfoVO> productInfoVOList = null;
		ProductInfoVO productInfoVO = null;
		for (ProductCategory item : categoryList)
		{
			vo = new ProductVo();
			vo.setCategoryType(item.getCategoryType());
			vo.setCategoryName(item.getCategoryName());
			productInfoVOList = new ArrayList<>();
			for (ProductInfo info : upAll)
			{
				if (info.getCategoryType().equals(item.getCategoryType()))
				{
					productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(info, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			vo.setProductInfoVOList(productInfoVOList);
			productVoList.add(vo);
		}
		return ResultVoUtil.success(productVoList);
	}
}
