package com.luisg.mywallet.ui.home.data

import android.os.Handler
import com.luisg.mywallet.ui.home.FavoriteTransfer
import com.luisg.mywallet.ui.home.HomeContract

class HomeInteractor {

    fun retrieveFavoriteTransferFromCache(responseCallback: HomeContract.OnResponseCallback){
        val items = ArrayList<FavoriteTransfer>()
        val itemsDummy = ArrayList<FavoriteTransfer>()

        items.add(
            FavoriteTransfer(
                1,
                "Aura Zelaya",
                456000.000,
                "Hace 2h",
                "https://scontent-mia3-2.xx.fbcdn.net/v/t1.0-9/14264226_990768381048675_3678827443886912973_n.jpg?_nc_cat=107&_nc_sid=09cbfe&_nc_oc=AQkp70IeQCJCvUxOVu24ykiOKtCJ8fm7uMawYr0BPJvaxy0lWyIYZNc2Gjbxuv_fW0c&_nc_ht=scontent-mia3-2.xx&oh=2394e826fe0accf65ffb0f7301c8a827&oe=5EDAEE9A"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Jonathan Andrade",
                210.900,
                "Ayer",
                "https://scontent-mia3-1.xx.fbcdn.net/v/t1.0-9/89552849_10215995159447560_5414070610370232320_o.jpg?_nc_cat=101&_nc_sid=09cbfe&_nc_oc=AQladNmCLOgPFqupinxFJ0dVDG0Glwse0p0h7KFu-sG4vIrX8Xdn5UuJ70E5tOXgBCw&_nc_ht=scontent-mia3-1.xx&oh=dd2c574e7e4142a8ca8e6b4789c8f2d0&oe=5EDA02F3"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Alvaro García",
                456.000,
                "Hace 2h",
                "https://scontent-mia3-1.xx.fbcdn.net/v/t1.0-9/22687783_1463778576992925_1166199745606526923_n.jpg?_nc_cat=101&_nc_sid=09cbfe&_nc_oc=AQkhI9sPWCpZt_ELFEqv2Lbza_kGAHCD5bC5v549Fzz-6uT6RXbNXICytbwG1NPCoDk&_nc_ht=scontent-mia3-1.xx&oh=b2d4ca0fe4e4cef01f26925ab8106440&oe=5EDAC5DA"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Dilsia Andrade",
                456.000,
                "Hace 2h",
                "https://scontent-mia3-1.xx.fbcdn.net/v/t1.0-9/85035270_1081387248861048_2747909488886415360_n.jpg?_nc_cat=108&_nc_sid=09cbfe&_nc_oc=AQmj9xpaZ2Bd46NlyS-N8FR8BZwrwdeB0hsjh52hyemkNPx1AlIZjGM0ZgT3r6mB_A0&_nc_ht=scontent-mia3-1.xx&oh=daf5bbb0d038d607b75bd49c6903cf4b&oe=5EDA47F3"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Julio Garcia",
                456.000,
                "Hace 2h",
                "https://scontent-mia3-2.xx.fbcdn.net/v/t1.0-9/10245561_228841583982182_3898994195081781336_n.jpg?_nc_cat=109&_nc_sid=09cbfe&_nc_oc=AQnNlAEF9tNu6PzxBjsEscnaC6WJokOGCuz6HAV4zRVxS4yKdTfLTaxyvdE_kfZJ0co&_nc_ht=scontent-mia3-2.xx&oh=c34a7f06043df6bceab5d850e67721a1&oe=5ED9D274"
            )
        )

        itemsDummy.add(
            FavoriteTransfer(0,"",0.0,"","https://data.pixiz.com/output/user/frame/preview/400x400/1/3/3/9/3069331_726cc.jpg")
        )

        responseCallback.onResponse(itemsDummy)

        val runnable = Runnable {
            responseCallback.onResponse(items)
        }
        val handler = Handler()
        handler.postDelayed(runnable, 3000)
    }
}