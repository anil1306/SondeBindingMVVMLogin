/*
package com.luvugoogle.sondebindingmvvmlogin.mapper

import com.luvugoogle.sondebindingmvvmlogin.domain.model.LoginModel
import com.luvugoogle.sondebindingmvvmlogin.modellogin.LoginModelResponse


class LoginMapper {

    fun toModel(loginConfigResponse: LoginModelResponse): LoginModel =
        LoginModel(
            idToken = loginConfigResponse.idToken,
            expiresIn = loginConfigResponse.expiresIn
        )

    private fun mapOptions(optionsData: List<OptionData>): List<OptionModel> =
        optionsData.map { toModel(it) }


}*/
