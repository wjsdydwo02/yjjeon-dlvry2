package yjjeondlvry.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import yjjeondlvry.domain.*;

@Component
public class ClientOrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ClientOrder>> {

    @Override
    public EntityModel<ClientOrder> process(EntityModel<ClientOrder> model) {
        return model;
    }
}
