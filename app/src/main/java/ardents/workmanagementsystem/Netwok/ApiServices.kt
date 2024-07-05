package ardents.workmanagementsystem.Netwok

import ardents.workmanagementsystem.Model.LoginModel
import ardents.workmanagementsystem.Model.LoginRequest
import ardents.workmanagementsystem.Model.RegistrationModel
import ardents.workmanagementsystem.Model.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {


    @POST("api/Registration")
    suspend fun registration(
        @Body body:RegistrationRequest
    ):Response<RegistrationModel>

    @POST("api/Login")
    suspend fun login(
        @Body body:LoginRequest
    ):Response<LoginModel>
}