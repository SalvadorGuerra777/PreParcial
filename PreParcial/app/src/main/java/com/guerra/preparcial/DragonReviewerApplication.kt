package com.guerra.preparcial

import android.app.Application
import com.guerra.preparcial.data.dragons
import com.guerra.preparcial.repository.DragonRepository

class DragonReviewerApplication: Application() {
    val DragonRepository : DragonRepository by lazy {
        DragonRepository(dragons)
    }
}