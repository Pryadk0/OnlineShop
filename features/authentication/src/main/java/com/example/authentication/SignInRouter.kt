package com.example.authentication

import androidx.fragment.app.Fragment

interface SignInRouter {

    fun startLogInScreen(fromFragment: Fragment)

    fun startAuthorizedScreen(fromFragment: Fragment)


}