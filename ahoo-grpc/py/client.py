import grpc 
import hub_pb2
import hub_pb2_grpc

channel = grpc.insecure_channel('localhost:6666')
stub = hub_pb2_grpc.CalculationServiceStub(channel=channel)
response = stub.Calculate(hub_pb2.Command(type=1, body="1,2,3,4,5,6,7,8"))
