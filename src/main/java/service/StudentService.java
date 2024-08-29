//package service;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import request.CreateStudentRequest;
//import request.DeleteStudentRequest;
//import request.UpdateStudentRequest;
//import response.CreateStudentResponse;
//import response.DeleteStudentResponse;
//import response.UpdateStudentResponse;
//
//
//public class StudentService extends BaseService {
//
//    private static final String END_POINT_STUDENT = "/student";
//
//    public static CreateStudentResponse createStudent(CreateStudentRequest requestBody) {
//        return new BaseService()
//                .auth()
//                .setEndPoint(END_POINT_STUDENT)
//                .postRequest(requestBody)
//                .as(CreateStudentResponse.class);
//    }
//
//    public static UpdateStudentResponse updateStudent(UpdateStudentRequest requestBody, String studentId) {
//        return new BaseService()
//                .auth()
//                .setEndPoint(END_POINT_STUDENT)
//                .putRequest(requestBody,studentId)
//                .as(UpdateStudentResponse.class);
//    }
//
//    public static DeleteStudentResponse deleteStudent(DeleteStudentRequest requestBody) {
//        return new BaseService()
//                .auth()
//                .setEndPoint("/student")
//                .deleteRequest(requestBody)
//                .as(DeleteStudentResponse.class);
//    }
//}
