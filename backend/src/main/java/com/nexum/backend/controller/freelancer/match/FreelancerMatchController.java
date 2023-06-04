package com.nexum.backend.controller.freelancer.match;


import com.nexum.backend.dto.freelancer.match.queries.GetMatchRequestsByFreelancerIdQuery;
import com.nexum.backend.services.freelancer.interfaces.FreelancerMatchServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/freelancer/{id_freelancer}/match")
@CrossOrigin(origins = "http://nexum.hopto.org:8000")
public class FreelancerMatchController {

    private final FreelancerMatchServicePort freelancerMatchServicePort;

    public FreelancerMatchController(FreelancerMatchServicePort freelancerMatchServicePort) {
        this.freelancerMatchServicePort = freelancerMatchServicePort;
    }

    @GetMapping("requests")
    public ResponseEntity<Collection<GetMatchRequestsByFreelancerIdQuery>> getMatchsRequestByFreelancerId(
            @PathVariable Long id_freelancer
    ) {
        Collection<GetMatchRequestsByFreelancerIdQuery> contratanteDTOS =
                freelancerMatchServicePort.getMatchsRequestByFreelancerId(id_freelancer);

        return ResponseEntity.status(200).body(contratanteDTOS);
    }

    @PutMapping("accept-request/contratante/{id_contratante}")
    public ResponseEntity acceptMatchRequest(
            @PathVariable Long id_freelancer,
            @PathVariable Long id_contratante
    ) {
        freelancerMatchServicePort.acceptMatchRequest(id_freelancer,id_contratante);

        return ResponseEntity.status(200).build();
    }

}
