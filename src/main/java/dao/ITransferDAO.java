package dao;

import model.TransferModel;

import java.util.List;

public interface ITransferDAO {
    List<TransferModel> findAllTransferModel();

    TransferModel findOneTransferModel(int id);

    void insertTransferModel(TransferModel transferModel);

    void updateTransferModel(TransferModel transferModel, int id);

    void deleteTransferModel(int id);
}
