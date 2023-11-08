package yjjeondlvry.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import yjjeondlvry.config.kafka.KafkaProcessor;
import yjjeondlvry.domain.*;

@Service
public class RiderPdaViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private RiderPdaRepository riderPdaRepository;
    //>>> DDD / CQRS
}
