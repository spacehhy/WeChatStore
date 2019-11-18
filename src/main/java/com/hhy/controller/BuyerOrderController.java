package com.hhy.controller;

import com.hhy.VO.ResultVO;
import com.hhy.converter.OrderForm2OrderDTOConverter;
import com.hhy.dto.OrderDTO;
import com.hhy.enums.ResultEnum;
import com.hhy.exception.SellException;
import com.hhy.form.OrderForm;
import com.hhy.service.OrderService;
import com.hhy.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @RequestMapping("/list")
    public ResultVO list(String openid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @RequestMapping("/detail")
    public ResultVO detail(OrderDTO orderDTO) {
        //orderService.findList()
        return ResultVOUtil.success();
    }

    //取消订单
    @RequestMapping("/cancel")
    public ResultVO cancel(OrderDTO orderDTO) {
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }

}
