package com.davidorellana.logincomposeretrofit2.network.repository

import com.example.uhunt.models.GetVideosModels
import com.example.uhunt.models.UserProfileResponseModel
import com.example.uhunt.network.dto.LoginResponse
import com.example.uhunt.network.dto.autModels.FillProfileDataModel
import com.example.uhunt.network.dto.autModels.SignupMainResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface AuthApiService {
    @FormUrlEncoded
    @POST("auth")
    suspend fun getLogin(
        @Field("username") userName: String,
        @Field("password") password: String,
        @Header("server-key") server_key: String
    ): Response<LoginResponse>


    @FormUrlEncoded
    @POST("v1.0")
    suspend fun getConitnueWatchVideosApi(
        @Query("type") type: String,
        @Query("platform") platform: String,
        @Query("v") v: String,
        @Field("limit") limit: String,
        @Header("server-key") server_key: String,
        @Header("access-token") access_token: String,
        @Header("user-id") userId: String,
    ): Response<GetVideosModels>

    @GET("get-user-data")
    suspend fun getUserData(
        @Header("access-token") accessToken: String,
        @Header("server-key") serverKey: String,
        @Field("user_id") userId: String,
        @Field("fetch") fetch: String,
    ): Response<UserProfileResponseModel>

    @FormUrlEncoded
    @POST("create-account")
    suspend fun getSignup(
        @Field("email") email: String,
        @Field("password") password: String,
        @Header("server-key") server_key: String
    ): Response<SignupMainResponse>

    @FormUrlEncoded
    @POST("fill-user-data")
    suspend fun filldata(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("username") username: String,
        @Field("gender") gender: String,
        @Field("phone_number") phone_number: String,
        @Header("server-key") server_key: String,
        @Header("access-token") accessToken: String
    ): Response<FillProfileDataModel>

    @Multipart
    @POST("fill-user-data")
    suspend fun fillProfileApi(
        @Part("first_name") first_name: RequestBody,
        @Part("last_name") last_name: RequestBody,
        @Part("username") username: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part image: MultipartBody.Part,
        @Part("phone_number") phone_number: RequestBody,
        @Header("server-key") server_key: RequestBody,
        @Header("access-token") accessToken: RequestBody
    ): Response<FillProfileDataModel>


    @FormUrlEncoded
    @POST("auth")
    suspend fun login(
        @Header("server-key") key: String,
        @Field("username") username: String,
        @Field("password") password: String,
    ): Response<LoginResponse>
}