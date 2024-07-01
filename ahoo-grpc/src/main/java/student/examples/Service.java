package student.examples;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service extends CalculationServiceGrpc.CalculationServiceImplBase {
    private Integer responseData;

    @Override
    public void calculate(Hub.Command request, StreamObserver<Hub.Command> responseObserver) {
        System.out.println("A CALCULATION REQUEST CAME");
        try {
            List<Integer> parsedResult = bodyToIntArr(request.getBody());
            System.out.println(summarizeEven(parsedResult));
            responseData = summarizeEven(parsedResult);
            responseObserver.onNext(Hub.Command.newBuilder().setBody(summarizeEven(parsedResult).toString()).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(Hub.Command.newBuilder().setType(-1).build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void respond(Hub.Response request, StreamObserver<Hub.Response> responseObserver) {
        responseObserver.onNext(Hub.Response.newBuilder().setBody(responseData.toString()).build());
        responseObserver.onCompleted();
    }

    public List<Integer> bodyToIntArr(String body) throws Exception {
        List<Integer> convertedData = new ArrayList<>();
        for (String content: body.split(",")){
            convertedData.add(Integer.parseInt(content));
        }
        return convertedData;
    }

    public Integer summarizeEven (List<Integer> listWithIntegers) {
        return listWithIntegers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)  //https://www.geeksforgeeks.org/sum-list-stream-filter-java/
                .sum();
    }

}
