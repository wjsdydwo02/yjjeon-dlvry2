package yjjeondlvry.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import yjjeondlvry.domain.*;

@Component
public class ShopOrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ShopOrder>> {

    @Override
    public EntityModel<ShopOrder> process(EntityModel<ShopOrder> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/takeorder")
                .withRel("takeorder")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/nottakeorder")
                .withRel("nottakeorder")
        );
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/m").withRel("m")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/menupreparecomplete"
                )
                .withRel("menupreparecomplete")
        );

        return model;
    }
}
