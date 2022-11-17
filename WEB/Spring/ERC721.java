package net.test.nft.domain.ethereum.util;


import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class ERC721 extends Contract {
    private static final String BINARY = "Bin file was not provided";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINT = "mint";


    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected ERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> getApproved(BigInteger _tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED,
                Arrays.<Type>asList(new Uint256(_tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _approved, BigInteger _tokenId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_APPROVE,
                Arrays.<Type>asList(new Address(_approved),
                        new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> mint(String _to,BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_MINT,
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }


    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _tokenId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TRANSFERFROM,
                Arrays.<Type>asList(new Address(_from),
                        new Address(_to),
                        new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String _from, String _to, BigInteger _tokenId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM,
                Arrays.<Type>asList(new Address(_from),
                        new Address(_to),
                        new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> ownerOf(BigInteger _tokenId) {
        final Function function = new Function(FUNC_OWNEROF,
                Arrays.<Type>asList(new Uint256(_tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF,
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setApprovalForAll(String _operator, Boolean _approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL,
                Arrays.<Type>asList(new Address(_operator),
                        new Bool(_approved)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String _from, String _to, BigInteger _tokenId, byte[] data, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM,
                Arrays.<Type>asList(new Address(_from),
                        new Address(_to),
                        new Uint256(_tokenId),
                        new DynamicBytes(data)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Boolean> isApprovedForAll(String _owner, String _operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL,
                Arrays.<Type>asList(new Address(_owner),
                        new Address(_operator)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse> responses = new ArrayList<org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse>() {
            @Override
            public org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse> responses = new ArrayList<org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse>() {
            @Override
            public org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse> responses = new ArrayList<org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse>() {
            @Override
            public org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse typedResponse = new org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<org.web3j.contracts.eip721.generated.ERC721.ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    @Deprecated
    public static ERC721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _tokenId;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _approved;

        public BigInteger _tokenId;
    }

    public static class ApprovalForAllEventResponse {
        public Log log;

        public String _owner;

        public String _operator;

        public Boolean _approved;
    }
}

