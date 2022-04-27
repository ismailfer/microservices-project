package com.ismail.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class RabbitMQConfig
{
    private final ConnectionFactory connectionFactory;

    /**
     * Used by producers
     *
     * @return
     */
    @Bean
    public AmqpTemplate amqpTemplate()
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // converts msg object to json

        rabbitTemplate.setMessageConverter(jacksonConverter());

        return rabbitTemplate;
    }

    /**
     * used by consumers
     *
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory()
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        factory.setMessageConverter(jacksonConverter());

        return factory;
    }

    /**
     * Converts msg to json back and forth
     * producer: converts object to json
     * consumer: converts json back to object
     *
     * @return
     */
    @Bean
    public MessageConverter jacksonConverter()
    {
        // simple msg converter
        MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();

        return jackson2JsonMessageConverter;
    }


}
