package com.luisg.mywallet.ui.home.data

import com.luisg.mywallet.ui.home.view.UserViewModel

class UserAdapter(val userResponse: UserResponse) {
    fun getUserViewModel( userResponse: UserResponse) : UserViewModel{
        return UserViewModel(userResponse.userName, userResponse.userPhotoURL)
    }
}