package service;

import model.TransferModel;

import java.util.List;

public interface ITransferService {
    List<TransferModel> findAllTransferModel();

    TransferModel findOneTransferModel(int id);

    void insertTransferModel(TransferModel transferModel);

    void updateTransferModel(TransferModel transferModel, int id);

    void deleteTransferModel(int id);
}
