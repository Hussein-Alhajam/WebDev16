import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvidedServiceService {
    
    @Autowired
    private ProvidedServiceRepository providedServiceRepository;

    public List<ProvidedService> getAllProvidedServices() {
        return providedServiceRepository.findAll();
    }

    public ProvidedService getProvidedServiceById(Long id) {
        return providedServiceRepository.findById(id).orElse(null);
    }

    public ProvidedService createOrUpdateProvidedService(ProvidedService providedService) {
        return providedServiceRepository.save(providedService);
    }

    public void deleteProvidedService(Long id) {
        providedServiceRepository.deleteById(id);
    }
}
