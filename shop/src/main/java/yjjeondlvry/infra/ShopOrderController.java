package yjjeondlvry.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yjjeondlvry.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/shopOrders")
@Transactional
public class ShopOrderController {

    @Autowired
    ShopOrderRepository shopOrderRepository;

    @RequestMapping(
        value = "shopOrders/{id}/takeorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ShopOrder takeOrder(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /shopOrder/takeOrder  called #####");
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(
            id
        );

        optionalShopOrder.orElseThrow(() -> new Exception("No Entity Found"));
        ShopOrder shopOrder = optionalShopOrder.get();
        shopOrder.takeOrder();
        shopOrderRepository.save(shopOrder);
        return shopOrder;
    }

    @RequestMapping(
        value = "shopOrders/{id}/nottakeorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ShopOrder notTakeOrder(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /shopOrder/notTakeOrder  called #####");
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(
            id
        );

        optionalShopOrder.orElseThrow(() -> new Exception("No Entity Found"));
        ShopOrder shopOrder = optionalShopOrder.get();
        shopOrder.notTakeOrder();

        shopOrderRepository.save(shopOrder);
        return shopOrder;
    }

    @RequestMapping(
        value = "shopOrders/{id}/m",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ShopOrder menuPrepareStart(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /shopOrder/menuPrepareStart  called #####");
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(
            id
        );

        optionalShopOrder.orElseThrow(() -> new Exception("No Entity Found"));
        ShopOrder shopOrder = optionalShopOrder.get();
        shopOrder.menuPrepareStart();

        shopOrderRepository.save(shopOrder);
        return shopOrder;
    }

    @RequestMapping(
        value = "shopOrders/{id}/menupreparecomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ShopOrder menuPrepareComplete(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /shopOrder/menuPrepareComplete  called #####"
        );
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(
            id
        );

        optionalShopOrder.orElseThrow(() -> new Exception("No Entity Found"));
        ShopOrder shopOrder = optionalShopOrder.get();
        shopOrder.menuPrepareComplete();

        shopOrderRepository.save(shopOrder);
        return shopOrder;
    }
}
//>>> Clean Arch / Inbound Adaptor
