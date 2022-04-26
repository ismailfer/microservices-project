package com.ismail.fraud;

import com.ismail.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController
{
    private FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId)
    {
        boolean isFraud = fraudCheckService.isFraudulentCustomer(customerId);

        FraudCheckResponse resp = new FraudCheckResponse(isFraud);

        log.info("fraud check request for customer {}", customerId);

        return resp;

    }
}
