package service.implement;

import org.springframework.stereotype.Service;
import service.ITransferService;
@Service
public class TransferServiceImpl implements ITransferService {
    @Override
    public double transfer(String usd) {
        int rate = 23177;
        return Double.parseDouble(usd)*rate;
    }
}
